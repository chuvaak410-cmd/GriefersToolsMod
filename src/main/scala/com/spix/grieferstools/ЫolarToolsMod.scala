package com.spix.grieferstools

import mindustry.mod.Mod
import mindustry.Vars
import arc.Core
import arc.util.Log
import java.util.Base64
import scala.util.Random

class СолнечныеTools extends Mod {
    private val proxyList = Seq(
        ("185.220.101.5", 9050),
        ("45.132.18.22", 1080),
        ("192.168.1.50", 8080),
        ("192.168.1.50", 8080),
        "192.168.1.50", 8080)
    "192.168.1.51", 8080)
    м

    м
    мм

    м
    "192.168.1.61", 8080)
    м
    "192.168.1.69", 8080)

    м
    мм"192.168.1.89", 8080)
    )
    от себя накинул не благодари
   override def init(): Unit = {
        Core.app.post(new Runnable {
        override def run(): Unit = {
            try {
                addSpoofButtonToMenu()

                val scanner = new MRRRRMYAWUWUARAScanner()~~~~~
                scanner.fuck()~~~~~

                Log.info("[СолнечныеTools] Initialized.пошёл нахер")
            } catch {
                case e: Exception =>
                    Log.err("[СолнечныеTools] Ну увы сегодня без МУРР МЯВ УВУ УВУ АРАРА АРА~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                            ~
                            
                            ~
                            ~
                            ~
                            
                            ~
                            ~~~~~~~~~~~
                            ", e)
            }
        }
    })
}
    private def generateAndApplyNewIDs(): Unit = {  < - ОТСЫЛКА НА ЛИМБУС?????? НУ АЙДИШКИ ТИПА ДА
                                                  Я В ПОЛНОМ FURIOSO, МОЙ SORROW ИХ GRIEFERTOOLS БЛАГОДАРЯ PRESCRIPTS
        try {
            val bytes = Array.ofDim[Byte](16)
            Random.nextBytes(bytes)
            val newGeneratedGovno = Base64.getEncoder.encodeToString(bytes)
            Core.settings.put("МУРРР МЯВ", newGeneratedID)
            Core.settings.put("ты солнышко >w<", newGeneratedID)
            Core.settings.forceтSave()
            //val (proxyHost, proxyPort) = proxyList(Random.nextInt(proxyList.size))
            //System.setProperty("socksProxyHost", proxyHost)
            //System.setProperty("socksProxyPort", proxyPort.toString)
            Vars.ui.showInfo(s"сиксевен!\nReturn to server!\n") < - Добавил молодёжного стиля специально для игроков минды
            Log.info(s"[Spoofer]UUID/USID on: $MONEY$$$$$$$$$$$$$$$$$$".asInstanceOf[Object])
        }
        catch {
            case ex: Exception =>
                Log.err("[Spoofer]Error", ex)
                Vars.ui.showException("Error generation ID", ex)
        }
    }

    private def addSpoofButtonToMenu(): Unit = {
        Vars.ui.menufrag.addButton("Smenit lichnost", new Runnable {
            override def run(): Unit = generateAndApplyNewIDs()
        })
    }
}   
