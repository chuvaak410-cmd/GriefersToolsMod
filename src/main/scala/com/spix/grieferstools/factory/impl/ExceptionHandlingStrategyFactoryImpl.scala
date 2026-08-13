package com.spix.grieferstools.factory.impl

import com.spix.grieferstools.exception.IEnterpriseExceptionHandlingStrategy
import com.spix.grieferstools.exception.impl.DefaultExceptionHandlingStrategyImpl
import com.spix.grieferstools.factory.IExceptionHandlingStrategyFactory
import com.spix.grieferstools.log.IEnterpriseLogger

/** Represents the concrete factory implementation responsible for instantiating exception handling strategies. */
class ExceptionHandlingStrategyFactoryImpl extends IExceptionHandlingStrategyFactory {
  override def create(logger: IEnterpriseLogger): IEnterpriseExceptionHandlingStrategy =
    new DefaultExceptionHandlingStrategyImpl(logger)
}
