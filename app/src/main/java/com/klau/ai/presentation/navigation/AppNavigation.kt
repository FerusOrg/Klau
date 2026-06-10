package com.klau.ai.presentation.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.klau.ai.presentation.theme.Canvas
import com.klau.ai.presentation.theme.Hairline
import com.klau.ai.presentation.theme.Muted
import kotlinx.coroutines.launch

@Composable
fun AppNavigationWrapper() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Canvas,
                drawerTonalElevation = 0.dp,
                modifier = Modifier.width(300.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 12.dp)
                ) {
                    Spacer(modifier = Modifier.padding(top = 24.dp))
                    Text(
                        text = "Chat History",
                        style = MaterialTheme.typography.titleSmall,
                        color = Muted,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                    )
                    
                    // Chat History List
                    NavigationDrawerItem(
                        label = { Text("Recent Chat 1") },
                        selected = true,
                        onClick = { scope.launch { drawerState.close() } },
                        icon = { Icon(Icons.Default.History, contentDescription = null) },
                        colors = NavigationDrawerItemDefaults.colors(
                            unselectedContainerColor = Canvas,
                            selectedContainerColor = MaterialTheme.colorScheme.surface
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    HorizontalDivider(color = Hairline)
                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    NavigationDrawerItem(
                        label = { Text("Profile") },
                        selected = false,
                        onClick = { 
                            scope.launch { drawerState.close() }
                            navController.navigate(Screen.Profile.route)
                        },
                        icon = { Icon(Icons.Default.Person, contentDescription = null) },
                        colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Canvas)
                    )
                    NavigationDrawerItem(
                        label = { Text("Settings") },
                        selected = false,
                        onClick = { 
                            scope.launch { drawerState.close() }
                            navController.navigate(Screen.Settings.route)
                        },
                        icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                        colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Canvas)
                    )
                    NavigationDrawerItem(
                        label = { Text("Logout") },
                        selected = false,
                        onClick = { 
                            scope.launch { drawerState.close() }
                            navController.navigate(Screen.Auth.route) {
                                popUpTo(0) { inclusive = true }
                            }
                        },
                        icon = { Icon(Icons.Default.Logout, contentDescription = null) },
                        colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Canvas)
                    )
                    Spacer(modifier = Modifier.padding(bottom = 24.dp))
                }
            }
        }
    ) {
        KlauNavGraph(
            navController = navController,
            onMenuClick = {
                scope.launch { drawerState.open() }
            }
        )
    }
}
