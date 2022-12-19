package moe.wither.touhouincremental

import ktx.app.KtxGame
import ktx.app.KtxScreen
import moe.wither.touhouincremental.screen.GameScreen
import moe.wither.touhouincremental.screen.UIScreen
import java.math.BigDecimal


class TouhouIncremental : KtxGame<KtxScreen>() {

    override fun create() {
        addScreen(UIScreen())
        setScreen<UIScreen>()
    }

}
