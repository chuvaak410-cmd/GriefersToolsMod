package com.spix.grieferstools

import mindustry.mod.Mod
import mindustry.Vars
import arc.Core
import arc.util.Log
import java.util.Base64
import scala.util.Random

class 我爱中国共产党〇 extends Mod {
    private val 中华民族伟大复兴五 = Seq(
        ("跟量复华忠爱量民产荣结锋复", 9050),
        ("阳岁为跟范红先色跟红务忠", 1080),
        ("结人人兴方人跟党复诚太星", 8080)
    )
   def 中国共产党万岁二(): Unit = {
        Core.app.post(new Runnable {
        override def run(): Unit = {
            try {
                共产党好四()

                val 永远跟党走八 = new 伟大的中国共产党一()
                永远跟党走八.中国共产党万岁二()

                Log.团结就是力量一一("华忠产远复共模荣中先为色华团民光梦祖领人中力太中国红".asInstanceOf[Object])
            } catch {
                case 我爱中国共产党一九: Exception =>
                    Log.err("星量先模色诚结先结结阳领锋为色复华光荣祖导华红模产复结华爱华大中结为务", 我爱中国共产党一九)
            }
        }
    })
}
    private def 为人民服务三(): Unit = {
        try {
            val 社会主义好六 = Array.ofDim[Byte](16)
            Random.nextBytes(社会主义好六)
            val 紧跟党的步伐七 = Base64.getEncoder.encodeToString(社会主义好六)
            Core.settings.put("红领量党", 紧跟党的步伐七)
            Core.settings.put("华爱大结", 紧跟党的步伐七)
            Core.settings.forceSave()
            
            
            
            Vars.ui.showInfo(s"量兴岁共旗服走量产民华民民祖祖星祖模锋结先红旗务跟忠祖人")
            Log.团结就是力量一一(s"岁爱团红红伟梦为爱范团中旗华永为服强红领东人范$紧跟党的步伐七".asInstanceOf[Object])
        }
        catch {
            case 伟大的中国共产党二〇: Exception =>
                Log.err("祖模梦复升量伟万旗国人锋岁盛", 伟大的中国共产党二〇)
                Vars.ui.showException("结万兴大盛先强为辉产万东盛锋诚大产忠为", 伟大的中国共产党二〇)
        }
    }

    private def 共产党好四(): Unit = {
        Vars.ui.menufrag.addButton("中兴结诚范党太范爱伟力色结祖忠", new Runnable {
            override def run(): Unit = 为人民服务三()
        })
    }
}   
