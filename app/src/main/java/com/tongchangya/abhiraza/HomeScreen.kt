package com.tongchangya.abhiraza

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HomeScreen() {
    var currentTime by remember { mutableStateOf(Calendar.getInstance().time) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentTime = Calendar.getInstance().time
        }
    }

    val timeFormat = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())
    val dateFormat = SimpleDateFormat("EEE, dd MMMM yyyy", Locale.getDefault())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top branding
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Shield Placeholder
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF1B5E20), shape = RoundedCornerShape(20.dp))
                    .border(2.dp, Color(0xFFFFE082), RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("🛡️", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "TONGCHANGYA COMMUNITY",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "SINCE 850 BCE TO PRESENT",
                    color = Color(0xFFFFE082),
                    fontSize = 10.sp,
                    letterSpacing = 0.5.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // App Title Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1B5E20).copy(alpha = 0.7f))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Abhiraza Calendar", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Row {
                Text("2876 AE", color = Color(0xFFFFE082), fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text("🌐 Website", color = Color.White, fontSize = 14.sp)
            }
        }
        
        Spacer(modifier = Modifier.height(2.dp))
        Divider(color = Color(0xFFFFE082), thickness = 2.dp)

        Spacer(modifier = Modifier.height(32.dp))

        // Time display
        Text(
            text = timeFormat.format(currentTime),
            color = Color.White,
            fontSize = 48.sp,
            fontWeight = FontWeight.Light,
            letterSpacing = 2.sp
        )
        // Burmese/Tongchangya script placeholder
        Text(
            text = "၁၁:၃၇:၂၀ pm",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "GOODNIGHT - LAABHA RAAIT/GAWMEY GHUM ZAW - শুভ রাত্রি",
            color = Color(0xFFFFE082),
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 1.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "ABHIRAZA ERA: Bharaw 11 (၁၁), 2876 (၂၈၇၆) AE",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = dateFormat.format(currentTime),
            color = Color(0xFFC8E6C9),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "ভাদ্র ১১ (১৪৩৩ BS)",
            color = Color.White,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Cloud, contentDescription = "Weather", tint = Color(0xFFFFE082))
            Spacer(modifier = Modifier.width(8.dp))
            Text("20°C Partly cloudy", color = Color.White, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.weight(1f))

        // Cards Section
        InfoCard(title = "TONGCHANGYA - ABHIRAZA ERA", value = "2876 AE", isMain = true)
        Spacer(modifier = Modifier.height(8.dp))
        InfoCard(title = "ENGLISH / GREGORIAN", value = "2026 CE", isMain = false)
        Spacer(modifier = Modifier.height(8.dp))
        InfoCard(title = "BENGALI ERA - BANGABDA", value = "১৪৩৩ BS", isMain = false)
        
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun InfoCard(title: String, value: String, isMain: Boolean) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isMain) Color(0xFF1B5E20).copy(alpha = 0.4f) else Color.Black.copy(alpha = 0.4f)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, color = Color(0xFFA5D6A7), fontSize = 12.sp, letterSpacing = 1.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = value, color = if (isMain) Color.White else Color(0xFFFFE082), fontSize = if (isMain) 24.sp else 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}
