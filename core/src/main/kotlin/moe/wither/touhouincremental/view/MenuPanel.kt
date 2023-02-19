package moe.wither.touhouincremental.view

import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import ktx.scene2d.*
import moe.wither.touhouincremental.SmoothLabel
import moe.wither.touhouincremental.model.GameModel
import moe.wither.touhouincremental.smoothLabel

class MenuPanel(
    model: GameModel,
    skin: Skin
) : Table(skin), KTable {

    private val goldLabel: SmoothLabel

    init {

        debug = true

        goldLabel = smoothLabel("Gold : 4.44e444", skin) {
            it.pad(10f)
            it.expandX()
        }

        row()

        val characterInfoCards : Table

        scrollPane {

            debug = true
            it.grow()
            fadeScrollBars = false

            characterInfoCards = table {
                defaults().growX()
                top()
            }
        }

        // Card adding (temporary for testing purposes)
        for (i in 0 until 10) {

            val card = CharacterInfoCard(model, skin)
            characterInfoCards.add(card)

            characterInfoCards.row()

        }

    }

}

@Scene2dDsl
fun <S> KWidget<S>.menuPanel(
    model: GameModel,
    skin: Skin = Scene2DSkin.defaultSkin,
    init: MenuPanel.(S) -> Unit = {}
): MenuPanel = actor(MenuPanel(model, skin), init)