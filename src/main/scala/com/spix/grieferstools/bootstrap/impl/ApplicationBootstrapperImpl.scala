package com.spix.grieferstools.bootstrap.impl

import mindustry.Vars
import com.spix.grieferstools.bootstrap.IApplicationBootstrapper
import com.spix.grieferstools.context.impl.ApplicationContextBuilderImpl
import com.spix.grieferstools.factory.impl.LoggerFactoryImpl
import com.spix.grieferstools.operation.IOperationType

/** Represents the concrete application bootstrapper implementation that builds the application context and registers the mod's UI entry points. */
class ApplicationBootstrapperImpl extends IApplicationBootstrapper {
  override def bootstrap(): Unit = {
    val logger = new LoggerFactoryImpl().create("GrifersTools")
    val context = new ApplicationContextBuilderImpl().build()

    Vars.ui.menufrag.addButton("Smenit lichnost", new Runnable {
      override def run(): Unit = context.operationGateway.dispatch(IOperationType.IdentitySpoof)
    })

    Vars.ui.hudGroup.fill(t => {
      t.bottom().left()
      t.button("SERVER INFO", new Runnable {
        override def run(): Unit = context.operationGateway.dispatch(IOperationType.ServerInfoScan)
      }).size(160f, 50f)
    })

    logger.logInfo("Initialized")
  }
}
