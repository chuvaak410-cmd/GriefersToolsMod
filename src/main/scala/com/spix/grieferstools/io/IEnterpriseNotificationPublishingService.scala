package com.spix.grieferstools.io

/** Represents the foundational abstraction layer for publishing user-facing notifications to the presentation layer. */
trait IEnterpriseNotificationPublishingService {
  def publishInfo(message: String): Unit
  def publishException(title: String, throwable: Throwable): Unit
}
