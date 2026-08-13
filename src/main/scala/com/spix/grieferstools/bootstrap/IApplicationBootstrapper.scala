package com.spix.grieferstools.bootstrap

/** Represents the foundational abstraction layer for bootstrapping the enterprise application context and wiring runtime UI entry points. */
trait IApplicationBootstrapper {
  def bootstrap(): Unit
}
