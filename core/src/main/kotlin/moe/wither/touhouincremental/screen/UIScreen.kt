package moe.wither.touhouincremental.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.actors.onClick
import ktx.app.KtxScreen
import ktx.scene2d.actors
import moe.wither.touhouincremental.event.EnemyClickedEvent
import moe.wither.touhouincremental.event.fire
import moe.wither.touhouincremental.model.GameModel
import moe.wither.touhouincremental.view.GameView
import moe.wither.touhouincremental.view.disposeSkin
import moe.wither.touhouincremental.view.gameView
import moe.wither.touhouincremental.view.loadSkin

class UIScreen : KtxScreen{

    private val stage: Stage = Stage(ExtendViewport(1920f, 1080f))
    private var model = GameModel(stage)
    private lateinit var gameView: GameView

    init {
        loadSkin()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun show() {
        stage.clear()
        stage.addListener(model)

        stage.actors {
            gameView = gameView(model)
        }

        Gdx.input.inputProcessor = stage
    }

    override fun render(delta: Float) {

//        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
//            stage.fire(EnemyClickedEvent())
//        }

        stage.act()
        stage.draw()
    }

    override fun dispose() {
        stage.dispose()
        disposeSkin()
    }

}