package com.klau.ai.presentation.auth

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.klau.ai.presentation.component.KlauButton
import com.klau.ai.presentation.component.KlauButtonVariant
import com.klau.ai.presentation.component.KlauTextField
import com.klau.ai.presentation.theme.Muted

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onNavigateToSignup: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        
        Text(
            text = "Welcome to Klau",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Normal
        )
        
        Text(
            text = "Sign in to continue your conversations",
            style = MaterialTheme.typography.bodyLarge,
            color = Muted,
            modifier = Modifier.padding(top = 8.dp)
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        Text(
            text = "Email Address",
            style = MaterialTheme.typography.labelSmall,
            color = Muted,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        KlauTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "email@example.com"
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "Password",
            style = MaterialTheme.typography.labelSmall,
            color = Muted,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        KlauTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "••••••••"
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        KlauButton(
            text = "Sign In",
            onClick = onLoginSuccess,
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        KlauButton(
            text = "Need an account? Sign Up",
            onClick = onNavigateToSignup,
            variant = KlauButtonVariant.GHOST,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
