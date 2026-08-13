package com.spix.grieferstools.model.impl

import com.spix.grieferstools.model.IIdentityCarrier

/** Represents the concrete value-carrier implementation for regenerated identity credentials. */
class IdentityCarrierImpl(private val uuidValue: String, private val usidValue: String) extends IIdentityCarrier {
  override def uuid: String = uuidValue
  override def usid: String = usidValue
}
