package com.tongchangya.abhiraza

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Calendar : Screen("calendar", "Calendar", Icons.Default.DateRange)
    object Holidays : Screen("holidays", "Holidays", Icons.Default.Star)
    object Calculator : Screen("calculator", "Calculator", Icons.Default.Calculate)
    object Notepad : Screen("notepad", "Notepad", Icons.Default.Notes)
    object Wallpaper : Screen("wallpaper", "Wallpaper", Icons.Default.Wallpaper)
    object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}

val items = listOf(
    Screen.Home,
    Screen.Calendar,
    Screen.Holidays,
    Screen.Calculator,
    Screen.Notepad,
    Screen.Wallpaper,
    Screen.Settings
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    
    // Background Image
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.scene03),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        // Dark overlay to make text readable
        Box(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.5f)))
        
        Scaffold(
            containerColor = Color.Transparent, // Let the background show through
            bottomBar = { AppBottomNavigation(navController) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Home.route) { HomeScreen() }
                composable(Screen.Calendar.route) { CalendarScreen() }
                composable(Screen.Holidays.route) { HolidaysScreen() }
                composable(Screen.Calculator.route) { CalculatorScreen() }
                composable(Screen.Notepad.route) { NotepadScreen() }
                composable(Screen.Wallpaper.route) { WallpaperScreen() }
                composable(Screen.Settings.route) { SettingsScreen() }
            }
        }
    }
}

@Composable
fun AppBottomNavigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color(0xFF111C14).copy(alpha = 0.95f),
        contentColor = Color(0xFF81C784)
    ) {
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title, style = MaterialTheme.typography.labelSmall, maxLines = 1) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFFE082),
                    selectedTextColor = Color(0xFFFFE082),
                    unselectedIconColor = Color(0xFF81C784),
                    unselectedTextColor = Color(0xFF81C784),
                    indicatorColor = Color(0xFF1B5E20)
                )
            )
        }
    }
}
