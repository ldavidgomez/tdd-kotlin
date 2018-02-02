package com.apiumhub.poker

import io.kotlintest.specs.BehaviorSpec
import kotlin.test.assertEquals

class PlaysResolver {
    fun compare(carta1: Int, carta2: Int): Int{
        return if (carta1 > carta2) carta1 else carta2
    }
}

class PlaysTest: BehaviorSpec() {

    init {
        given("Los valores de dos cartas") {
            val playsResolver: PlaysResolver = PlaysResolver()
            val valor1 = 1
            val valor2 = 2
            `when`("los comparamos") {
                val valorMayor: Int = playsResolver.compare(valor1, valor2)
                then("Devolvemos el mayor valor") {
                    assertEquals(valor2, valorMayor)
                }
            }
            `when`("los comparamos al revés") {
                val valorMayor: Int = playsResolver.compare(valor2, valor1)
                then("Devolvemos el mayor valor") {
                    assertEquals(valor2, valorMayor)
                }
            }
        }
    }
}