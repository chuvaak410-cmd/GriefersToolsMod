package com.spix.grieferstools.io.impl

import arc.scene.ui.Label
import mindustry.ui.dialogs.BaseDialog
import com.spix.grieferstools.io.IEnterpriseInfoReportFormatPublishingService
import com.spix.grieferstools.model.IServerInfoCarrier
import com.spix.grieferstools.parser.IEnterpriseParser
import com.spix.grieferstools.parser.lex.IEnterpriseLexer
import com.spix.grieferstools.visitor.impl.ReportRenderingVisitorImpl

/** Represents the concrete publishing service implementation that renders the aggregate server info carrier through the lexer/parser/visitor pipeline and displays it in a dialog. */
class EnterpriseInfoReportFormatPublishingServiceImpl(
    private val lexer: IEnterpriseLexer,
    private val parser: IEnterpriseParser
) extends IEnterpriseInfoReportFormatPublishingService {

  private val template: String =
    "=== SERVER INFO ===\n" +
      "Mode: {mode}\n" +
      "Wave: {wave}\n" +
      "{mapLine}" +
      "\nPLAYERS\n" +
      "{playersBlock}" +
      "\nUNITS\n" +
      "{unitsBlock}" +
      "\nWORLD\n" +
      "Width: {width}\n" +
      "Height: {height}\n"

  override def publish(carrier: IServerInfoCarrier): Unit = {
    val mapLine = carrier.mapName.map(n => s"Map: $n\n").getOrElse("")

    val playersBlock = carrier.players
      .map { p =>
        val sb = new StringBuilder
        sb.append("Name: ").append(p.name).append("\n")
        sb.append("ID: ").append(p.id).append("\n")
        p.uuidOpt.foreach(u => sb.append("UUID: ").append(u).append("\n"))
        sb.append("Team: ").append(p.team).append("\n")
        sb.append("HP: ").append(p.health).append("\n")
        p.position.foreach { case (x, y) =>
          sb.append("X: ").append(x).append("\n")
          sb.append("Y: ").append(y).append("\n")
        }
        p.unitTypeName.foreach(t => sb.append("Unit: ").append(t).append("\n"))
        sb.append("\n")
        sb.toString()
      }
      .mkString

    val unitsBlock = carrier.units
      .map(u => s"${u.typeName} | team: ${u.team} | hp: ${u.health}\n")
      .mkString

    val context = Map(
      "mode" -> carrier.modeName,
      "wave" -> carrier.wave.toString,
      "mapLine" -> mapLine,
      "playersBlock" -> playersBlock,
      "unitsBlock" -> unitsBlock,
      "width" -> carrier.worldWidth.toString,
      "height" -> carrier.worldHeight.toString
    )

    val tokens = lexer.tokenize(template)
    val document = parser.parse(tokens)
    val renderedReport = document.accept(new ReportRenderingVisitorImpl(context))

    val dialog = new BaseDialog("Server Info")
    dialog.cont
      .pane(t => {
        t.defaults().left().top()
        val label = new Label(renderedReport)
        label.setWrap(true)
        t.add(label).growX().left().top()
      })
      .grow()
    dialog.addCloseButton()
    dialog.show()
  }
}
