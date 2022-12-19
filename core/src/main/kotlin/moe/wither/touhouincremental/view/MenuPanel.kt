package moe.wither.touhouincremental.view

import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import ktx.scene2d.*
import moe.wither.touhouincremental.model.GameModel
import moe.wither.touhouincremental.smoothLabel

class MenuPanel(
    model: GameModel,
    skin: Skin
) : Table(skin), KTable {

    init {

        debug = true
        pad(20f)

        smoothLabel("Gold : 4.44e444", skin)

    }

}

@Scene2dDsl
fun <S> KWidget<S>.menuPanel(
    model: GameModel,
    skin: Skin = Scene2DSkin.defaultSkin,
    init: MenuPanel.(S) -> Unit = {}
): MenuPanel = actor(MenuPanel(model, skin), init)