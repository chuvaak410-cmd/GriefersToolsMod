package com.spix.grieferstools

import mindustry.mod.Mod
import com.spix.grieferstools.bootstrap.impl.{ApplicationBootstrapperImpl, ModEngineLoaderImpl}

/** Represents the root mod entry point delegating all initialization concerns to the enterprise bootstrap engine loader. */
class GriferTools extends Mod {
  override def init(): Unit = {
    new ModEngineLoaderImpl().load(new ApplicationBootstrapperImpl())
  }
}
