package com.spix.grieferstools.io

import com.spix.grieferstools.model.IServerInfoCarrier

/** Represents the foundational abstraction layer for publishing rendered server information reports to the presentation layer. */
trait IEnterpriseInfoReportFormatPublishingService {
  def publish(carrier: IServerInfoCarrier): Unit
}
