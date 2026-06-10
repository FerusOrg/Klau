package com.klau.ai.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.klau.ai.presentation.theme.Hairline
import com.klau.ai.presentation.theme.Ink
import com.klau.ai.presentation.theme.OnPrimary
import com.klau.ai.presentation.theme.Primary
import com.klau.ai.presentation.theme.PrimaryDisabled

enum class KlauButtonVariant {
    PRIMARY, SECONDARY, OUTLINE, GHOST
}

@Composable
fun KlauButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    variant: KlauButtonVariant = KlauButtonVariant.PRIMARY,
    enabled: Boolean = true,
    isLoading: Boolean = false
) {
    val colors = when (variant) {
        KlauButtonVariant.PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = Primary,
            contentColor = OnPrimary,
            disabledContainerColor = PrimaryDisabled,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
        KlauButtonVariant.SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = Ink
        )
        KlauButtonVariant.OUTLINE -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Ink
        )
        KlauButtonVariant.GHOST -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Ink
        )
    }

    val border = if (variant == KlauButtonVariant.OUTLINE) {
        BorderStroke(1.dp, Hairline)
    } else null

    Button(
        onClick = onClick,
        modifier = modifier.height(40.dp),
        enabled = enabled && !isLoading,
        shape = RoundedCornerShape(8.dp),
        colors = colors,
        border = border,
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
        elevation = null
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = OnPrimary,
                strokeWidth = 2.dp
            )
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}
