package com.cerradoSic.control.configration;


import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cerradoSic.control.Interceptors.AutorizationInterceptor;


@Configuration
@ComponentScan({ "com.cerradoSic.control.controller" })
@EnableWebMvc
public class AppSpringConfig extends WebMvcConfigurerAdapter{

  private static final String DEFAULT_LOCALE_LANGUAGE="pt";
  private static final String DEFAULT_LOCALE_COUNTRY="BR";
  private static final String DEFAULT_ENCODE="ISO-8859-1";
  private static final Locale DEFAULT_LOCALE = new Locale(DEFAULT_LOCALE_LANGUAGE, DEFAULT_LOCALE_COUNTRY);
  
  @Bean
  public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver ivr = new InternalResourceViewResolver();
    ivr.setPrefix("/WEB-INF/");
    ivr.setSuffix(".jsp");
    return ivr;
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
      new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:i18Bundles/messages");
    messageSource.setDefaultEncoding(DEFAULT_ENCODE);
    return messageSource;
  }

  @Bean
  public LocaleResolver localeResolver() {
    return LocaleResolverConfigFactory.createLocaleResolverBySession(DEFAULT_LOCALE);
  }
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
    interceptor.setParamName("locale");
    registry.addInterceptor(interceptor);
    AutorizationInterceptor ai = new AutorizationInterceptor();
    registry.addInterceptor(ai);
  }
}
