package com.spix.grieferstools.bootstrap

/** Represents the foundational abstraction layer for the mod engine loader responsible for deferring bootstrap execution onto the application event loop. */
trait IModEngineLoader {
  def load(bootstrapper: IApplicationBootstrapper): Unit
}
