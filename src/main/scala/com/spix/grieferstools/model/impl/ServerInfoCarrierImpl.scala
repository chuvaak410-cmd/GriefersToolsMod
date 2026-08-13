package com.spix.grieferstools.model.impl

import com.spix.grieferstools.model.{IPlayerInfoCarrier, IServerInfoCarrier, IUnitInfoCarrier}

/** Represents the concrete value-carrier implementation for the aggregate server snapshot. */
class ServerInfoCarrierImpl(
    private val modeNameValue: String,
    private val waveValue: Int,
    private val mapNameValue: Option[String],
    private val worldWidthValue: Int,
    private val worldHeightValue: Int,
    private val playersValue: Seq[IPlayerInfoCarrier],
    private val unitsValue: Seq[IUnitInfoCarrier]
) extends IServerInfoCarrier {
  override def modeName: String = modeNameValue
  override def wave: Int = waveValue
  override def mapName: Option[String] = mapNameValue
  override def worldWidth: Int = worldWidthValue
  override def worldHeight: Int = worldHeightValue
  override def players: Seq[IPlayerInfoCarrier] = playersValue
  override def units: Seq[IUnitInfoCarrier] = unitsValue
}
