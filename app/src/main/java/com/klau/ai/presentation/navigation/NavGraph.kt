package com.klau.ai.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.klau.ai.presentation.auth.LoginScreen
import com.klau.ai.presentation.chat.ChatScreen
import com.klau.ai.presentation.onboarding.GreetingSetupScreen
import com.klau.ai.presentation.onboarding.DiscoveryQuestionScreen
import com.klau.ai.presentation.onboarding.InterestSelectionScreen
import com.klau.ai.presentation.onboarding.PersonalitySelectionScreen
import com.klau.ai.presentation.profile.ProfileScreen
import com.klau.ai.presentation.settings.SettingsScreen

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Chat : Screen("chat")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
    object OnboardingGreeting : Screen("onboarding_greeting")
    object OnboardingDiscovery : Screen("onboarding_discovery")
    object OnboardingInterests : Screen("onboarding_interests")
    object OnboardingPersonality : Screen("onboarding_personality")
}

@Composable
fun KlauNavGraph(
    navController: NavHostController,
    onMenuClick: () -> Unit,
    startDestination: String = Screen.Auth.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Auth.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.OnboardingGreeting.route) {
                        popUpTo(Screen.Auth.route) { inclusive = true }
                    }
                },
                onNavigateToSignup = { /* TODO */ }
            )
        }
        
        composable(Screen.OnboardingGreeting.route) {
            GreetingSetupScreen(
                onNext = { _, _ -> navController.navigate(Screen.OnboardingDiscovery.route) }
            )
        }
        
        composable(Screen.OnboardingDiscovery.route) {
            DiscoveryQuestionScreen(
                onNext = { _ -> navController.navigate(Screen.OnboardingInterests.route) }
            )
        }
        
        composable(Screen.OnboardingInterests.route) {
            InterestSelectionScreen(
                onNext = { _ -> navController.navigate(Screen.OnboardingPersonality.route) }
            )
        }
        
        composable(Screen.OnboardingPersonality.route) {
            PersonalitySelectionScreen(
                onNext = { _ ->
                    navController.navigate(Screen.Chat.route) {
                        popUpTo(Screen.OnboardingGreeting.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.Chat.route) {
            ChatScreen(
                onMenuClick = onMenuClick
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(onBack = { navController.popBackStack() })
        }

        composable(Screen.Settings.route) {
            SettingsScreen(onBack = { navController.popBackStack() })
        }
    }
}
