package com.spix.grieferstools.service.impl

import com.spix.grieferstools.exception.{IEnterpriseExceptionHandlingStrategy, InfoScanException}
import com.spix.grieferstools.io.IEnterpriseInfoReportFormatPublishingService
import com.spix.grieferstools.service.IServerInfoScanningService
import com.spix.grieferstools.strategy.IServerInfoCollectionExecutionStrategy

/** Represents the concrete high-level orchestrator implementation coordinating the server information collection and publishing workflow. */
class ServerInfoScanningServiceImpl(
    private val strategy: IServerInfoCollectionExecutionStrategy,
    private val publishingService: IEnterpriseInfoReportFormatPublishingService,
    private val exceptionHandlingStrategy: IEnterpriseExceptionHandlingStrategy
) extends IServerInfoScanningService {

  override def scanAndPublish(): Unit = {
    try {
      val carrier = strategy.execute()
      publishingService.publish(carrier)
    } catch {
      case ex: Exception =>
        exceptionHandlingStrategy.handle(new InfoScanException("Error scanning server info", ex))
    }
  }
}
