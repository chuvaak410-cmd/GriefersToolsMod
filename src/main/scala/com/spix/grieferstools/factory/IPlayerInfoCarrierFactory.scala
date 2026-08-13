package com.spix.grieferstools.factory

import com.spix.grieferstools.model.IPlayerInfoCarrier

/** Represents the foundational abstraction layer for player info carrier instantiation concerns. */
trait IPlayerInfoCarrierFactory {
  def create(
      name: String,
      id: Int,
      uuidOpt: Option[String],
      team: String,
      health: Float,
      position: Option[(Float, Float)],
      unitTypeName: Option[String]
  ): IPlayerInfoCarrier
}
