package com.example.tugasfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

class Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasFrontEndTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Surface(
        color = Color(0xFF0A0D2C),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Home",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                CategoriesSection()
                Spacer(modifier = Modifier.height(16.dp))
                NewMoviesSection()
            }
            BottomNavigationBar(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Composable
fun CategoriesSection() {
    Text(
        text = "Categories",
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        item { CategoryIcon(R.drawable.drama, "Drama") }
        item { CategoryIcon(R.drawable.romance, "Romance") }
        item { CategoryIcon(R.drawable.thriller, "Thriller") }
        item { CategoryIcon(R.drawable.horror, "Horror") }
        item { CategoryIcon(R.drawable.action, "Action") }
        item { CategoryIcon(R.drawable.fiction, "Fiction") }
        item { CategoryIcon(R.drawable.comedy, "Comedy") }
        item { CategoryIcon(R.drawable.fantasy, "Fantasy") }
        item { CategoryIcon(R.drawable.animation, "Animation") }
        item { CategoryIcon(R.drawable.mystery, "Mystery") }
    }
}

@Composable
fun CategoryIcon(iconRes: Int, contentDescription: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1F3F)),
        modifier = Modifier.size(72.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = contentDescription,
                modifier = Modifier.size(36.dp)
            )
            Text(
                text = contentDescription,
                color = Color.White,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun NewMoviesSection() {
    Text(
        text = "New Movies",
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(8.dp))
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item { MovieItem("Ipar Adalah Maut", "2h 11m", "4.5/5", "13 Juni 2024", "Drama, Comedy, Romance", "Hanung Bramantyo", "MD Pictures, Dapur Film") }
        item { MovieItem("Panggonan Wingit", "1h 50m", "4.4/5", "30 November 2023", "Horror", "Guntur Soeharjanto", "Rocky Soraya, Hitmaker Studios") }
        item { MovieItem("Gita Cinta dari SMA", "1h 43m", "4.6/5", "9 Februari 2023", "Drama, Romance", "Monty Tiwa", "-") }
        item { MovieItem("Berbalas Kejam", "1h 49m", "4.8/5", "16 Februari 2023", "Drama, Thriller", "Teddy Soeriaatmadja", "-") }
        item { MovieItem("Akhirat: A Love Story", "1h 42m", "4.0/5", "2 Februari 2022", "Drama, Fantasy, Romance", "Jason Iskandar", "Surya Citra Media") }
        item { MovieItem("The Garfield Movie", "1h 41m", "4.0/5", "24 Mei 2024", "Animation, Comedy, Fantasy", "Mark Dindal", "Sony Pictures ") }
        item { MovieItem("13 Bom di Jakarta", "2h 23m", "4.8/5", "28 Desember 2023", "Action, Adventure, Crime Fiction", "Angga Dwimas Sasongko", "-") }
        item { MovieItem("Asih", "1h 18m", "4.2/5", "3 Oktober 2018", "Horror, Mystery, Drama", "Awi Suryadi", "-") }
        item { MovieItem("Sri Asih", "2h 15m", "4.8/5", "17 November 2022", "Action, Adventure, Science Fiction", "Upi Avianto", "-") }
        item { MovieItem("Siksa Kubur", "1h 57m", "4.3/5", "11 April 2024", "Horror", "Joko Anwar", "-") }
    }
}

@Composable
fun MovieItem(
    title: String,
    duration: String,
    rating: String,
    releaseDate: String,
    genre: String,
    director: String,
    production: String
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1F3F)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = "Duration: $duration   Rating: $rating", color = Color.White, fontSize = 12.sp)
            Text(text = "Release Date: $releaseDate", color = Color.White, fontSize = 12.sp)
            Text(text = "Genre: $genre", color = Color.White, fontSize = 12.sp)
            Text(text = "Director: $director", color = Color.White, fontSize = 12.sp)
            Text(text = "Production: $production", color = Color.White, fontSize = 12.sp)
        }
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .background(Color(0xFF1E1F3F))
    ) {
        BottomNavItem(R.drawable.home, "Home", Modifier.size(30.dp))
        BottomNavItem(R.drawable.movies, "Movies", Modifier.size(30.dp))
        BottomNavItem(R.drawable.profile, "Profile", Modifier.size(30.dp))
    }
}

@Composable
fun BottomNavItem(iconRes: Int, contentDescription: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(4.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            tint = Color.White,
            modifier = modifier
        )
        Text(
            text = contentDescription,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    TugasFrontEndTheme {
        HomeScreen()
    }
}
