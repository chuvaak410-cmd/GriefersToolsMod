package com.spix.grieferstools.strategy

import com.spix.grieferstools.model.IIdentityCarrier

/** Represents the foundational abstraction layer for the identity credential regeneration execution algorithm. */
trait IIdentityRegenerationExecutionStrategy {
  def execute(): IIdentityCarrier
}
