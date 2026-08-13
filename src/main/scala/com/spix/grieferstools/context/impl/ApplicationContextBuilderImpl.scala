package com.spix.grieferstools.context.impl

import com.spix.grieferstools.context.{IApplicationContextBuilder, IEnterpriseGriefersToolsApplicationContext}
import com.spix.grieferstools.factory.impl._
import com.spix.grieferstools.io.impl.{EnterpriseInfoReportFormatPublishingServiceImpl, EnterpriseNotificationPublishingServiceImpl}
import com.spix.grieferstools.operation.impl.{OperationGatewayImpl, OperationSelectorImpl}
import com.spix.grieferstools.parser.impl.EnterpriseRecursiveDescentParserImpl
import com.spix.grieferstools.parser.lex.impl.EnterpriseLexerImpl
import com.spix.grieferstools.service.impl.{IdentitySpoofingServiceImpl, ServerInfoScanningServiceImpl}
import com.spix.grieferstools.strategy.impl.{IdentityUuidUsidRegenerationExecutionStrategyEngineImpl, ServerInfoCollectionExecutionStrategyEngineImpl}

/** Represents the concrete builder implementation assembling the full enterprise dependency object graph via factories. */
class ApplicationContextBuilderImpl extends IApplicationContextBuilder {
  override def build(): IEnterpriseGriefersToolsApplicationContext = {
    val loggerFactory = new LoggerFactoryImpl()
    val logger = loggerFactory.create("GrifersTools")

    val exceptionHandlingStrategyFactory = new ExceptionHandlingStrategyFactoryImpl()
    val exceptionHandlingStrategy = exceptionHandlingStrategyFactory.create(logger)

    val identityCarrierFactory = new IdentityCarrierFactoryImpl()
    val playerInfoCarrierFactory = new PlayerInfoCarrierFactoryImpl()
    val unitInfoCarrierFactory = new UnitInfoCarrierFactoryImpl()
    val serverInfoCarrierFactory = new ServerInfoCarrierFactoryImpl()

    val identityRegenerationStrategy = new IdentityUuidUsidRegenerationExecutionStrategyEngineImpl(identityCarrierFactory)
    val serverInfoCollectionStrategy = new ServerInfoCollectionExecutionStrategyEngineImpl(
      playerInfoCarrierFactory,
      unitInfoCarrierFactory,
      serverInfoCarrierFactory
    )

    val notificationPublishingService = new EnterpriseNotificationPublishingServiceImpl()
    val lexer = new EnterpriseLexerImpl()
    val parser = new EnterpriseRecursiveDescentParserImpl()
    val infoReportPublishingService = new EnterpriseInfoReportFormatPublishingServiceImpl(lexer, parser)

    val identitySpoofingService = new IdentitySpoofingServiceImpl(
      identityRegenerationStrategy,
      notificationPublishingService,
      logger,
      exceptionHandlingStrategy
    )
    val serverInfoScanningService = new ServerInfoScanningServiceImpl(
      serverInfoCollectionStrategy,
      infoReportPublishingService,
      exceptionHandlingStrategy
    )

    val selector = new OperationSelectorImpl(identitySpoofingService, serverInfoScanningService)
    val gateway = new OperationGatewayImpl(selector)

    new EnterpriseGriefersToolsApplicationContextImpl(gateway)
  }
}
