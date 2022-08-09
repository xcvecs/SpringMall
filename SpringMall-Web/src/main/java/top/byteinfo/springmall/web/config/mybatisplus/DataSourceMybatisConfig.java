package top.byteinfo.springmall.web.config.mybatisplus;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * TODO DataSourceTransactionManager
 */
@Configuration
@PropertySource("classpath:application.yml")
public class DataSourceMybatisConfig {

    /**
     * todo what happens
     *
     */
//    @Bean todo 等同 @PropertySource("classpath:application.yml")
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer placeholderConfigurer =
//                new PropertySourcesPlaceholderConfigurer();
//        placeholderConfigurer.setLocations(new ClassPathResource("application.yml"));
//        return placeholderConfigurer;
//    }
    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @Configuration
    public class DataSourcesConfig {

        @Primary
        @Bean(name = "DS1")
//    @ConfigurationProperties("spring.datasource.hikari.h1")
        public DataSource first() {
            HikariDataSource hikariDataSource = new HikariDataSource();
            hikariDataSource.setJdbcUrl(env.getProperty(""));
            hikariDataSource.setUsername("root");
            hikariDataSource.setPassword("root");
            hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            return hikariDataSource;
        }

        @Primary
        @Bean(name = "DS2")
//    @ConfigurationProperties("spring.datasource.hikari.h1")
        public DataSource second() {
            HikariDataSource hikariDataSource = new HikariDataSource();
            hikariDataSource.setJdbcUrl("jdbc:mysql://localhost/entity?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
            hikariDataSource.setUsername("root");
            hikariDataSource.setPassword("root");
            hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            return hikariDataSource;
        }
    }


    /**
     * @see org.mybatis.spring.annotation.MapperScannerRegistrar
     * @see org.springframework.beans.factory.support.BeanDefinitionBuilder
     * {@link  org.mybatis.spring.mapper.MapperScannerConfigurer}
     * 
     */
    @Configuration
    @MapperScan(basePackages = {"top.byteinfo.springmall.mbg.mapper"}, sqlSessionTemplateRef = "druid1SqlSessionTemplate")
    public class Druid1 {

        /**
         * {@link org.mybatis.spring.mapper.MapperScannerConfigurer#setSqlSessionFactoryBeanName(String)}
         * @param dataSource
         * @return
         * @throws Exception
         */
        @Primary
        @Bean(name = "druid1SqlSessionFactory")
        public SqlSessionFactory sqlSessionFactory(@Qualifier("DS1") DataSource dataSource) throws Exception {
//            MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
            SqlSessionFactoryBean mybatisSqlSessionFactoryBean = new SqlSessionFactoryBean();
            mybatisSqlSessionFactoryBean.setDataSource(dataSource);
            mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/druid1/*.xml"));
            return mybatisSqlSessionFactoryBean.getObject();
        }

        @Primary
        @Bean("druid1TransactionManager")
        public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("DS1") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Primary
        @Bean("druid1SqlSessionTemplate")
        public SqlSessionTemplate sqlSessionTemplate(@Qualifier("druid1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

//    @Configuration
//    @MapperScan(basePackages = "top.byteinfo.springmall.mbg.mapper", sqlSessionTemplateRef = "druid2SqlSessionTemplate")
//    public class Druid2 {
//
//        @Primary
//        @Bean(name = "druid2SqlSessionFactory")
//        public SqlSessionFactory sqlSessionFactory(@Qualifier("DS2") DataSource dataSource) throws Exception {
//            MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//            sessionFactoryBean.setDataSource(dataSource);
//            sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/druid2/*Mapper.xml"));
//            return sessionFactoryBean.getObject();
//        }
//
//        @Primary
//        @Bean("druid2TransactionManager")
//        public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("DS2") DataSource dataSource) {
//            return new DataSourceTransactionManager(dataSource);
//        }
//
//        @Primary
//        @Bean("druid2SqlSessionTemplate")
//        public SqlSessionTemplate sqlSessionTemplate(@Qualifier("druid2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//            return new SqlSessionTemplate(sqlSessionFactory);
//        }
//    }
}
