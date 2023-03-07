package org.example.config;

import org.example.utils.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

// 除非对代码有极好的把控能力，或者大量特殊化定制，才会考虑继承WebMvcConfigurationSupport
// 因为springboot的WebMvcAutoConfiguration配置类生效的条件是：不存在类型为WebMvcConfigurationSupport的bean的时候，才会进行默认配置
// 建议通过实现WebMvcConfigurer这种形式来实现Web MVC的自定义
@Configuration
public class SpringMvcSupport implements WebMvcConfigurer {
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置拦截器
        registry.addInterceptor(projectInterceptor).addPathPatterns("/books","/books/*");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // cors解决跨域问题
        registry.addMapping("/books/**")
                .allowedOrigins("*")
                .allowedHeaders("access-token")
                .allowedMethods("PUT", "POST", "GET", "DELETE")
                .allowCredentials(true).maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }
}
