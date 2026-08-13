package com.spix.grieferstools.factory

import com.spix.grieferstools.model.{IPlayerInfoCarrier, IServerInfoCarrier, IUnitInfoCarrier}

/** Represents the foundational abstraction layer for aggregate server info carrier instantiation concerns. */
trait IServerInfoCarrierFactory {
  def create(
      modeName: String,
      wave: Int,
      mapName: Option[String],
      worldWidth: Int,
      worldHeight: Int,
      players: Seq[IPlayerInfoCarrier],
      units: Seq[IUnitInfoCarrier]
  ): IServerInfoCarrier
}
