package dima.and.lesha.dao.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("dima.and.lesha.dao.api")
@PropertySource("classpath:db.properties")
public class PersistenceConfig {

    @Autowired
    private Environment environment;

    private String getProperty(String user) {
        return environment.getProperty(user);
    }

    @Bean
    @Profile("embedded")
    public DataSource embeddedDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScripts("embeddedDatabase/ddl.sql", "embeddedDatabase/data.sql")
                .build();
    }

    @Bean
    @Profile("local")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getProperty("driverClassName"));
        dataSource.setUrl(getProperty("jdbc.url"));
        dataSource.setUsername(getProperty("jdbc.username"));
        dataSource.setPassword(getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.setPackagesToScan("dima.and.lesha.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
        return entityManagerFactoryBean(dataSource).getObject();
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.format_sql", getProperty("hibernate.format_sql"));
        properties.setProperty("hibernate.hbm2ddl.auto", getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

}
