package com.klau.ai.presentation.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klau.ai.domain.model.Message
import com.klau.ai.domain.model.MessageSender
import com.klau.ai.domain.repository.AIProvider
import com.klau.ai.domain.util.GreetingGenerator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

data class ChatState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val aiProvider: AIProvider
) : ViewModel() {

    private val _state = MutableStateFlow(ChatState())
    val state: StateFlow<ChatState> = _state.asStateFlow()

    init {
        // Initialize with contextual greeting
        val greetingText = GreetingGenerator.getGreeting("Thinker") // TODO: Get from profile
        val greetingMessage = Message(
            id = UUID.randomUUID().toString(),
            text = greetingText,
            sender = MessageSender.AI
        )
        _state.update { it.copy(messages = listOf(greetingMessage)) }
    }

    fun sendMessage(text: String) {
        if (text.isBlank()) return

        val userMessage = Message(
            id = UUID.randomUUID().toString(),
            text = text,
            sender = MessageSender.USER
        )

        _state.update { it.copy(messages = it.messages + userMessage, isLoading = true) }

        viewModelScope.launch {
            val aiMessageId = UUID.randomUUID().toString()
            var aiText = ""
            
            val aiMessage = Message(
                id = aiMessageId,
                text = "",
                sender = MessageSender.AI
            )
            
            _state.update { it.copy(messages = it.messages + aiMessage) }

            aiProvider.generateResponse(text, _state.value.messages).collect { chunk ->
                aiText += chunk
                _state.update { currentState ->
                    val updatedMessages = currentState.messages.map { msg ->
                        if (msg.id == aiMessageId) msg.copy(text = aiText) else msg
                    }
                    currentState.copy(messages = updatedMessages)
                }
            }
            
            _state.update { it.copy(isLoading = false) }
        }
    }
}
