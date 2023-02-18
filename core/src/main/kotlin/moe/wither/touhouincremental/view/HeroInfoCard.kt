package moe.wither.touhouincremental.view

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import ktx.actors.onClick
import ktx.scene2d.*
import moe.wither.touhouincremental.event.EnemyClickedEvent
import moe.wither.touhouincremental.event.fire
import moe.wither.touhouincremental.model.GameModel
import moe.wither.touhouincremental.smoothLabel

class HeroInfoCard(
    model: GameModel,
    skin: Skin
) : Table(skin), KTable {

    init {

        pad(10f)

        val iconTexture = Texture("assets/ReimuIcon.png").apply {
            setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        }

        image(iconTexture) {
            it.left()
            it.size(150f,150f)
            onClick { stage.fire(EnemyClickedEvent()) }
        }

        table {
            debug = true

            this.right()
            this.top()

            it.expand()
            it.fill()

            smoothLabel("Reimu Hakurei", skin) {
                setFontScale(0.9f)
            }

            row()

            smoothLabel("Upgrade", skin) {
                setFontScale(0.9f)
                it.expandY()
            }
        }

    }

}


@Scene2dDsl
fun <S> KWidget<S>.heroInfoCard(
    model: GameModel,
    skin: Skin = Scene2DSkin.defaultSkin,
    init: HeroInfoCard.(S) -> Unit = {}
): HeroInfoCard = actor(HeroInfoCard(model, skin), init)