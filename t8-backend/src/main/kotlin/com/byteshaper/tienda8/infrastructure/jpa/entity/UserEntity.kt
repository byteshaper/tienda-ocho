package com.byteshaper.tienda8.infrastructure.jpa.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint
import javax.persistence.Column
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "user")
class UserEntity: AbstractEntity() {
  
  @Column(unique = true)
  @NotEmpty
  var username: String? = null
  
  @NotEmpty
  var encryptedPassword: String? = null
  
  @NotEmpty
  var salt: String? = null
}