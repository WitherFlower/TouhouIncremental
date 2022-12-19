package moe.wither.touhouincremental.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.glutils.ShaderProgram
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.app.KtxScreen
import ktx.log.logger
import ktx.scene2d.Scene2DSkin
import moe.wither.touhouincremental.SmoothLabel


class GameScreen : KtxScreen {

    private val stage: Stage = Stage(ExtendViewport(1920f, 1080f))
    private val texture: Texture = Texture("assets/reimu.png").apply {
        setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
    }
    private val progressBarSkin: Skin = Skin(FileHandle("assets/ProgressBarSkin.json"))

    private val table = Table()

    val fontTexture = Texture(Gdx.files.internal("Aller.png"), true).apply {
        setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear)
    }

    private val textFont = BitmapFont(Gdx.files.internal("Aller.fnt"), TextureRegion(fontTexture), false).apply { data.scale(2f) }

    override fun show() {
        log.debug { "GameScreen shown" }

        table.setFillParent(true)
        stage.addActor(table)

        table.pad(20f)

        val label = SmoothLabel("1,000,000,000 Gold", Scene2DSkin.defaultSkin)

        table.add(
            label
        ).row()

        table.add(
            Image(texture).apply { setScaling(Scaling.fit) }
        ).expandY().row()

        table.add(
            ProgressBar(0f, 1f, 0.1f, false, progressBarSkin).apply {
                value = 0.5f

                style.background.minHeight = 50f
                style.knobBefore.minHeight = 50f
            }
        ).fillX().row()

    }


    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun render(delta: Float) {
        with(stage) {
            act(delta)
            draw()
        }


    }

    override fun dispose() {
        stage.dispose()
        texture.dispose()
    }

    companion object {
        private val log = logger<GameScreen>()
    }

}