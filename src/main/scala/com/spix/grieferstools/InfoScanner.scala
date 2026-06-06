package com.spix.grieferstools
import mindustry.mod.Mod
import arc.Core
import arc.util.Log
import arc.scene.ui.layout.Table
import mindustry.gen.Groups
import mindustry.Vars
class InfoScanner extends Mod {
  override def init(): Unit = {
    Core.app.post(() => addInfoButton())
    Log.info("[InfoScanner] Successfully initialized".asInstanceOf[Object])
  }
  private def addInfoButton(): Unit = {
    Vars.ui.hudGroup.fill(t => {
      t.bottom().left()

      t.button("SERVER INFO", () => showFullInfo()).size(160f, 50f)
    })
  }
  private def showFullInfo(): Unit = {
    val info = new StringBuilder()
    info.append(" SERVER INFO \n")
    info.append("Mode: ").append(Vars.state.rules.modeName).append("\n")
    info.append("Wave: ").append(Vars.state.wave).append("\n")
    info.append("Map: ").append(Vars.state.map.name()).append("\n\n")
    info.append(" PLAYERS \n")
    Groups.player.each(p => {
        val hp = if(p.unit() != null) p.unit().health else 0f
        info.append(s"${p.name} | team:${p.team} | hp:$hp\n")
    })
    info.append("\n UNITS \n")
    Groups.unit.each(u => {
        val typeName = if(u != null && u.`type` != null) u.`type`.name else "unknown"
        info.append(s"$typeName | team:${u.team} | hp:${u.health}\n")
    })
    info.append("\n WORLD \n")
    info.append("Width: ").append(Vars.world.width()).append("\n")
    info.append("Height: ").append(Vars.world.height()).append("\n")
    Vars.ui.showInfo(info.toString())
  }
}