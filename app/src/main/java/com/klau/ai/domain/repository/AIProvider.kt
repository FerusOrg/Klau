package com.klau.ai.domain.repository

import com.klau.ai.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface AIProvider {
    /**
     * Generates a streaming response from the AI model.
     * @param prompt The current user input.
     * @param history The conversation history for context.
     * @param memory Relevant snippets from Klau's long-term memory.
     * @return A Flow of partial response strings.
     */
    fun generateResponse(
        prompt: String,
        history: List<Message>,
        memory: String? = null
    ): Flow<String>
}
