package com.byteshaper.tienda8.domain.user

enum class Role {
  ADMIN,     // all permissions to do the basic setup and all configuration for a specific event
  DISPATCHER // normal work: adding and removing people from tents etc.
}