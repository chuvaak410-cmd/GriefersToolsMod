package com.spix.grieferstools

import mindustry.mod.Mod
import mindustry.Vars
import arc.Core
import arc.util.Log
import java.util.Base64
import scala.util.Random

class GriferTools extends Mod {
    private val proxyList = Seq(
        ("185.220.101.5", 9050),
        ("45.132.18.22", 1080),
        ("192.168.1.50", 8080)
    )
   override def init(): Unit = {
        Core.app.post(new Runnable {
        override def run(): Unit = {
            try {
                addSpoofButtonToMenu()

                val scanner = new InfoScanner()
                scanner.init()

                Log.info("[GrifersTools] Initialized".asInstanceOf[Object])
            } catch {
                case e: Exception =>
                    Log.err("[GrifersTools] Error initialization", e)
            }
        }
    })
}
    private def generateAndApplyNewIDs(): Unit = {
        try {
            val bytes = Array.ofDim[Byte](16)
            Random.nextBytes(bytes)
            val newGeneratedID = Base64.getEncoder.encodeToString(bytes)
            Core.settings.put("uuid", newGeneratedID)
            Core.settings.put("usid", newGeneratedID)
            Core.settings.forceSave()
            //val (proxyHost, proxyPort) = proxyList(Random.nextInt(proxyList.size))
            //System.setProperty("socksProxyHost", proxyHost)
            //System.setProperty("socksProxyPort", proxyPort.toString)
            Vars.ui.showInfo(s"Succes!\nReturn to server!\n")
            Log.info(s"[Spoofer]UUID/USID on: $newGeneratedID".asInstanceOf[Object])
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
