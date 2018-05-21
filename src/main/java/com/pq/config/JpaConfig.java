package com.pq.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//此处是你dao文件所在的包名
@EnableJpaRepositories("com.pq.dao")
@EnableTransactionManagement
public class JpaConfig 
{

	@Autowired
    private DataSource dataSource;
	@Autowired
	private Environment env;
	
	private  String HBM2DDL_AUTO="hibernate.hbm2ddl.auto"; //建表策略
	private  String SHOW_SQL="hibernate.show_sql";   //显示SQL语句
	private  String FORMAT_SQL="hibernate.format_sql";//格式化SQL
	private  String DIALECT="hibernate.dialect";//方言

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        //此处com.*.model是你的java bean所在的包名
        factory.setPackagesToScan("com.pq.model");
        factory.setDataSource(dataSource);
        factory.setJpaPropertyMap(getProperties()); //参数
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
    
    
    
    public  Map<String, Object> getProperties()
    {
        Map<String, Object> jpaProperties = new HashMap<String, Object>();		
        jpaProperties.put("hibernate.ejb.naming_strategy","org.hibernate.cfg.ImprovedNamingStrategy");
        jpaProperties.put("hibernate.jdbc.batch_size",50);
        jpaProperties.put(HBM2DDL_AUTO,env.getProperty(HBM2DDL_AUTO));
        jpaProperties.put(SHOW_SQL,env.getProperty(SHOW_SQL));
        jpaProperties.put(FORMAT_SQL,env.getProperty(FORMAT_SQL));
        jpaProperties.put(DIALECT,env.getProperty(DIALECT));
        return jpaProperties;
    	
    }
}
