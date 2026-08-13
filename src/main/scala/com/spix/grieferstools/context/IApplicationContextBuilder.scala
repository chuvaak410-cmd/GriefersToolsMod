package com.spix.grieferstools.context

/** Represents the foundational abstraction layer for the builder responsible for assembling the application context object graph. */
trait IApplicationContextBuilder {
  def build(): IEnterpriseGriefersToolsApplicationContext
}
