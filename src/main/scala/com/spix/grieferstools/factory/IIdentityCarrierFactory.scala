package com.spix.grieferstools.factory

import com.spix.grieferstools.model.IIdentityCarrier

/** Represents the foundational abstraction layer for identity carrier instantiation concerns. */
trait IIdentityCarrierFactory {
  def create(uuid: String, usid: String): IIdentityCarrier
}
