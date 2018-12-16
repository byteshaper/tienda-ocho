package com.byteshaper.tienda8.infrastructure.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import com.byteshaper.tienda8.domain.user.UserRepo

class SecurityUserDetailsService(val userRepo: UserRepo): UserDetailsService {
  
  override fun loadUserByUsername(username: String?): UserDetails? {
    
    if(username == null) {
      return null;
    }
    
    val user = userRepo.findUserByUsername(username)

    if (user != null) {
      return SecurityUserDetails(user)
    }
    
    return null
  }
}