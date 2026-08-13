package com.spix.grieferstools.operation.impl

import com.spix.grieferstools.operation.{IOperationGateway, IOperationSelector, IOperationType}

/** Represents the concrete operation gateway implementation routing dispatched operations through the operation selector. */
class OperationGatewayImpl(private val selector: IOperationSelector) extends IOperationGateway {
  override def dispatch(operationType: IOperationType): Unit = selector.select(operationType)()
}
