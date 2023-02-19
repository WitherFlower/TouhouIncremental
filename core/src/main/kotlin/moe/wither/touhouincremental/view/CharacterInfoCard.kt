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

class CharacterInfoCard(
    model: GameModel,
    skin: Skin
) : Table(skin), KTable {

    companion object {
        const val iconSize = 150f
    }

    init {

        pad(10f)
        debug = true

        height = iconSize

        val iconTexture = Texture("assets/ReimuIcon.png").apply {
            setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
            sizeBy(iconSize, iconSize)
        }

        image(iconTexture) {
            it.left()
            it.size(iconSize,iconSize)
            onClick { stage.fire(EnemyClickedEvent()) }
        }

        table {
            debug = true

            this.right()
            this.top()

            it.grow()

            table{
                smoothLabel("Keine Kamishirazawa", skin) {
                    setFontScale(0.9f)
                }

            }


            row()
            table{
//                smoothLabel("Upgrade", skin) {
//                    setFontScale(0.9f)
//                }

                button {
                    smoothLabel("Upgrade", skin) {
                        setFontScale(0.9f)
                    }
                }

                it.growY()
                it.right()
            }
        }

    }

}


@Scene2dDsl
fun <S> KWidget<S>.characterInfoCard(
    model: GameModel,
    skin: Skin = Scene2DSkin.defaultSkin,
    init: CharacterInfoCard.(S) -> Unit = {}
): CharacterInfoCard = actor(CharacterInfoCard(model, skin), init)