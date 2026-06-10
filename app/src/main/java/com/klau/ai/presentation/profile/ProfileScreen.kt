package com.klau.ai.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.klau.ai.presentation.component.KlauTextField
import com.klau.ai.presentation.theme.Canvas
import com.klau.ai.presentation.theme.Ink
import com.klau.ai.presentation.theme.Muted
import com.klau.ai.presentation.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile", style = MaterialTheme.typography.titleMedium) },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.padding(vertical = 32.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(Primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "K",
                        style = MaterialTheme.typography.displaySmall,
                        color = Color.White
                    )
                }
                IconButton(
                    onClick = { /* TODO: Change Pic */ },
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Ink)
                ) {
                    Icon(
                        Icons.Default.CameraAlt,
                        contentDescription = "Edit",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            ProfileItem("Name", "Klau User")
            Spacer(modifier = Modifier.height(24.dp))
            ProfileItem("Nickname", "Thinker")
            Spacer(modifier = Modifier.height(24.dp))
            ProfileItem("Email", "user@example.com")
            
            Spacer(modifier = Modifier.weight(1f))
            
            Text(
                text = "Joined June 2026",
                style = MaterialTheme.typography.labelSmall,
                color = Muted
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProfileItem(label: String, value: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = Muted
        )
        Spacer(modifier = Modifier.height(8.dp))
        KlauTextField(
            value = value,
            onValueChange = {},
            placeholder = ""
        )
    }
}
