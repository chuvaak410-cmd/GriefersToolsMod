package com.spix.grieferstools.factory.impl

import com.spix.grieferstools.factory.IServerInfoCarrierFactory
import com.spix.grieferstools.model.{IPlayerInfoCarrier, IServerInfoCarrier, IUnitInfoCarrier}
import com.spix.grieferstools.model.impl.ServerInfoCarrierImpl

/** Represents the concrete factory implementation responsible for instantiating the aggregate server info carrier. */
class ServerInfoCarrierFactoryImpl extends IServerInfoCarrierFactory {
  override def create(
      modeName: String,
      wave: Int,
      mapName: Option[String],
      worldWidth: Int,
      worldHeight: Int,
      players: Seq[IPlayerInfoCarrier],
      units: Seq[IUnitInfoCarrier]
  ): IServerInfoCarrier = new ServerInfoCarrierImpl(modeName, wave, mapName, worldWidth, worldHeight, players, units)
}
