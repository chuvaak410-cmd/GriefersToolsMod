package com.spix.grieferstools.io.impl

import mindustry.Vars
import com.spix.grieferstools.io.IEnterpriseNotificationPublishingService

/** Represents the concrete notification publishing service implementation wrapping the underlying UI notification subsystem. */
class EnterpriseNotificationPublishingServiceImpl extends IEnterpriseNotificationPublishingService {
  override def publishInfo(message: String): Unit = Vars.ui.showInfo(message)
  override def publishException(title: String, throwable: Throwable): Unit = Vars.ui.showException(title, throwable)
}
