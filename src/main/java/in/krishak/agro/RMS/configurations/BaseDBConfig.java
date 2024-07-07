package in.krishak.agro.RMS.configurations;

import com.zaxxer.hikari.HikariConfig;
import java.util.Properties;
import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

public class BaseDBConfig extends HikariConfig {
    @Value("${spring.jpa.properties.query_timeout}")
    private String queryTimeout;

    @Value("${spring.jpa.properties.lock_timeout}")
    private String lockTimeout;

    @Value("${spring.jpa.properties.show_sql}")
    private String showSql;

    protected LocalContainerEntityManagerFactoryBean createLocalContainerEntityManagerFactoryBean(DataSource dataSource,
                                                                                                  String unitName) {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.show_sql", showSql);
        jpaProperties.setProperty("javax.persistence.query.timeout", queryTimeout);
        jpaProperties.setProperty("jakarta.persistence.query.timeout", queryTimeout);
        jpaProperties.setProperty("javax.persistence.lock.timeout", lockTimeout);
        jpaProperties.setProperty("jakarta.persistence.lock.timeout", lockTimeout);
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManager.setPersistenceUnitName(unitName);
        entityManager.setPackagesToScan("in.krishak.agro.RMS.models");
        entityManager.setJpaProperties(jpaProperties);
        return entityManager;
    }

    protected PlatformTransactionManager createTxnManager(EntityManagerFactory entityManagerFactory) {
        long timeoutInMs = Long.parseLong(queryTimeout);
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
        jpaTransactionManager.setDefaultTimeout((int) (timeoutInMs / 1000L));
        return jpaTransactionManager;
    }
}
