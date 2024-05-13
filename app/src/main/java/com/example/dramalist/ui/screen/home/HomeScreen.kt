package com.example.dramalist.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dramalist.model.dummyDrama
import com.example.dramalist.ui.component.DramaCard
import com.example.dramalist.ui.component.DramaCardMini
import com.example.dramalist.ui.theme.DramaListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {
                    Text(
                        text = "Home",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)){
            LazyRow {
                itemsIndexed(dummyDrama){ index, item ->
                    DramaCardMini(
                        drama = item,
                        modifier = Modifier
                            .clickable {
                                navigateToDetail(index)
                            }
                    )
                }
            }
            Text(
                text = "Drama List",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn {
                itemsIndexed(dummyDrama){ index,dramaColumn ->
                    DramaCard(
                        drama = dramaColumn,
                        modifier = Modifier
                            .clickable {
                                navigateToDetail(index)
                            }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DramaListTheme(dynamicColor = false) {
        HomeScreen{}
    }
}