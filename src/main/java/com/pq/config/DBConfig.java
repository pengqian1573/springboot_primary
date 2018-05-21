package com.pq.config;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
public class DBConfig 
{

	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(env.getProperty("db.driverClassName"));
		dataSource.setJdbcUrl(env.getProperty("db.url"));
		dataSource.setUser(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("db.max_pool")));
		dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("db.min_pool")));
		dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("db.initial_size")));
		dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("db.max_idle")));
		dataSource.setAcquireIncrement(5);
		dataSource.setIdleConnectionTestPeriod(60);
		
	
		return dataSource;
	}

}
