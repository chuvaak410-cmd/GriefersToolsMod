package com.spix.grieferstools.exception

/** Represents an exceptional condition encountered during the identity credential regeneration execution pipeline. */
class IdentityRegenerationException(message: String, cause: Throwable = null)
  extends EnterpriseGriefersToolsBaseException(message, cause)
