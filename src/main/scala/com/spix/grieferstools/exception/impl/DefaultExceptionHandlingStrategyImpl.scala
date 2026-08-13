package com.spix.grieferstools.exception.impl

import mindustry.Vars
import com.spix.grieferstools.exception.IEnterpriseExceptionHandlingStrategy
import com.spix.grieferstools.log.IEnterpriseLogger

/** Represents the default, general-purpose implementation of the exception handling resolution strategy. */
class DefaultExceptionHandlingStrategyImpl(private val logger: IEnterpriseLogger)
  extends IEnterpriseExceptionHandlingStrategy {
  override def handle(exception: Throwable): Unit = {
    logger.logError("Unhandled exception intercepted by strategy layer", exception)
    Vars.ui.showException("Error", exception)
  }
}
