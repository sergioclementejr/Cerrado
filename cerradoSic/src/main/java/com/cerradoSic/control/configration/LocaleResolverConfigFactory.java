package com.cerradoSic.control.configration;

import java.util.Locale;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class LocaleResolverConfigFactory {
  private static final String DEFAULT_COOKIE_NAME="localeCookie";
  
  private LocaleResolverConfigFactory() {}
  
  public static LocaleResolver createLocaleResolverByCookie(Locale locale){
    CookieLocaleResolver resolver = new CookieLocaleResolver();
    resolver.setDefaultLocale(locale);
    resolver.setCookieName(DEFAULT_COOKIE_NAME);
    resolver.setCookieMaxAge(4800);
    return resolver;
  }
  
  public static LocaleResolver createLocaleResolverBySession(Locale locale){
    SessionLocaleResolver  resolver = new SessionLocaleResolver ();
    resolver.setDefaultLocale(locale);
    return resolver;
  }
}
