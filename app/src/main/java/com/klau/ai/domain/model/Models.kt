package com.klau.ai.domain.model

import java.time.LocalDateTime

data class Message(
    val id: String,
    val text: String,
    val sender: MessageSender,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

enum class MessageSender {
    USER, AI
}

data class Chat(
    val id: String,
    val title: String,
    val lastMessage: String,
    val updatedAt: LocalDateTime,
    val isPinned: Boolean = false,
    val isArchived: Boolean = false
)

data class Memory(
    val id: String,
    val content: String,
    val category: String,
    val createdAt: LocalDateTime
)

data class Project(
    val id: String,
    val name: String,
    val description: String,
    val context: String
)
