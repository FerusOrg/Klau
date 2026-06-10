package com.klau.ai.data.remote

import com.klau.ai.domain.model.Message
import com.klau.ai.domain.repository.AIProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GeminiProvider @Inject constructor() : AIProvider {
    
    override fun generateResponse(
        prompt: String,
        history: List<Message>,
        memory: String?
    ): Flow<String> = flow {
        // Simulation of Klau "thinking" and streaming
        val fullResponse = "I'm Klau, your thinking partner. I've received your message: \"$prompt\". Let's explore this together."
        
        delay(1000) // Initial "thinking" delay
        
        val words = fullResponse.split(" ")
        for (word in words) {
            emit("$word ")
            delay(100) // Streaming delay
        }
    }
}
