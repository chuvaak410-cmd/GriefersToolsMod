package com.spix.grieferstools.operation

/** Represents the foundational abstraction layer for the single entry-point gateway dispatching operations by classification. */
trait IOperationGateway {
  def dispatch(operationType: IOperationType): Unit
}
