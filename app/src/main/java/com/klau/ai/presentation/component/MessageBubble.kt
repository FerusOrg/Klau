package com.klau.ai.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.klau.ai.domain.model.Message
import com.klau.ai.domain.model.MessageSender
import com.klau.ai.presentation.theme.Ink
import com.klau.ai.presentation.theme.OnPrimary
import com.klau.ai.presentation.theme.SurfaceCard

@Composable
fun MessageBubble(
    message: Message,
    modifier: Modifier = Modifier
) {
    val isAi = message.sender == MessageSender.AI
    val alignment = if (isAi) Alignment.CenterStart else Alignment.CenterEnd
    val backgroundColor = if (isAi) SurfaceCard else MaterialTheme.colorScheme.primary
    val textColor = if (isAi) Ink else OnPrimary
    val shape = if (isAi) {
        RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomEnd = 12.dp, bottomStart = 2.dp)
    } else {
        RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 12.dp, bottomEnd = 2.dp)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        contentAlignment = alignment
    ) {
        Surface(
            color = backgroundColor,
            shape = shape,
            modifier = Modifier.fillMaxWidth(0.85f)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                if (isAi) {
                    // AI messages use Serif for editorial feel
                    Text(
                        text = message.text,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontFamily = FontFamily.Serif
                        ),
                        color = textColor
                    )
                } else {
                    Text(
                        text = message.text,
                        style = MaterialTheme.typography.bodyLarge,
                        color = textColor
                    )
                }
            }
        }
    }
}
