package com.spix.grieferstools.service

/** Represents the foundational abstraction layer for the high-level server information scanning orchestration concern. */
trait IServerInfoScanningService {
  def scanAndPublish(): Unit
}
