package top.byteinfo.springmall.web.config.mybatisplus;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * todo
 *
 */
//@Configuration
public class AdvancedDataSourceConfig {



//    @Configuration
//    @PropertySource("classpath:application.yml")
    public class DataSourcesConfig {
        private Environment env;

//        @Autowired
        public void setEnv(Environment env) {
            this.env = env;
        }

        @Primary
        @Bean(name = "DS1")
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
     * datasource->SqlSessionFactory->SqlSessionTemplate>>
     *  registry.registerBeanDefinition(beanName, builder.getBeanDefinition(){MapperScannerConfigurer});
     * @return
     */
    @Bean
    MapperScannerConfigurer datasourceConfig(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("");
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("");
        mapperScannerConfigurer.setBasePackage("");
        return mapperScannerConfigurer;
    }


    @Primary
    @Bean(name = "druid1SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("DS1") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/druid1/*.xml"));
        return sessionFactoryBean.getObject();
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
