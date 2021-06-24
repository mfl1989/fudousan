
package jp.dcnet.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录

		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/center", "/password").excludePathPatterns("/",
				"/login", "../center/**", "../bcss/**", "../images/**", "../css/**", "../js/**","/allstaff/**");

	}
	

	
}
