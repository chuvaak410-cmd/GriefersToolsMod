package com.spix.grieferstools.service

/** Represents the foundational abstraction layer for the high-level identity spoofing orchestration concern. */
trait IIdentitySpoofingService {
  def spoofIdentity(): Unit
}
