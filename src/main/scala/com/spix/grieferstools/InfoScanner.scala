package com.spix.grieferstools

import arc.Core
import arc.util.Log
import mindustry.Vars
import mindustry.gen.Groups
import mindustry.ui.dialogs.BaseDialog
import arc.scene.ui.Label

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

    info.append("Name: ").append(p.name).append("\n")
    info.append("ID: ").append(p.id).append("\n")

    try {
        info.append("UUID: ").append(p.uuid()).append("\n")
    } catch {
        case _: Throwable =>
    }

    info.append("Team: ").append(p.team).append("\n")
    info.append("HP: ").append(hp).append("\n")

    if (p.unit() != null) {
        info.append("X: ").append(p.unit().x).append("\n")
        info.append("Y: ").append(p.unit().y).append("\n")
        info.append("Unit: ").append(p.unit().`type`.name).append("\n")
    }

    info.append("\n")
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

    val dialog = new BaseDialog("Server Info")

    dialog.cont.pane(t => {
        t.defaults().left().top()
        val label = new Label(info.toString())
        label.setWrap(true)
        t.add(label).growX().left().top()
    }).grow()
    dialog.addCloseButton()
    dialog.show()
  }
}
