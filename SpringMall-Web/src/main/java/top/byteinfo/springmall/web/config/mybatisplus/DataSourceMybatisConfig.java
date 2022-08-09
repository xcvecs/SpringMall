package top.byteinfo.springmall.web.config.mybatisplus;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
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
import java.util.Objects;

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
        public DataSource first() {
            HikariDataSource hikariDataSource = new HikariDataSource();
            hikariDataSource.setJdbcUrl(env.getProperty("spring.datasource.DS1blog.url"));
            hikariDataSource.setUsername(env.getProperty("spring.datasource.DS1blog.username"));
            hikariDataSource.setPassword(env.getProperty("spring.datasource.DS1blog.password"));
            hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            return hikariDataSource;
        }

        @Primary
        @Bean(name = "DS2")
        public DataSource second() {
            HikariDataSource hikariDataSource = new HikariDataSource();
            hikariDataSource.setJdbcUrl(env.getProperty("spring.datasource.DS2cd_blog.url"));
            hikariDataSource.setUsername(env.getProperty("spring.datasource.DS2cd_blog.username"));
            hikariDataSource.setPassword(env.getProperty("spring.datasource.DS2cd_blog.password"));
            hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            return hikariDataSource;
        }
    }


    /**
     * 该配置从 mybatis配置 修改而来。基于mapperScan注解
     * @see org.mybatis.spring.annotation.MapperScannerRegistrar
     * @see org.springframework.beans.factory.support.BeanDefinitionBuilder
     * {@link  org.mybatis.spring.mapper.MapperScannerConfigurer}
     *
     * 该配置可靠性基于 mybatisplus 对mybatis 兼容性。如官网宣传 无侵入：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
     * todo 但仍然替换了 SqlSessionFactoryBean 为 MybatisSqlSessionFactoryBean
     * @see MybatisSqlSessionFactoryBean
     * @see SqlSessionFactoryBean
     *
     */
    @Configuration
    @MapperScan(basePackages = {"top.byteinfo.springmall.mbg.mapper","top.byteinfo.springmall.web.model.blog.dao"}, sqlSessionTemplateRef = "druid1SqlSessionTemplate")
    public class Druid1 {

        /**
         * @param dataSource
         * @return
         * @throws Exception
         */
        @Primary
        @Bean(name = "druid1SqlSessionFactory")
        public SqlSessionFactory sqlSessionFactory(@Qualifier("DS1") DataSource dataSource) throws Exception {

            MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//            SqlSessionFactoryBean mybatisSqlSessionFactoryBean = new SqlSessionFactoryBean();
            mybatisSqlSessionFactoryBean.setDataSource(dataSource);
            mybatisSqlSessionFactoryBean.setMapperLocations(
                    new PathMatchingResourcePatternResolver()
                            .getResources(Objects.requireNonNull(env.getProperty("spring.datasource.DS1blog.mybatis-plus.mapper-locations")))
            );
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

    @Configuration
    @MapperScan(basePackages = "top.byteinfo.springmall.web.model.cdblog.dao", sqlSessionTemplateRef = "druid2SqlSessionTemplate")
    public class Druid2 {

        @Primary
        @Bean(name = "druid2SqlSessionFactory")
        public SqlSessionFactory sqlSessionFactory(@Qualifier("DS2") DataSource dataSource) throws Exception {
            MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
//            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource);
            sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources(Objects.requireNonNull(env.getProperty("spring.datasource.DS2cd_blog.mybatis-plus.mapper-locations"))));
            return sessionFactoryBean.getObject();
        }

        @Primary
        @Bean("druid2TransactionManager")
        public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("DS2") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Primary
        @Bean("druid2SqlSessionTemplate")
        public SqlSessionTemplate sqlSessionTemplate(@Qualifier("druid2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }
}
