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

    private val scoreLabel: SmoothLabel
    private val powerLabel: SmoothLabel
    private val pointValueLabel: SmoothLabel

    init {

        debug = true
        pad(20f)

        left()

        scoreLabel = smoothLabel("Score : 1,234,567,890", skin) {
            it.left()
        }

        row()

        powerLabel = smoothLabel("Power : 128", skin) {
            it.left()
        }

        row()

        pointValueLabel = smoothLabel("Point Value : 10,000", skin) {
            it.left()
        }

        // Data Binding

        model.onPropertyChange(model::score) {
            scoreLabel.setText("Score : ${formatValue(model.score)}")
        }

        model.onPropertyChange(model::power) {
            powerLabel.setText("Power : ${formatValue(model.power)}")
        }

        model.onPropertyChange(model::pointValue) {
            pointValueLabel.setText("Point Value : ${formatValue(model.pointValue)}")
        }

    }


}

@Scene2dDsl
fun <S> KWidget<S>.scorePanel(
    model: GameModel,
    skin: Skin = Scene2DSkin.defaultSkin,
    init: ScorePanel.(S) -> Unit = {}
): ScorePanel = actor(ScorePanel(model, skin), init)