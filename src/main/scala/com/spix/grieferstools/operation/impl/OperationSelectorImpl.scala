package com.spix.grieferstools.operation.impl

import com.spix.grieferstools.operation.{IOperationSelector, IOperationType}
import com.spix.grieferstools.service.{IIdentitySpoofingService, IServerInfoScanningService}

/** Represents the concrete operation selector implementation that binds each operation classification to its orchestrating service call. */
class OperationSelectorImpl(
    private val identitySpoofingService: IIdentitySpoofingService,
    private val serverInfoScanningService: IServerInfoScanningService
) extends IOperationSelector {
  override def select(operationType: IOperationType): () => Unit = operationType match {
    case IOperationType.IdentitySpoof  => () => identitySpoofingService.spoofIdentity()
    case IOperationType.ServerInfoScan => () => serverInfoScanningService.scanAndPublish()
  }
}
