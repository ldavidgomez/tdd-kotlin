package com.apiumhub.poker

class Card(val value: Int) {
    override fun equals(other: Any?): Boolean {
        if (other !is Card) {
            return false
        }
        return this.value == other.value
    }

    override fun toString(): String {
        return "" + value
    }
}