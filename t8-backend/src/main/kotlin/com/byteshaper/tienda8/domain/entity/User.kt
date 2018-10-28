package com.byteshaper.tienda8.domain.entity

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.UniqueConstraint
import javax.persistence.Column
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "user")
class User: AbstractEntity() {
  
  @Column(unique = true)
  @NotEmpty
  var username: String? = null
  
  @NotEmpty
  var passwordHash: String? = null
  
  @NotEmpty
  var salt: String? = null
}