package moe.wither.touhouincremental.view

import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import ktx.scene2d.*
import moe.wither.touhouincremental.SmoothLabel
import moe.wither.touhouincremental.math.formatValue
import moe.wither.touhouincremental.model.GameModel
import moe.wither.touhouincremental.smoothLabel

class ScorePanel(
    model: GameModel,
    skin: Skin
) : Table(skin), KTable {

    private val scoreLabel : SmoothLabel

    init {

        debug = true
        pad(20f)

        scoreLabel = smoothLabel("Score : 1,234,567,890", skin).apply {
            width = 500f
        }

        // Data Binding

        model.onPropertyChange(model::score) {
            scoreLabel.setText(formatValue(model.score))
        }

    }



}

@Scene2dDsl
fun <S> KWidget<S>.scorePanel(
    model: GameModel,
    skin: Skin = Scene2DSkin.defaultSkin,
    init: ScorePanel.(S) -> Unit = {}
): ScorePanel = actor(ScorePanel(model, skin), init)