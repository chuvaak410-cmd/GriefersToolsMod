package com.spix.grieferstools.log

/** Represents the foundational abstraction layer for all logging concerns within the enterprise ecosystem. */
trait IEnterpriseLogger {
  def logInfo(message: String): Unit
  def logError(message: String, throwable: Throwable): Unit
}
