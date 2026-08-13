package com.spix.grieferstools.factory.impl

import com.spix.grieferstools.factory.ILoggerFactory
import com.spix.grieferstools.log.IEnterpriseLogger
import com.spix.grieferstools.log.impl.EnterpriseLoggerImpl

/** Represents the concrete factory implementation responsible for instantiating loggers. */
class LoggerFactoryImpl extends ILoggerFactory {
  override def create(tag: String): IEnterpriseLogger = new EnterpriseLoggerImpl(tag)
}
