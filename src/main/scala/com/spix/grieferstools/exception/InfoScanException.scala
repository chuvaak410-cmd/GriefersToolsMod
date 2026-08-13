package com.spix.grieferstools.exception

/** Represents an exceptional condition encountered during the server information acquisition and reporting pipeline. */
class InfoScanException(message: String, cause: Throwable = null)
  extends EnterpriseGriefersToolsBaseException(message, cause)
