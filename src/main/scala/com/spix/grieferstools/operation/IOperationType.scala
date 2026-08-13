package com.spix.grieferstools.operation

/** Represents the exhaustive enumeration of dispatchable operation classifications routed through the operation gateway. */
sealed trait IOperationType
object IOperationType {
  case object IdentitySpoof extends IOperationType
  case object ServerInfoScan extends IOperationType
}
