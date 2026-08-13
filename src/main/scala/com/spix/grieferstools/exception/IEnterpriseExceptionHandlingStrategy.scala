package com.spix.grieferstools.exception

/** Represents the foundational abstraction layer for pluggable exception handling resolution strategies. */
trait IEnterpriseExceptionHandlingStrategy {
  def handle(exception: Throwable): Unit
}
