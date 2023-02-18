package moe.wither.touhouincremental.model

import com.badlogic.gdx.scenes.scene2d.Event
import com.badlogic.gdx.scenes.scene2d.EventListener
import com.badlogic.gdx.scenes.scene2d.Stage
import moe.wither.touhouincremental.event.EnemyClickedEvent
import moe.wither.touhouincremental.math.BigDouble

class GameModel(stage: Stage) : PropertySourceChange(), EventListener {

    var score: BigDouble = BigDouble(0)
        private set(value) {
            notify(::score, value)
            field = value
        }

    var power: BigDouble = BigDouble(0)
        private set(value) {
            notify(::power, value)
            field = value
        }

    var pointValue: BigDouble = BigDouble(10000)
        private set(value) {
            notify(::pointValue, value)
            field = value
        }

    var enemyLife: BigDouble = BigDouble(10)
        private set(value) {
            notify(::enemyLife, value)
            field = value
        }

    var maxEnemyLife: BigDouble = BigDouble(10)
        private set(value) {
            notify(::maxEnemyLife, value)
            field = value
        }

    init {
        stage.addListener(this)
    }

    override fun handle(event: Event?): Boolean {
        when (event) {
            is EnemyClickedEvent -> {
                enemyLife = enemyLife.subtract(1)
                score = score.add(10)
                if( enemyLife <= 0) {
                    enemyLife = BigDouble(10)
                    power = power.add(1)
                    score = score.add(pointValue)
                }
                println(enemyLife.mantissa)
            }
        }
        return true
    }


}