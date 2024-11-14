package com.example.tugasfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

class About : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasFrontEndTheme {
                AboutScreen(onBackClick = { finish() })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "About",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1B1B2F),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1B1B2F))
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.ajeng),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Ajeng Armelita Saputri",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "armelitajeng@gmail.com",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    text = "Universitas Amikom Purwokerto",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    text = "Informatics",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))


            Text(
                text = "Detail",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            DramaSection(title = "Drama", details = listOf(
                DramaDetail("Ipar Adalah Maut", "2:11 m", "4.5/5.0", "13 Juni 2024", "Drama, Comedy, Romance", "Hanung Bramantyo", "MD Pictures, Dapur Film"),
                DramaDetail("Gita Cinta dari SMA", "1:43 m", "4.0/5.0", "9 Februari 2023", "Drama, Romance", "Monty Tiwa", "MD Pictures"),

            ))
        }
    }
}

data class DramaDetail(
    val title: String,
    val duration: String,
    val rating: String,
    val releaseDate: String,
    val genre: String,
    val director: String,
    val production: String
)

@Composable
fun DramaSection(title: String, details: List<DramaDetail>) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = androidx.compose.ui.text.style.TextAlign.Start
    )
    details.forEach { detail ->
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1F3F)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = detail.title,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Duration: ${detail.duration}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = "Rating: ${detail.rating}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = "Release Date: ${detail.releaseDate}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = "Genre: ${detail.genre}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = "Director: ${detail.director}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                Text(
                    text = "Production: ${detail.production}",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewAboutScreen() {
    TugasFrontEndTheme {
        AboutScreen(onBackClick = {})
    }
}
