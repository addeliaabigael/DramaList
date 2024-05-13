package com.example.dramalist.ui.screen.drama

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
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
import com.example.dramalist.model.dummyDrama
import com.example.dramalist.ui.component.DramaCardMini
import com.example.dramalist.ui.theme.DramaListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DramaScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {
                    Text(
                        text = "Drama",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(it)
        ) {
            itemsIndexed(dummyDrama){ index, drama ->
                DramaCardMini(
                    drama = drama,
                    modifier = Modifier
                        .clickable {
                            navigateToDetail(index)
                        }
                )
            }
        }
    }
}

@Preview
@Composable
private fun DramaScreenPreview() {
    DramaListTheme {
        DramaScreen{}
    }
}