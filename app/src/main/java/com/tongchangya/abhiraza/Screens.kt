package com.tongchangya.abhiraza

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalendarScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Bharaw 2876 AE",
            color = Color(0xFFFFE082),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "August 2026 - September 2026",
            color = Color.White,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Week Days
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            listOf("Fri", "Sat", "Sun", "Mon", "Tue", "Wed", "Thu").forEach { day ->
                Text(
                    text = day,
                    color = Color(0xFFFFE082),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))

        // Grid (Placeholder for days)
        for (row in 0..4) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                for (col in 0..6) {
                    val dayNum = row * 7 + col + 1
                    if (dayNum <= 31) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(4.dp)
                                .background(Color(0xFF1B5E20).copy(alpha = 0.5f), RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("$dayNum", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                                Text("($dayNum)", color = Color.White, fontSize = 10.sp)
                            }
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Selected: 11 Bharaw 2876 AE",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )
        Text(
            text = "English: 26 August 2026 · Bengali: ১১ ভাদ্র",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.Start)
        )
    }
}


@Composable
fun HolidaysScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Holidays Screen", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onSurface)
    }
}

@Composable
fun CalculatorScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Calculator Screen", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onSurface)
    }
}

@Composable
fun NotepadScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Notepad Screen", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onSurface)
    }
}

@Composable
fun WallpaperScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Wallpaper Screen", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onSurface)
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Settings Screen", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onSurface)
    }
}
