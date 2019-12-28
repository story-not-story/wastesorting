package school.wastesorting.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import school.wastesorting.interceptor.CrossInterceptor;
import school.wastesorting.interceptor.LoginInterceptor;
import javax.annotation.Resource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private CrossInterceptor crossInterceptor;

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 跨域拦截器需放在最上面
        registry.addInterceptor(crossInterceptor).addPathPatterns("/**");
        // 校验token的拦截器
        registry.addInterceptor(loginInterceptor).addPathPatterns("/wastesorting/thing/**");
    }
}