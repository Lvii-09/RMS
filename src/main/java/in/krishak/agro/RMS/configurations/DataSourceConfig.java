package in.krishak.agro.RMS.configurations;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.hibernate.cfg.PersistenceSettings.PERSISTENCE_UNIT_NAME;

@Configuration
@ConfigurationProperties("spring.datasource")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryWrite",
        transactionManagerRef = "transactionManagerWrite",
        basePackages = {"in.krishak.agro.RMS.daos"}
)
@Primary
public class DataSourceConfig extends BaseDBConfig {

    @Bean
    @Primary
    public HikariDataSource primaryDataSource() {
         return new HikariDataSource(this);
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryWrite(@Qualifier("primaryDataSource") HikariDataSource primaryDataSource) {
        return createLocalContainerEntityManagerFactoryBean(primaryDataSource, PERSISTENCE_UNIT_NAME);
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManagerWrite(EntityManagerFactory entityManagerFactoryWrite) {
        return createTxnManager(entityManagerFactoryWrite);
    }
}
