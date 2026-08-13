package com.spix.grieferstools.service.impl

import arc.Core
import com.spix.grieferstools.exception.{IEnterpriseExceptionHandlingStrategy, IdentityRegenerationException}
import com.spix.grieferstools.io.IEnterpriseNotificationPublishingService
import com.spix.grieferstools.log.IEnterpriseLogger
import com.spix.grieferstools.service.IIdentitySpoofingService
import com.spix.grieferstools.strategy.IIdentityRegenerationExecutionStrategy

/** Represents the concrete high-level orchestrator implementation coordinating the identity credential regeneration workflow. */
class IdentitySpoofingServiceImpl(
    private val strategy: IIdentityRegenerationExecutionStrategy,
    private val notificationPublishingService: IEnterpriseNotificationPublishingService,
    private val logger: IEnterpriseLogger,
    private val exceptionHandlingStrategy: IEnterpriseExceptionHandlingStrategy
) extends IIdentitySpoofingService {

  override def spoofIdentity(): Unit = {
    try {
      val identityCarrier = strategy.execute()
      Core.settings.put("uuid", identityCarrier.uuid)
      Core.settings.put("usid", identityCarrier.usid)
      Core.settings.forceSave()
      notificationPublishingService.publishInfo("Succes!\nReturn to server!\n")
      logger.logInfo(s"UUID/USID on: ${identityCarrier.uuid}")
    } catch {
      case ex: Exception =>
        exceptionHandlingStrategy.handle(new IdentityRegenerationException("Error generation ID", ex))
    }
  }
}
