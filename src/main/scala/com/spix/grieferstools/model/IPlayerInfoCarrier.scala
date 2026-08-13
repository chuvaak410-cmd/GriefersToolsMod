package com.spix.grieferstools.model

/** Represents the foundational abstraction layer for immutable player state value carriers. */
trait IPlayerInfoCarrier {
  def name: String
  def id: Int
  def uuidOpt: Option[String]
  def team: String
  def health: Float
  def position: Option[(Float, Float)]
  def unitTypeName: Option[String]
}
