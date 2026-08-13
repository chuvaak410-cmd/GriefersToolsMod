package com.spix.grieferstools.model

/** Represents the foundational abstraction layer for the aggregate server snapshot value carrier. */
trait IServerInfoCarrier {
  def modeName: String
  def wave: Int
  def mapName: Option[String]
  def worldWidth: Int
  def worldHeight: Int
  def players: Seq[IPlayerInfoCarrier]
  def units: Seq[IUnitInfoCarrier]
}
