package com.byteshaper.tienda8.domain.user

interface UserRepo {
  
  fun findUserByUsername(username: String): User?
}