package com.gz.springboot.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.gz.springboot.pojo.User;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * 编写第一个spring-boot的应用
 */
@RestController//相当于@Controller和@@ResponseBody
@SpringBootApplication
public class HelloApplication {
    @RequestMapping("/hello")
    //@ResponseBody//@ResponseBody注解，就不会走视图解析器，不会返回页面，
    // 目前返回的json数据。如果不加，就走视图解析器，返回页面
    public String hello(){
        return "hello world！是的啊";
    }


    /*//自定义消息转换器；spring默认是有消息转换器的，如果springboot配置了，那么spring的默认配置就不会生效
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){
        StringHttpMessageConverter converter  = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }*/

    //fastjson的bean配置，会出现响应乱码问题
    /*@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1、需要先定义一个 convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        //3、在convert中添加配置信息.
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(fastConverter);
    }*/

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(HelloApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);//关闭banner
        springApplication.run(args);

    }

    // 目前返回的json数据。如果不加，就走视图解析器，返回页面
    //Spring Boot默认使用的json解析框架是jackson
    @RequestMapping("/getJson")
    //@ResponseBody//@ResponseBody注解，就不会走视图解析器，不会返回页面，
    public User getJson(){
        User user = new User();
        user.setId(1);
        user.setName("test1");
        user.setPassword("test1");
        user.setCreateTime(new Date());
        user.setRemarks("This is remarks2");
        return user;
    }
}
