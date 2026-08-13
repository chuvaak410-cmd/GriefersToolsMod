package com.spix.grieferstools.strategy.impl

import mindustry.Vars
import mindustry.gen.Groups
import com.spix.grieferstools.factory.{IPlayerInfoCarrierFactory, IServerInfoCarrierFactory, IUnitInfoCarrierFactory}
import com.spix.grieferstools.model.{IPlayerInfoCarrier, IServerInfoCarrier, IUnitInfoCarrier}
import com.spix.grieferstools.strategy.IServerInfoCollectionExecutionStrategy

import scala.collection.mutable.ArrayBuffer

/** Represents the concrete execution engine implementing the server information collection algorithm. */
class ServerInfoCollectionExecutionStrategyEngineImpl(
    private val playerInfoCarrierFactory: IPlayerInfoCarrierFactory,
    private val unitInfoCarrierFactory: IUnitInfoCarrierFactory,
    private val serverInfoCarrierFactory: IServerInfoCarrierFactory
) extends IServerInfoCollectionExecutionStrategy {

  override def execute(): IServerInfoCarrier = {
    val players = ArrayBuffer[IPlayerInfoCarrier]()
    Groups.player.each(p => {
      val hp = if (p.unit() != null) p.unit().health else 0f
      val uuidOpt =
        try Some(p.uuid())
        catch { case _: Throwable => None }
      val position = if (p.unit() != null) Some((p.unit().x, p.unit().y)) else None
      val unitTypeName = if (p.unit() != null) Some(p.unit().`type`.name) else None
      players += playerInfoCarrierFactory.create(p.name, p.id, uuidOpt, p.team.toString, hp, position, unitTypeName)
    })

    val units = ArrayBuffer[IUnitInfoCarrier]()
    Groups.unit.each(u => {
      val typeName = if (u != null && u.`type` != null) u.`type`.name else "unknown"
      units += unitInfoCarrierFactory.create(typeName, u.team.toString, u.health)
    })

    val mapName = if (Vars.state.map != null) Some(Vars.state.map.name()) else None

    serverInfoCarrierFactory.create(
      Vars.state.rules.modeName,
      Vars.state.wave,
      mapName,
      Vars.world.width(),
      Vars.world.height(),
      players.toSeq,
      units.toSeq
    )
  }
}
