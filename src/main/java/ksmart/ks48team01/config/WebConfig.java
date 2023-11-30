package ksmart.ks48team01.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("/home/springboot")
    private String filePath;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String rootPath = getOSFilePath();
        registry.addResourceHandler("/resources/**")
                .addResourceLocations(rootPath + filePath + "resources/")
                .setCachePeriod(3600)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    public String getOSFilePath() {
        String rootPath = "file:///";
        String os = System.getProperty("os.name").toLowerCase();

        if(os.contains("win")) {
            rootPath = "file:///c:";
        } else if(os.contains("linux")) {
            rootPath = "file:///";
        } else if(os.contains("mac")) {
            rootPath = "file:///Users/Shared";
        }
        return rootPath;
    }
}
