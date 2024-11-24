package ling.victoria.contact.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将 /opt/static 目录下的文件映射到 /assets/** 路径下
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("file:/www/wwwroot/project/upload/");
    }
}
