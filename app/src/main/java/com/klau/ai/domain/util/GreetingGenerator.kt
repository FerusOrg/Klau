package com.klau.ai.domain.util

import java.time.LocalTime

object GreetingGenerator {
    fun getGreeting(name: String): String {
        val hour = LocalTime.now().hour
        return when (hour) {
            in 5..11 -> "Good morning, $name. Ready to continue where we left off?"
            in 12..17 -> "Welcome back, $name. What are we working on today?"
            else -> "Back again, $name? Want to continue yesterday’s idea?"
        }
    }
}
