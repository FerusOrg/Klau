package com.klau.ai.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.klau.ai.domain.model.MessageSender

@Entity(tableName = "chats")
data class ChatEntity(
    @PrimaryKey val id: String,
    val title: String,
    val lastMessage: String,
    val updatedAt: Long,
    val isPinned: Boolean,
    val isArchived: Boolean
)

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey val id: String,
    val chatId: String,
    val text: String,
    val sender: MessageSender,
    val timestamp: Long
)

@Entity(tableName = "memories")
data class MemoryEntity(
    @PrimaryKey val id: String,
    val content: String,
    val category: String,
    val createdAt: Long
)
