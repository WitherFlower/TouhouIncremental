package moe.wither.touhouincremental.view

import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import ktx.scene2d.*
import moe.wither.touhouincremental.model.GameModel

class GameView(
    model: GameModel,
    skin: Skin
) : Table(skin), KTable {

    init {

        setFillParent(true)
        debug = true

        width = 1920f

        menuPanel(model, skin) {
            it.top()
//            it.expand()
            it.fill()
            it.width(768f)
        }

        enemyPanel(model, skin) {
            it.expand()
            it.fill()
            it.width(576f)
        }

        scorePanel(model, skin) {
            it.top()
            it.left()
//            it.expand()
            it.width(576f)
        }

    }

}

@Scene2dDsl
fun <S> KWidget<S>.gameView(
    model: GameModel,
    skin: Skin = Scene2DSkin.defaultSkin,
    init: GameView.(S) -> Unit = {}
): GameView = actor(GameView(model, skin), init)