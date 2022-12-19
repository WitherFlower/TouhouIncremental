package moe.wither.touhouincremental.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.TextureRegion
import ktx.assets.disposeSafely
import ktx.scene2d.Scene2DSkin
import ktx.style.label
import ktx.style.progressBar
import ktx.style.skin

fun loadSkin() {
    Scene2DSkin.defaultSkin = skin() { skin ->
        label {
            val fontFileName = "Olney"
            val fontTexture = Texture(Gdx.files.internal("$fontFileName.png"), true).apply {
                setFilter(Texture.TextureFilter.MipMapLinearNearest, Texture.TextureFilter.Linear)
            }

            font = BitmapFont(
                Gdx.files.internal("$fontFileName.fnt"),
                TextureRegion(fontTexture),
                false
            ).apply {
                data.scale(0.5f)
                setFixedWidthGlyphs("0123456789")
            }

        }

    }
}

fun disposeSkin() {
    Scene2DSkin.defaultSkin.disposeSafely()
}