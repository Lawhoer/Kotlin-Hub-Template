package com.example.tarimapp

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tarimapp.ui.screens.*
import com.example.tarimapp.ui.components.*

// icinde route degeri taşıyan screenler
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Piyasa : Screen("market")
    object Farms : Screen("farms")
    object Profile : Screen("profile")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavigation(navController: NavHostController) {
    var isAuthenticated by remember { mutableStateOf(false) }

    // Çıkış işlemi fonksiyonu
    val onLogout: () -> Unit = {
        isAuthenticated = false
        navController.navigate(Screen.Login.route) {
            popUpTo(Screen.Piyasa.route) { inclusive = true }
        }
    }

    Scaffold(
        bottomBar = {
            if (isAuthenticated) {
                MainBottomNavBar(navController, onLogout)
            } else {
                AuthBottomNavBar(navController)
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            enterTransition = {
                // Yeni ekran sağdan kayarak gelir
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth }, // Başlangıç pozisyonu (sağdan)
                    animationSpec = tween(durationMillis = 300) // Animasyon süresi
                )
            },
            exitTransition = {
                // Mevcut ekran sola kayarak çıkar
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> -fullWidth }, // Bitiş pozisyonu (sola)
                    animationSpec = tween(durationMillis = 300) // Animasyon süresi
                )
            },
            popEnterTransition = {
                // Geri tuşu ile dönüldüğünde, yeni ekran soldan kayarak gelir
                slideInHorizontally(
                    initialOffsetX = { fullWidth -> -fullWidth }, // Başlangıç pozisyonu (soldan)
                    animationSpec = tween(durationMillis = 300) // Animasyon süresi
                )
            },
            popExitTransition = {
                // Geri tuşu ile dönüldüğünde, mevcut ekran sağa kayarak çıkar
                slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth }, // Bitiş pozisyonu (sağa)
                    animationSpec = tween(durationMillis = 300) // Animasyon süresi
                )
            }
        ) {
            composable(Screen.Login.route) {
                LoginScreen(navController, onLoginSuccess = { isAuthenticated = true })
            }
            composable(Screen.Register.route) { RegisterScreen(navController) }
            composable(Screen.Piyasa.route) { PiyasaScreen(navController) }
            composable(Screen.Profile.route) { ProfileScreen(navController) }
            composable(Screen.Farms.route) { FarmScreen(navController) }
        }
    }
}

