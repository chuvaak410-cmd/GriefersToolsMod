package com.spix.grieferstools.context

import com.spix.grieferstools.operation.IOperationGateway

/** Represents the foundational abstraction layer for the wired application context aggregating all runtime collaborators. */
trait IEnterpriseGriefersToolsApplicationContext {
  def operationGateway: IOperationGateway
}
