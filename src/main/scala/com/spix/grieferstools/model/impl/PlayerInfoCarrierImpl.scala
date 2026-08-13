package com.spix.grieferstools.model.impl

import com.spix.grieferstools.model.IPlayerInfoCarrier

/** Represents the concrete value-carrier implementation for a single player's observed runtime state. */
class PlayerInfoCarrierImpl(
    private val nameValue: String,
    private val idValue: Int,
    private val uuidValue: Option[String],
    private val teamValue: String,
    private val healthValue: Float,
    private val positionValue: Option[(Float, Float)],
    private val unitTypeNameValue: Option[String]
) extends IPlayerInfoCarrier {
  override def name: String = nameValue
  override def id: Int = idValue
  override def uuidOpt: Option[String] = uuidValue
  override def team: String = teamValue
  override def health: Float = healthValue
  override def position: Option[(Float, Float)] = positionValue
  override def unitTypeName: Option[String] = unitTypeNameValue
}
