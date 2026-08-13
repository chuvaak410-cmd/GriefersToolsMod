package com.spix.grieferstools.bootstrap.impl

import arc.Core
import arc.util.Log
import com.spix.grieferstools.bootstrap.{IApplicationBootstrapper, IModEngineLoader}

/** Represents the concrete mod engine loader implementation that posts bootstrap execution onto the application's runnable queue. */
class ModEngineLoaderImpl extends IModEngineLoader {
  override def load(bootstrapper: IApplicationBootstrapper): Unit = {
    Core.app.post(new Runnable {
      override def run(): Unit = {
        try {
          bootstrapper.bootstrap()
        } catch {
          case e: Exception =>
            Log.err("[GrifersTools] Error initialization", e)
        }
      }
    })
  }
}
