package com.spix.grieferstools.factory

import com.spix.grieferstools.exception.IEnterpriseExceptionHandlingStrategy
import com.spix.grieferstools.log.IEnterpriseLogger

/** Represents the foundational abstraction layer for exception handling strategy instantiation concerns. */
trait IExceptionHandlingStrategyFactory {
  def create(logger: IEnterpriseLogger): IEnterpriseExceptionHandlingStrategy
}
