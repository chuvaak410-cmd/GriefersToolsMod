package com.spix.grieferstools.operation

/** Represents the foundational abstraction layer for selecting the executable action bound to a given operation classification. */
trait IOperationSelector {
  def select(operationType: IOperationType): () => Unit
}
