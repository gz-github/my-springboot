package com.gz.springboot.javaconfig;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration//通过注解来说明该类是Spring的配置，相当于一个xml文件
@ComponentScan(basePackages = "com.gz.springboot.javaconfig")//配置扫描包
//配置读取外部的资源文件：1：要配置多个的话，隔开；
// 2：如果配置资源不存在的话ignoreResourceNotFound = true忽略找不到的资源文件
@PropertySource(value= {"classpath:jdbc.properties"})
public class SpringConfig {
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean//通过改配置表明是一个bean对象，相当于xml中的<bean>
    public UserDao getUserDao(){
        return new UserDao();//直接new对象做演示
    }

    @Bean(destroyMethod = "close")
    public BoneCPDataSource boneCPDataSource(){
      BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
      boneCPDataSource.setDriverClass(jdbcDriver);
      boneCPDataSource.setJdbcUrl(jdbcUrl);
      boneCPDataSource.setUsername(jdbcUsername);
      boneCPDataSource.setPassword(jdbcPassword);
      // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
      boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
      // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
      boneCPDataSource.setIdleMaxAgeInMinutes(30);
      // 每个分区最大的连接数
      boneCPDataSource.setMaxConnectionsPerPartition(100);
      // 每个分区最小的连接数
      boneCPDataSource.setMinConnectionsPerPartition(5);
      return boneCPDataSource;
    }
}
