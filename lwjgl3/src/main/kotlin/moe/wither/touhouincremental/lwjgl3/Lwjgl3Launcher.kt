@file:JvmName("Lwjgl3Launcher")

package moe.wither.touhouincremental.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import moe.wither.touhouincremental.TouhouIncremental

/** Launches the desktop (LWJGL3) application. */
fun main() {
    Lwjgl3Application(TouhouIncremental(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("TouhouIncremental")
        setWindowedMode(640, 480)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
