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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.klau.ai.presentation.component.KlauButton
import com.klau.ai.presentation.component.KlauButtonVariant
import com.klau.ai.presentation.theme.Muted

@Composable
fun InterestSelectionScreen(
    onNext: (List<String>) -> Unit
) {
    val interests = listOf("Study", "Coding", "Productivity", "Creativity", "Daily life", "Business", "Fitness", "General assistance")
    val selectedInterests = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        
        Text(
            text = "What's on your mind?",
            style = MaterialTheme.typography.headlineLarge
        )
        
        Text(
            text = "Select what you want help with",
            style = MaterialTheme.typography.bodyLarge,
            color = Muted,
            modifier = Modifier.padding(top = 8.dp)
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(interests) { interest ->
                KlauButton(
                    text = interest,
                    onClick = { 
                        if (selectedInterests.contains(interest)) {
                            selectedInterests.remove(interest)
                        } else {
                            selectedInterests.add(interest)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    variant = if (selectedInterests.contains(interest)) KlauButtonVariant.PRIMARY else KlauButtonVariant.SECONDARY
                )
            }
        }
        
        KlauButton(
            text = "Continue",
            onClick = { onNext(selectedInterests.toList()) },
            modifier = Modifier.fillMaxWidth(),
            enabled = selectedInterests.isNotEmpty()
        )
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}
