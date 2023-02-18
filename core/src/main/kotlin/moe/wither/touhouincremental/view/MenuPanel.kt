package moe.wither.touhouincremental.view

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.Scaling
import ktx.actors.onClick
import ktx.scene2d.*
import moe.wither.touhouincremental.event.EnemyClickedEvent
import moe.wither.touhouincremental.event.fire
import moe.wither.touhouincremental.model.GameModel
import moe.wither.touhouincremental.smoothLabel

class MenuPanel(
    model: GameModel,
    skin: Skin
) : Table(skin), KTable {

    init {

        debug = true

        heroInfoCard(model, skin) {
            it.top()
            it.expand()
            it.fill()
            it.height(170f)
        }

    }

}

@Scene2dDsl
fun <S> KWidget<S>.menuPanel(
    model: GameModel,
    skin: Skin = Scene2DSkin.defaultSkin,
    init: MenuPanel.(S) -> Unit = {}
): MenuPanel = actor(MenuPanel(model, skin), init)