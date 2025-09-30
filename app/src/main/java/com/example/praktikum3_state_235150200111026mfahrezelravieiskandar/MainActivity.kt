package com.example.praktikum3_state_235150200111026mfahrezelravieiskandar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum3_state_235150200111026mfahrezelravieiskandar.ui.theme.Praktikum3_State_235150200111026MFahrezelRavieIskandarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterApp()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Praktikum3_State_235150200111026MFahrezelRavieIskandarTheme {
        Greeting("Android")
    }
}

@Composable
fun CounterApp(){
    var count by remember{mutableStateOf(0)}
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text("Jumlah klik: $count")
        Spacer(modifier = Modifier.height(16.dp))
        Row {
        Button(onClick = { count++ }) { Text("tambah") }
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = { count-- }, enabled = count > 0 ) { Text("kurang") }

        }
        Spacer(modifier = Modifier.height(16.dp))
        ToggleWarna()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileCard()
    }
}

@Composable
fun ToggleWarna(){
    var isRed by remember { mutableStateOf(false) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center
    ){
        Box(modifier = Modifier.size(200.dp).clip(CircleShape).background(if (isRed) androidx.compose.ui.graphics.Color.Red else androidx.compose.ui.graphics.Color.Blue))
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { isRed = !isRed }) {
            Text("Toggle Warna")
        }
    }}

@Composable
fun FollowButton(
    isFollowed: Boolean = false,
    OnClick: () -> Unit
){
   Button(onClick = OnClick) {
         if (isFollowed){
              Text("Unfollow")
         } else {
              Text("Follow")
         }
   }
}

@Composable
fun FollowApp(){
    var isFollowed by remember { mutableStateOf(false) }
    FollowButton(isFollowed = isFollowed, OnClick = { isFollowed = !isFollowed })
}

@Composable
fun ProfileCard(){
    var isFollowed by remember { mutableStateOf(false) }

    Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(16.dp)

        ,verticalArrangement = Arrangement.Center){
        Image(painter=painterResource(id=R.drawable.profile_picture), contentDescription="Foto Profil",
            modifier = Modifier.size(120.dp).clip(CircleShape))
    Spacer(modifier = Modifier.height(16.dp))
    Text("Nama: M. Fahrezel Ravie Iskandar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(4.dp))
    Text("Mahasiswa Teknik Informatika")
    Spacer(modifier = Modifier.height(12.dp))
    Button(onClick = { isFollowed = !isFollowed }) {
    Text(if (isFollowed) "Unfollow" else "Follow") }
    Spacer(modifier = Modifier.height(8.dp))
    Text(if (isFollowed) "Anda mengikuti akun ini" else "Anda belum mengikuti akun ini")
        }
    }
