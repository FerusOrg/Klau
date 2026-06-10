package com.klau.ai.presentation.settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.klau.ai.presentation.theme.Canvas
import com.klau.ai.presentation.theme.Muted

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings", style = MaterialTheme.typography.titleMedium) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Canvas)
            )
        },
        containerColor = Canvas
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp)
        ) {
            item { SettingSection("General") }
            item { SettingItem("Theme", "Light") }
            item { SettingItem("Notifications", "On") }
            item { SettingItem("Language", "English") }
            
            item { SettingSection("AI") }
            item { SettingItem("Personality", "Calm Companion") }
            item { SettingItem("Response Length", "Balanced") }
            item { SettingItem("Memory", "Enabled") }
            
            item { SettingSection("Privacy") }
            item { SettingItem("Export Chats", "") }
            item { SettingItem("Delete Memory", "") }
            
            item { SettingSection("About") }
            item { SettingItem("Terms of Service", "") }
            item { SettingItem("Privacy Policy", "") }
            item { SettingItem("App Version", "1.0.0") }
            
            item { Spacer(modifier = Modifier.height(40.dp)) }
        }
    }
}

@Composable
fun SettingSection(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelSmall,
        color = Muted,
        modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
    )
}

@Composable
fun SettingItem(title: String, value: String) {
    Surface(
        onClick = { /* TODO */ },
        color = Color.Transparent,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge)
            if (value.isNotEmpty()) {
                Text(text = value, style = MaterialTheme.typography.bodyLarge, color = Muted)
            }
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
    }
}
