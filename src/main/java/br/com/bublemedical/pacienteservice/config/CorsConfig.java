package br.com.bublemedical.pacienteservice.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class CorsConfig {
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins("http://localhost:4200",
//						"http://buble-medical-web.s3-website.us-east-2.amazonaws.com",
//						"https://8e0ljpgcfb.execute-api.us-east-2.amazonaws.com",
//						"https://nidbwm6mhg.execute-api.us-east-2.amazonaws.com")
//				.allowedMethods("POST", "PUT", "DELETE", "OPTIONS");
//			}
//		};
//	}
	
	/*@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		System.err.print("PASSOU");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(false);
		config.addAllowedOrigin("https://8e0ljpgcfb.execute-api.us-east-2.amazonaws.com");
		config.addAllowedHeader("*");
		config.addAllowedMethod("POST");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}*/

}
