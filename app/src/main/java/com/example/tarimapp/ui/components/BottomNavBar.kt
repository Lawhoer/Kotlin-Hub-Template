package com.example.tarimapp.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.tarimapp.Screen
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tarimapp.ui.theme.TarimAppTheme

@Composable
fun MainBottomNavBar(navController: NavController, onLogout: () -> Unit) {
    TarimAppTheme {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp, // Çizgi kalınlığı
                    color = Color.Gray, // Çizgi rengi
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp) // Köşe yuvarlaklığı
                )
        ) {
            NavigationBar (
                containerColor = MaterialTheme.colorScheme.background, // Arka plan rengi
                contentColor = MaterialTheme.colorScheme.onSurface // Metin rengi
            ) {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Screen.Profile.route) },
                    label = { Text("Profil") },
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = MaterialTheme.colorScheme.primary, // Seçili değilken ikon rengi
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Screen.Farms.route) },
                    label = { Text("Tarlalarım") },
                    icon = { Icon(Icons.Filled.LocationOn, contentDescription = "Farms") },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = MaterialTheme.colorScheme.primary, // Seçili değilken ikon rengi
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Screen.Piyasa.route) },
                    label = { Text("Piyasa") },
                    icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Market") },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = MaterialTheme.colorScheme.primary, // Seçili değilken ikon rengi
                    )
                )
                // Çıkış butonu
                NavigationBarItem(
                    selected = false,
                    onClick = { onLogout() }, // Burada çıkış fonksiyonunu çağırıyoruz
                    label = { Text("Çıkış") },
                    icon = { Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout") },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = MaterialTheme.colorScheme.primary, // Seçili değilken ikon rengi
                    )
                )
            }
        }
        }
}




