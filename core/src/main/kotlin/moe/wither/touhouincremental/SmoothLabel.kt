package moe.wither.touhouincremental

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.glutils.ShaderProgram
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import ktx.scene2d.KWidget
import ktx.scene2d.Scene2dDsl
import ktx.scene2d.actor

class SmoothLabel(text: CharSequence?, skin: Skin) : Label(text, skin) {

    companion object {
        val fontShader = ShaderProgram(Gdx.files.internal ("shaders/font.vert"), Gdx.files.internal ("shaders/font.frag"))
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        batch?.shader = fontShader
        super.draw(batch, parentAlpha)
        batch?.shader = null
    }

}


@Scene2dDsl
fun <S> KWidget<S>.smoothLabel(
    charSequence: CharSequence?,
    skin: Skin,
    init: SmoothLabel.(S) -> Unit = {}
) : SmoothLabel = actor(SmoothLabel(charSequence, skin), init)