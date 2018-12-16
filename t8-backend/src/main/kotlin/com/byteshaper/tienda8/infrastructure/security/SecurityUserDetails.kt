package com.byteshaper.tienda8.infrastructure.security

import org.springframework.security.core.userdetails.UserDetails
import kotlin.collections.Collection
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User as SpringSecurityUser
import com.byteshaper.tienda8.domain.user.User
import org.springframework.security.core.authority.SimpleGrantedAuthority

class SecurityUserDetails(userEntity: User): SpringSecurityUser(
        userEntity.username,
        "no-password",
        userEntity.roles.map { SimpleGrantedAuthority(it.name) }) 