package com.byteshaper.tienda8.infrastructure.security

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UserDetails

class ApplicationUserDetailsService: UserDetailsService {
  
  override fun loadUserByUsername(username: String?): UserDetails? {
    TODO()
  }
}