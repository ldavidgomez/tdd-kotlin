package com.apiumhub.poker

import io.kotlintest.specs.BehaviorSpec
import kotlin.test.assertEquals

class PlaysResolver {
    fun jugada(mano1: List<Card>, mano2: List<Card>): List<Card>{

        if (mano1.distinctBy { it.value }.size < mano1.size && mano2.distinctBy { it.value }.size == mano2.size) {
            return mano1
        }

        if (mano1.map { it.value }.max()!! > mano2.map { it.value }.max()!!) {
            return mano1
        }
        return mano2
    }
}

class PlaysTest: BehaviorSpec() {

    init {
        given("Dos manos de 1 carta") {
            val playsResolver = PlaysResolver()
            val valor1 = listOf(Card(1))
            val valor2 = listOf(Card(2))
            `when`("los comparamos") {
                val valorMayor: List<Card> = playsResolver.jugada(valor1, valor2)
                then("Devolvemos el mayor valor") {
                    assertEquals(valor2, valorMayor)
                }
            }
            `when`("los comparamos al revés") {
                val valorMayor = playsResolver.jugada(valor2, valor1)
                then("Devolvemos el mayor valor") {
                    assertEquals(valor2, valorMayor)
                }
            }
        }
        given("Dos manos de N cartas") {
            val playsResolver = PlaysResolver()
            val mano1 = listOf(Card(1), Card(2), Card(3), Card(4), Card(5))
            val mano2 = listOf(Card(2), Card(3), Card(4), Card(5), Card(6))
            `when`("las comparamos") {
                val manoMayor = playsResolver.jugada(mano1, mano2)
                then("Devolvemos la mano con la carta más alta") {
                    assertEquals(mano2, manoMayor)
                }
            }
            `when`("las comparamos alrevés"){
                val manoMayor = playsResolver.jugada(mano2, mano1)
                then ("Devolvemos la mano con la carta más alta"){
                    assertEquals(mano2, manoMayor)
                }
            }
        }

        given("Dos manos de 5 cartas"){
            val playsResolver = PlaysResolver()
            `when`("Una de las dos manos contiene una pareja y la otra no"){
                val mano1 = listOf(Card(1), Card(1), Card(2), Card(3), Card(4))
                val mano2 = listOf(Card(1), Card(2), Card(3), Card(4), Card(5))
                val manoGanadora = playsResolver.jugada(mano1, mano2)
                then("Devolvemos la mano que contiene la pareja") {
                    assertEquals(mano1, manoGanadora)
                }
            }
            `when`("Las dos manos contienen parejas diferentes"){
                val mano1 = listOf(Card(1), Card(1), Card(2), Card(3), Card(4))
                val mano2 = listOf(Card(1), Card(3), Card(3), Card(4), Card(5))
                val manoGanadora = playsResolver.jugada(mano1, mano2)
                then("Devolvemos la mano cuya pareja contenga la carta más alta") {
                    assertEquals(mano2, manoGanadora)
                }
            }
            `when`("Las dos manos al revés contienen parejas diferentes"){
                val mano2 = listOf(Card(1), Card(1), Card(2), Card(3), Card(4))
                val mano1 = listOf(Card(1), Card(3), Card(3), Card(4), Card(5))
                val manoGanadora = playsResolver.jugada(mano1, mano2)
                then("Devolvemos la mano cuya pareja contenga la carta más alta") {
                    assertEquals(mano2, manoGanadora)
                }
            }
            `when`("Las dos manos contienen parejas y las dos cartas de la pareja tienen el mismo valor"){
                then("Devolvemos empate") {

                }
            }
        }
    }
}