package com.example.custom.starter;

import org.apache.commons.beanutils.MethodUtils;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CustomOnPropertyCondition extends SpringBootCondition {


    public CustomOnPropertyCondition() {
    }

    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {


        List<AnnotationAttributes> allAnnotationAttributes = this.annotationAttributesFromMultiValueMap(metadata.getAllAnnotationAttributes(CustomConditionalOnProperty.class.getName()));
        List<ConditionMessage> noMatch = new ArrayList();
        List<ConditionMessage> match = new ArrayList();
        Iterator var6 = allAnnotationAttributes.iterator();


        while (var6.hasNext()) {
            AnnotationAttributes annotationAttributes = (AnnotationAttributes) var6.next();
            ConditionOutcome outcome = this.determineOutcome(annotationAttributes, context.getEnvironment(), metadata);
            (outcome.isMatch() ? match : noMatch).add(outcome.getConditionMessage());
        }

        if (!noMatch.isEmpty()) {
            return ConditionOutcome.noMatch(ConditionMessage.of(noMatch));
        } else {
            return ConditionOutcome.match(ConditionMessage.of(match));
        }
    }

    private List<AnnotationAttributes> annotationAttributesFromMultiValueMap(MultiValueMap<String, Object> multiValueMap) {
        List<Map<String, Object>> mapList = new ArrayList();
        multiValueMap.forEach((key, value) -> {
            for (int i = 0; i < value.size(); ++i) {
                Map map;
                if (i < mapList.size()) {
                    map = (Map) mapList.get(i);
                } else {
                    map = new HashMap();
                    mapList.add(map);
                }

                ((Map) map).put(key, value.get(i));
            }

        });
        List<AnnotationAttributes> annotationAttributes = new ArrayList(mapList.size());
        Iterator var4 = mapList.iterator();

        while (var4.hasNext()) {
            Map<String, Object> map = (Map) var4.next();
            annotationAttributes.add(AnnotationAttributes.fromMap(map));
        }

        return annotationAttributes;
    }

    private ConditionOutcome determineOutcome(AnnotationAttributes annotationAttributes, PropertyResolver resolver, AnnotatedTypeMetadata metadata) {


//        SimpleAnnotationMetadataHandler handler = new SimpleAnnotationMetadataHandler();
//        String classname = handler.handler(metadata);
        String className = ClassNameHandler.getClassName(metadata);
        Spec spec = new Spec(annotationAttributes, className);
        List<String> missingProperties = new ArrayList();
        List<String> nonMatchingProperties = new ArrayList();
        spec.collectProperties(resolver, missingProperties, nonMatchingProperties);
        if (!missingProperties.isEmpty()) {
            return ConditionOutcome.noMatch(ConditionMessage.forCondition(CustomConditionalOnProperty.class, new Object[]{spec}).didNotFind("property", "properties").items(ConditionMessage.Style.QUOTE, missingProperties));
        } else {
            return !nonMatchingProperties.isEmpty() ? ConditionOutcome.noMatch(ConditionMessage.forCondition(CustomConditionalOnProperty.class, new Object[]{spec}).found("different value in property", "different value in properties").items(ConditionMessage.Style.QUOTE, nonMatchingProperties)) : ConditionOutcome.match(ConditionMessage.forCondition(ConditionalOnProperty.class, new Object[]{spec}).because("matched"));
        }
    }
    private static class ClassNameHandler{

       private static String getClassName(AnnotatedTypeMetadata metadata){
            try {
                return (String) MethodUtils.invokeMethod(metadata, "getClassName", null);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private static class Spec {
        private final String prefix;
        private final String havingValue;

        private final String localHavingValue;
        private final String[] names;
        private final boolean matchIfMissing;

        Spec(AnnotationAttributes annotationAttributes, String classname) {
            String prefix = annotationAttributes.getString("prefix").trim();
            if (StringUtils.hasText(prefix) && !prefix.endsWith(".")) {
                prefix = prefix + ".";
            }

            this.prefix = prefix;
//            this.havingValue = annotationAttributes.getString("havingValue");
            this.havingValue = classname;
            this.localHavingValue = classname;

            this.names = this.getNames(annotationAttributes);
            this.matchIfMissing = annotationAttributes.getBoolean("matchIfMissing");
        }

        private String[] getNames(Map<String, Object> annotationAttributes) {
            String[] value = (String[]) annotationAttributes.get("value");
            String[] name = (String[]) annotationAttributes.get("name");
            Assert.state(value.length > 0 || name.length > 0, "The name or value attribute of @ConditionalOnProperty must be specified");
            Assert.state(value.length == 0 || name.length == 0, "The name and value attributes of @ConditionalOnProperty are exclusive");
            return value.length > 0 ? value : name;
        }

        private void collectProperties(PropertyResolver resolver, List<String> missing, List<String> nonMatching) {
            String[] var4 = this.names;
            int var5 = var4.length;

            for (int var6 = 0; var6 < var5; ++var6) {
                String name = var4[var6];
                String key = this.prefix + name;

                List<String> ymlRegisterValueList = getYmlRegisterValues(resolver);
                if (ymlRegisterValueList.size() != 0) {
                    if (!this.isMatch(this.havingValue, ymlRegisterValueList)) {
                        nonMatching.add(name);
                    }
                } else if (!this.matchIfMissing) {
                    missing.add(name);
                }


            }

        }

        List<String> getYmlRegisterValues(PropertyResolver resolver) {
            int basePackages = 1<<5;

            List<String> ymlRegisterValueList= new ArrayList<>();
            String baseKey = "spring.bean.register.basePackages".trim();

            for (int i = 0; i < basePackages; i++) {
                StringBuilder sb = new StringBuilder();
                String key = sb.append(baseKey).append("[").append(i).append("]").toString();
                String ymlRegisterValue = resolver.getProperty(key);
                ymlRegisterValueList.add(ymlRegisterValue);
                if (ymlRegisterValue == null)
                    return ymlRegisterValueList;
            }

            return ymlRegisterValueList;
        }

        private boolean isMatch(String classname, List<String> ymlRegisterValueList) {

            for (String ymlRegisterValue : ymlRegisterValueList) {

                if (!StringUtils.hasLength(ymlRegisterValue)) {
                    return classname.equalsIgnoreCase(ymlRegisterValue);
                }

                if (classname.startsWith(ymlRegisterValue)) {
                    return true;
                }

            }

            return false;

        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("(");
            result.append(this.prefix);
            if (this.names.length == 1) {
                result.append(this.names[0]);
            } else {
                result.append("[");
                result.append(StringUtils.arrayToCommaDelimitedString(this.names));
                result.append("]");
            }

            if (StringUtils.hasLength(this.havingValue)) {
                result.append("=").append(this.havingValue);
            }

            result.append(")");
            return result.toString();
        }
    }
}
