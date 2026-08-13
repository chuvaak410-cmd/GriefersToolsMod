package com.spix.grieferstools.model

/** Represents the foundational abstraction layer for immutable unit state value carriers. */
trait IUnitInfoCarrier {
  def typeName: String
  def team: String
  def health: Float
}
