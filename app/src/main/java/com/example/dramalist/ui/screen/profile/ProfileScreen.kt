package com.example.dramalist.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dramalist.R
import com.example.dramalist.ui.theme.DramaListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = "Profile",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        top = 16.dp,
                        end = 16.dp
                    )
            ) {
                Row{
                    Image(
                        painter = painterResource(R.drawable.adel),
                        contentDescription = "model",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(100.dp))
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp, top = 8.dp)
                    ) {
                        Text(
                            text = "Addelia Abigael",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "addeliaabigael",
                            fontSize = 12.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.universityicon),
                        contentDescription = "University",
                        tint = MaterialTheme.colorScheme.outline,
                    )
                    Text(
                        text = "Diponegoro Univeristy - TRKP",
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 14.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = MaterialTheme.colorScheme.outline,
                    )
                    Text(
                        text = "addeliaabigael@students.undip.ac.id",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp),
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.linkedinicon),
                        contentDescription = "Linked-in",
                        tint = MaterialTheme.colorScheme.outline,
                    )
                    Text(
                        text = "Addelia Abigael",
                        modifier = Modifier.padding(start = 8.dp),
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.instagramicon),
                        contentDescription = "Instagram",
                        tint = MaterialTheme.colorScheme.outline,
                    )
                    Text(
                        text = "addeliaabigael",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(start = 8.dp),
                    )
                }
                Text(
                    text = "Description",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 32.dp)
                )
                Text(
                    text = """
                        Saya adalah mahasiswa semester 4 jurusan teknologi rekayasa konstruksi perkapalan yang saat ini berkuliah di universitas diponegoro, saya memiliki minat yang besar dalam bidang desain grafis. Disisi lain untuk mengisi waktu luang, saya suka menonton drama korea.
                    """.trimIndent(),
                    fontSize = 14.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    DramaListTheme(dynamicColor = false) {
        ProfileScreen()
    }
}