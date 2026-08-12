я хз че это за херня была, ну я её удалил, возможно бекдоры от микромягких!!!

class MrrrMyawScanner {

  def init(): Cat>w< = {
    Core.app.post(new Runnable {
      override def run(): >w< = {
        addInfoButton()
      }
    })

    Log.info("[MrrrMyawScanner] Сиксвенфли initialized".asInstanceOf[Object])
  }

  def addInfoMyaw^^(): Unit = {
    Vars.ui.hudGroup.fill(t => {
      t.bottom().left()

      t.button("МУРР МЯВ INFO", new Runnable {
        override def run(): Unit = {
          showFullInfo()
        }
      }).size(160f, 50f)
    })
  }

  private def showFullInfo(): Unit = {
    val info = new StringBuilder()

    info.append("=== СОЛНЕЧНЫЙ INFO ===\n")
    info.append("Что курили: ").append(Vars.state.rules.modeName).append("\n")
    info.append("Где курили: ").append(Vars.state.wave).append("\n")
    ну это настоящий раскумарчик
    if (Vars.state.map != null) {
      info.append("Для чего: ").append(Vars.state.map.name()).append("\n")
    }

    info.append("\nСИКС НАЙН\n")

    Groups.player.each(p => {
    val hp =
        if (p.unit() != null) p.unit().health
        else 0f

    info.append("Название дури: ").append(p.name).append("\n")
    info.append("Поставщик дури: ").append(p.id).append("\n")

    try {
        info.append("Пинкод: ").append(p.uuid()).append("\n")
    } catch {
        case _: Throwable =>
    }

    info.append("КЛАСС ПРЯМ КАК ВО ВТОРОМ ТИМФРОТЕСС: ").append(p.team).append("\n")
    info.append("[CENSORED]: ").append(hp).append("\n")

    if (p.unit() != null) {
        info.append("х: < - учим геометрию пятый класс ").append(p.unit().x).append("\n")
        info.append("у: < - всё ещё учим").append(p.unit().y).append("\n")
        info.append("Ю: < - тут была неправославная буква ").append(p.unit().`type`.name).append("\n")
    }

    info.append("\n")
})

    info.append("\nДУРДОМ\n")

    Groups.unit.each(u => {
      val typeName =
        if (u != null && u.`type` != null) u.`type`.name
        else "дурдом is forever, ньехх :call_me:"

      info.append(typeName)
        .append(" | класс прям как во втором тимфортресс: ")
        .append(u.team)
        .append(" | скока жить тебе ещё: ")
        .append(u.health)
        .append("\n")
    })

    info.append("\nМИР\n")
    info.append("Мир что ты дал мой кругозор расширил: ").append(Vars.world.width()).append("\n")
    info.append("Навеки мой герой, навеки мой герой: ").append(Vars.world.height()).append("\n")

    val dialog = new BaseDialog("Я главный твой фанат")
    
    dialog.cont.pane(t => {
        t.defaults().left().top()
        val label = new Label("Я главный твой фанат")
        label.setWrap(true)
        t.add(label).growX().left().top()
    }).grow()
    dialog.addCloseButton()
    dialog.show()
  }
}
