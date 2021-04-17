package com.hive.ansj.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
    basePackages = ["com.hive.ansj.repository"],
    entityManagerFactoryRef = "an",
    transactionManagerRef = "imsi"
)
class DataContextConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    fun dataSource(): DataSource = DataSourceBuilder.create().build()

    @Bean
    fun entityManager(): LocalContainerEntityManagerFactoryBean =
        (LocalContainerEntityManagerFactoryBean()).apply{
            dataSource = dataSource()
            setPackagesToScan("com.hive.ansj.entity")
            jpaVendorAdapter = HibernateJpaVendorAdapter()
        }

    @Bean
    fun transactionManager() = JpaTransactionManager(entityManager().`object`!!)
}