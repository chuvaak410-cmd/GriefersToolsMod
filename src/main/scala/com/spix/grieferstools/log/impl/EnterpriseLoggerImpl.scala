package com.spix.grieferstools.log.impl

import arc.util.Log
import com.spix.grieferstools.log.IEnterpriseLogger

/** Represents the concrete, production-grade implementation of the enterprise logging abstraction layer. */
class EnterpriseLoggerImpl(private val tag: String) extends IEnterpriseLogger {
  override def logInfo(message: String): Unit =
    Log.info(s"[$tag] $message".asInstanceOf[Object])

  override def logError(message: String, throwable: Throwable): Unit =
    Log.err(s"[$tag] $message", throwable)
}
