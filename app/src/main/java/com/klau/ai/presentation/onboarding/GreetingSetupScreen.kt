package com.klau.ai.presentation.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.klau.ai.presentation.component.KlauTextField
import com.klau.ai.presentation.theme.Muted

@Composable
fun GreetingSetupScreen(
    onNext: (String, String) -> Unit
) {
    var fullName by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(64.dp))
        
        Text(
            text = "Nice to meet you",
            style = MaterialTheme.typography.headlineLarge
        )
        
        Text(
            text = "How should I address you?",
            style = MaterialTheme.typography.bodyLarge,
            color = Muted,
            modifier = Modifier.padding(top = 8.dp)
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        Text(
            text = "Full Name",
            style = MaterialTheme.typography.labelSmall,
            color = Muted,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        KlauTextField(
            value = fullName,
            onValueChange = { fullName = it },
            placeholder = "Enter your full name"
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "Nickname",
            style = MaterialTheme.typography.labelSmall,
            color = Muted,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        KlauTextField(
            value = nickname,
            onValueChange = { nickname = it },
            placeholder = "What should I call you?"
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        KlauButton(
            text = "Continue",
            onClick = { onNext(fullName, nickname) },
            modifier = Modifier.fillMaxWidth(),
            enabled = fullName.isNotBlank() && nickname.isNotBlank()
        )
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}
