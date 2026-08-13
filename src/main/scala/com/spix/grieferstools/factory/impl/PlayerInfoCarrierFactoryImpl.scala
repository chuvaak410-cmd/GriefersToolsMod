package com.spix.grieferstools.factory.impl

import com.spix.grieferstools.factory.IPlayerInfoCarrierFactory
import com.spix.grieferstools.model.IPlayerInfoCarrier
import com.spix.grieferstools.model.impl.PlayerInfoCarrierImpl

/** Represents the concrete factory implementation responsible for instantiating player info carriers. */
class PlayerInfoCarrierFactoryImpl extends IPlayerInfoCarrierFactory {
  override def create(
      name: String,
      id: Int,
      uuidOpt: Option[String],
      team: String,
      health: Float,
      position: Option[(Float, Float)],
      unitTypeName: Option[String]
  ): IPlayerInfoCarrier = new PlayerInfoCarrierImpl(name, id, uuidOpt, team, health, position, unitTypeName)
}
