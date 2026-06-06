package com.spix.grieferstools

import arc.Core
import arc.util.Log
import mindustry.Vars
import mindustry.gen.Groups

class InfoScanner {

  def init(): Unit = {
    Core.app.post(new Runnable {
      override def run(): Unit = {
        addInfoButton()
      }
    })

    Log.info("[InfoScanner] Successfully initialized".asInstanceOf[Object])
  }

  def addInfoButton(): Unit = {
    Vars.ui.hudGroup.fill(t => {
      t.bottom().left()

      t.button("SERVER INFO", new Runnable {
        override def run(): Unit = {
          showFullInfo()
        }
      }).size(160f, 50f)
    })
  }

  private def showFullInfo(): Unit = {
    val info = new StringBuilder()

    info.append("=== SERVER INFO ===\n")
    info.append("Mode: ").append(Vars.state.rules.modeName).append("\n")
    info.append("Wave: ").append(Vars.state.wave).append("\n")

    if (Vars.state.map != null) {
      info.append("Map: ").append(Vars.state.map.name()).append("\n")
    }

    info.append("\nPLAYERS\n")

    Groups.player.each(p => {
      val hp =
        if (p.unit() != null) p.unit().health
        else 0f

      info.append(p.name)
        .append(" | team: ")
        .append(p.team)
        .append(" | hp: ")
        .append(hp)
        .append("\n")
    })

    info.append("\nUNITS\n")

    Groups.unit.each(u => {
      val typeName =
        if (u != null && u.`type` != null) u.`type`.name
        else "unknown"

      info.append(typeName)
        .append(" | team: ")
        .append(u.team)
        .append(" | hp: ")
        .append(u.health)
        .append("\n")
    })

    info.append("\nWORLD\n")
    info.append("Width: ").append(Vars.world.width()).append("\n")
    info.append("Height: ").append(Vars.world.height()).append("\n")

    Vars.ui.showInfo(info.toString())
  }
}
