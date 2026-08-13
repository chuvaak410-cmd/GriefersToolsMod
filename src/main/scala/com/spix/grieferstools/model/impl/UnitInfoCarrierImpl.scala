package com.spix.grieferstools.model.impl

import com.spix.grieferstools.model.IUnitInfoCarrier

/** Represents the concrete value-carrier implementation for a single unit's observed runtime state. */
class UnitInfoCarrierImpl(private val typeNameValue: String, private val teamValue: String, private val healthValue: Float)
  extends IUnitInfoCarrier {
  override def typeName: String = typeNameValue
  override def team: String = teamValue
  override def health: Float = healthValue
}
