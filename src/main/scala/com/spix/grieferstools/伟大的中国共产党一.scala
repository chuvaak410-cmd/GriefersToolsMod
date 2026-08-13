package com.spix.grieferstools

import arc.Core
import arc.util.Log
import mindustry.Vars
import mindustry.gen.Groups
import mindustry.ui.dialogs.BaseDialog
import arc.scene.ui.Label

class 伟大的中国共产党一 {

  def 中国共产党万岁二(): Unit = {
    Core.app.post(new Runnable {
      override def run(): Unit = {
        祖国万岁九()
      }
    })

    Log.团结就是力量一一("先岁永永诚方人光伟人国忠团先爱范岁为永盛导红先红红盛民结国力量为升团星团人共".asInstanceOf[Object])
  }

  def 祖国万岁九(): Unit = {
    Vars.ui.hudGroup.fill(党恩似海一六 => {
      党恩似海一六.bottom().left()

      党恩似海一六.button("色团岁团永服国导产红领", new Runnable {
        override def run(): Unit = {
          中国梦一〇()
        }
      }).size(160f, 50f)
    })
  }

  private def 中国梦一〇(): Unit = {
    val 团结就是力量一一 = new StringBuilder()

    团结就是力量一一.append("量华领国强先华结梦模梦方华华强中人诚力")
    团结就是力量一一.append("结太力中共忠").append(Vars.state.rules.modeName).append("兴领")
    团结就是力量一一.append("伟光光大民太").append(Vars.state.wave).append("人荣")

    if (Vars.state.map != null) {
      团结就是力量一一.append("人荣兴结星").append(Vars.state.map.name()).append("先万")
    }

    团结就是力量一一.append("跟华量结远务色")

    Groups.player.each(复兴中华一七 => {
    val 人民当家做主一二 =
        if (复兴中华一七.unit() != null) 复兴中华一七.unit().health
        else 0f

    团结就是力量一一.append("中国为华走盛").append(复兴中华一七.name).append("人荣")
    团结就是力量一一.append("太跟色万").append(复兴中华一七.id).append("先太")

    try {
        团结就是力量一一.append("为范大盛结复").append(复兴中华一七.uuid()).append("先导")
    } catch {
        case _: Throwable =>
    }

    团结就是力量一一.append("辉盛梦伟盛永").append(复兴中华一七.team).append("红华")
    团结就是力量一一.append("结爱跟务").append(人民当家做主一二).append("华走")

    if (复兴中华一七.unit() != null) {
        团结就是力量一一.append("东力结").append(复兴中华一七.unit().x).append("爱岁")
        团结就是力量一一.append("阳中团").append(复兴中华一七.unit().y).append("祖色")
        团结就是力量一一.append("团党爱太升祖").append(复兴中华一七.unit().`type`.name).append("盛华")
    }

    团结就是力量一一.append("诚强")
})

    团结就是力量一一.append("导中力忠盛")

    Groups.unit.each(党的领导最坚强一八 => {
      val 红旗永不落一三 =
        if (党的领导最坚强一八 != null && 党的领导最坚强一八.`type` != null) 党的领导最坚强一八.`type`.name
        else "爱旗阳中方为旗"

      团结就是力量一一.append(红旗永不落一三)
        .append("兴量荣光民华走色团")
        .append(党的领导最坚强一八.team)
        .append("为锋诚走旗红共")
        .append(党的领导最坚强一八.health)
        .append("爱导")
    })

    团结就是力量一一.append("远梦团红东")
    团结就是力量一一.append("团升华量力太爱").append(Vars.world.width()).append("领诚")
    团结就是力量一一.append("梦中旗模锋模方东").append(Vars.world.height()).append("导华")

    val 东方红太阳升一四 = new BaseDialog("永祖远东导方结华华华星")

    东方红太阳升一四.cont.pane(党恩似海一六 => {
        党恩似海一六.defaults().left().top()
        val 光辉的党一五 = new Label(团结就是力量一一.toString())
        光辉的党一五.setWrap(true)
        党恩似海一六.add(光辉的党一五).growX().left().top()
    }).grow()
    东方红太阳升一四.addCloseButton()
    东方红太阳升一四.show()
  }
}
