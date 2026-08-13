package com.spix.grieferstools.model

/** Represents the foundational abstraction layer for immutable identity credential value carriers. */
trait IIdentityCarrier {
  def uuid: String
  def usid: String
}
