package com.spix.grieferstools.factory.impl

import com.spix.grieferstools.factory.IIdentityCarrierFactory
import com.spix.grieferstools.model.IIdentityCarrier
import com.spix.grieferstools.model.impl.IdentityCarrierImpl

/** Represents the concrete factory implementation responsible for instantiating identity carriers. */
class IdentityCarrierFactoryImpl extends IIdentityCarrierFactory {
  override def create(uuid: String, usid: String): IIdentityCarrier = new IdentityCarrierImpl(uuid, usid)
}
