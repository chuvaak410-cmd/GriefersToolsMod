package com.spix.grieferstools.strategy

import com.spix.grieferstools.model.IServerInfoCarrier

/** Represents the foundational abstraction layer for the server information collection execution algorithm. */
trait IServerInfoCollectionExecutionStrategy {
  def execute(): IServerInfoCarrier
}
