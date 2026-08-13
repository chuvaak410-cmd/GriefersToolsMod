package com.spix.grieferstools.factory.impl

import com.spix.grieferstools.factory.IUnitInfoCarrierFactory
import com.spix.grieferstools.model.IUnitInfoCarrier
import com.spix.grieferstools.model.impl.UnitInfoCarrierImpl

/** Represents the concrete factory implementation responsible for instantiating unit info carriers. */
class UnitInfoCarrierFactoryImpl extends IUnitInfoCarrierFactory {
  override def create(typeName: String, team: String, health: Float): IUnitInfoCarrier =
    new UnitInfoCarrierImpl(typeName, team, health)
}
