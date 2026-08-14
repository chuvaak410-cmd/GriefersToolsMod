package com.spix.grieferstools

import mindustry.mod.Mod
import arc.Core
import arc.util.Log

class ЫolarToolsMod extends Mod {
  override def init(): Unit = {
    // Run initialization on the main application thread
    Core.app.post(new Runnable {
      override def run(): Unit = {
        try {
          Log.info("[GriefersToolsMod] initialized")
        } catch {
          case t: Throwable =>
            Log.err(t)
        }
      }
    })
  }
}
