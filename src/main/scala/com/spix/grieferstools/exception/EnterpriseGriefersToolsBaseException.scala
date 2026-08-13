package com.spix.grieferstools.exception

/** Represents the foundational abstraction layer for all domain-specific exceptional conditions raised within the enterprise ecosystem. */
class EnterpriseGriefersToolsBaseException(message: String, cause: Throwable = null)
  extends RuntimeException(message, cause)
