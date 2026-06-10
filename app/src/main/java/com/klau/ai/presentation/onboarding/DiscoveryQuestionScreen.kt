package com.klau.ai.presentation.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.klau.ai.presentation.component.KlauButton
import com.klau.ai.presentation.component.KlauButtonVariant
import com.klau.ai.presentation.theme.Muted

@Composable
fun DiscoveryQuestionScreen(
    onNext: (String) -> Unit
) {
    val options = listOf("YouTube", "Friend", "Instagram", "Google Search", "Advertisement", "School/College", "Other")
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        
        Text(
            text = "One quick thing",
            style = MaterialTheme.typography.headlineLarge
        )
        
        Text(
            text = "How did you hear about Klau?",
            style = MaterialTheme.typography.bodyLarge,
            color = Muted,
            modifier = Modifier.padding(top = 8.dp)
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(options) { option ->
                KlauButton(
                    text = option,
                    onClick = { selectedOption = option },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    variant = if (selectedOption == option) KlauButtonVariant.PRIMARY else KlauButtonVariant.SECONDARY
                )
            }
        }
        
        KlauButton(
            text = "Continue",
            onClick = { selectedOption?.let { onNext(it) } },
            modifier = Modifier.fillMaxWidth(),
            enabled = selectedOption != null
        )
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}
