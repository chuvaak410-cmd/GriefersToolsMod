package com.spix.grieferstools.context.impl

import com.spix.grieferstools.context.IEnterpriseGriefersToolsApplicationContext
import com.spix.grieferstools.operation.IOperationGateway

/** Represents the concrete application context implementation holding the fully wired operation gateway. */
class EnterpriseGriefersToolsApplicationContextImpl(private val gateway: IOperationGateway)
  extends IEnterpriseGriefersToolsApplicationContext {
  override def operationGateway: IOperationGateway = gateway
}
