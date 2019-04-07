package com.charlie;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * An application context Java configuration class. The usage of Java configuration
 * requires Spring Framework 3.0 or higher with following exceptions:
 * <ul>
 * <li>@EnableWebMvc annotation requires Spring Framework 3.1</li>
 * </ul>
 *
 * @author Petri Kainulainen
 */
@Configuration
@ComponentScan(basePackages = {"com.charlie"})
@EnableTransactionManagement
@ImportResource("classpath:applicationContext-persistence.xml")
@PropertySource("classpath:application.properties")
public class ApplicationContext {

    private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/jsp/";
    private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.cfg.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.charlie";

    private static final String PROPERTY_NAME_MESSAGESOURCE_BASENAME = "message.source.basename";
    private static final String PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE = "message.source.use.code.as.default.message";

    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
    	HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setJdbcUrl(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    public HikariConfig hikariConfig() {
        final HikariConfig hikariConfig = new HikariConfig();

        //more database connections don't help with performance, so use a default value based on available cores
        //http://www.dailymotion.com/video/x2s8uec_oltp-performance-concurrent-mid-tier-connections_tech
        hikariConfig.setMaximumPoolSize(Math.max(Runtime.getRuntime().availableProcessors(), 4));

        //timeout the validation query (will be done automatically through Connection.isValid())
        hikariConfig.setConnectionTimeout(10000);
        hikariConfig.setAutoCommit(false);

        hikariConfig.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));

        return hikariConfig;
    }
     
    @Bean
    public JpaTransactionManager transactionManager() throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("com.charlie");
        entityManagerFactory.setPersistenceProviderClass(HibernatePersistence.class);

        Properties jpaProterties = new Properties();
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
        jpaProterties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

        entityManagerFactory.setJpaProperties(jpaProterties);

        return entityManagerFactory;
    }

//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//
//        messageSource.setBasename(environment.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_BASENAME));
//        messageSource.setUseCodeAsDefaultMessage(Boolean.parseBoolean(environment.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE)));
//
//        return messageSource;
//    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
//        viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
//
//        return viewResolver;
//    }
}