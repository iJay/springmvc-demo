package org.example.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

// AbstractDispatcherServletInitializer SpringMVC提供的快速初始化Web3.0容器的抽象类
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    // 创建Servlet容器时，加载SpringMVC对应的bean并放入WebApplicationContext对象范围中
    // WebApplicationContext的作用范围为ServletContext范围，即整个web容器范围。
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        // 初始化WebApplicationContext对象
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringMvcConfig.class);
        // 加载指定配置类
        return context;
    }

    // 设定SpringMVC对应的请求映射路径
    // 这里设置为/表示拦截所有请求，任意请求都将转入到SpringMVC进行处理。
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 加载非SpringMVC对应的bean，使用当前方法
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }

}
