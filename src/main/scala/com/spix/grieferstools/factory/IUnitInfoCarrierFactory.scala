package com.spix.grieferstools.factory

import com.spix.grieferstools.model.IUnitInfoCarrier

/** Represents the foundational abstraction layer for unit info carrier instantiation concerns. */
trait IUnitInfoCarrierFactory {
  def create(typeName: String, team: String, health: Float): IUnitInfoCarrier
}
