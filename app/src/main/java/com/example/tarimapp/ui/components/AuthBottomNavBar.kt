package com.example.tarimapp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tarimapp.ui.theme.TarimAppTheme // Tema fonksiyonunu import et

@Composable
fun AuthBottomNavBar(navController: NavController) {
    TarimAppTheme {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp, // Çizgi kalınlığı
                    color = Color.Gray, // Çizgi rengi
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp) // Köşe yuvarlaklığı
                )
        ) {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.background, // Arka plan rengi
                contentColor = MaterialTheme.colorScheme.onSurface // Metin rengi
            ) {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Screen.Login.route) },
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Giriş") },
                    label = { Text("Giriş") },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = MaterialTheme.colorScheme.primary, // Seçili değilken ikon rengi
                        indicatorColor = Color.Transparent
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Screen.Register.route) },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "Kayıt") },
                    label = { Text("Kayıt") },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = MaterialTheme.colorScheme.primary, // Seçili değilken ikon rengi

                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate(Screen.Piyasa.route) },
                    icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = "Piyasa") },
                    label = { Text("Piyasa") },
                    colors = NavigationBarItemDefaults.colors(
                        unselectedIconColor = MaterialTheme.colorScheme.primary, // Seçili değilken ikon rengi

                    )
                )
            }
        }
    }
}
