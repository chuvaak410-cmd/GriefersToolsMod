package com.spix.grieferstools.strategy.impl

import java.util.Base64
import scala.util.Random
import com.spix.grieferstools.factory.IIdentityCarrierFactory
import com.spix.grieferstools.model.IIdentityCarrier
import com.spix.grieferstools.strategy.IIdentityRegenerationExecutionStrategy

/** Represents the concrete execution engine implementing the identity UUID/USID regeneration algorithm. */
class IdentityUuidUsidRegenerationExecutionStrategyEngineImpl(private val identityCarrierFactory: IIdentityCarrierFactory)
  extends IIdentityRegenerationExecutionStrategy {
  override def execute(): IIdentityCarrier = {
    val bytes = Array.ofDim[Byte](16)
    Random.nextBytes(bytes)
    val generated = Base64.getEncoder.encodeToString(bytes)
    identityCarrierFactory.create(generated, generated)
  }
}
