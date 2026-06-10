package com.klau.ai.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.klau.ai.presentation.theme.Ink
import com.klau.ai.presentation.theme.Muted
import com.klau.ai.presentation.theme.OnPrimary
import com.klau.ai.presentation.theme.Primary
import com.klau.ai.presentation.theme.SurfaceSoft

@Composable
fun ChatInput(
    value: String,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit,
    onVoice: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .heightIn(min = 44.dp, max = 120.dp)
                .background(SurfaceSoft, RoundedCornerShape(22.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (value.isEmpty()) {
                Text(
                    text = "Ask Klau anything...",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Muted
                )
            }
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.bodyLarge.copy(color = Ink),
                cursorBrush = SolidColor(Ink)
            )
        }
        
        IconButton(
            onClick = if (value.isEmpty()) onVoice else onSend,
            modifier = Modifier
                .padding(start = 8.dp)
                .size(44.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Primary,
                contentColor = OnPrimary
            )
        ) {
            Icon(
                imageVector = if (value.isEmpty()) Icons.Default.Mic else Icons.AutoMirrored.Default.Send,
                contentDescription = "Send message",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
