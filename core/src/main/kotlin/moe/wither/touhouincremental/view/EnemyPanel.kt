package moe.wither.touhouincremental.view

import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.Scaling
import ktx.actors.onClick
import ktx.scene2d.*
import moe.wither.touhouincremental.event.EnemyClickedEvent
import moe.wither.touhouincremental.event.fire
import moe.wither.touhouincremental.math.BigDouble
import moe.wither.touhouincremental.model.GameModel

class EnemyPanel(
    model: GameModel,
    skin: Skin
) : Table(skin), KTable {

    private val texture: Texture
    private val progressBarSkin: Skin
    private val progressBar: ProgressBar

    init {
        pad(20f)
        debug = true

        texture = Texture("assets/reimu.png").apply {
            setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        }

        progressBarSkin = Skin(FileHandle("assets/ProgressBarSkin.json"))


        image(texture) {
            setScaling(Scaling.fit)
            it.expandY()
            onClick { stage.fire(EnemyClickedEvent()) }
        }
        row()

        progressBar = progressBar(0f, 1f, 0.1f, false, skin = progressBarSkin) {
            value = 1f

            style.background.minHeight = 50f
            style.knobBefore.minHeight = 50f

            it.fillX()
        }

        // Data Binding

        model.onPropertyChange(model::enemyLife) {
            setLife(it, model.maxEnemyLife)
        }

    }

    private fun setLife(life: BigDouble, maxLife: BigDouble) {
        progressBar.value = BigDouble(life).divide(maxLife).toDouble().toFloat()
    }

}

@Scene2dDsl
fun <S> KWidget<S>.enemyPanel(
    model: GameModel,
    skin: Skin = Scene2DSkin.defaultSkin,
    init: EnemyPanel.(S) -> Unit = {}
): EnemyPanel = actor(EnemyPanel(model, skin), init)