package com.byteshaper.tienda8.infrastructure.security

import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAuthorizationServer
class AuthorizationConfig: AuthorizationServerConfigurerAdapter() {
  
  override fun configure(security: AuthorizationServerSecurityConfigurer) {
    
  }
  
  override fun configure(clients: ClientDetailsServiceConfigurer) {
    
  }
  
  override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
    
  }
}