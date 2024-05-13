package com.example.dramalist.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.dramalist.model.Drama

@Composable
fun DramaCard(
    modifier: Modifier = Modifier,
    drama: Drama
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(3.dp)),
            painter = painterResource(drama.image),
            contentDescription = "model"
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(
                text = drama.title,
                color = Color.White
            )
            Row(modifier = Modifier.padding(top = 4.dp)) {
                Icon(
                    tint = Color("#FFC100".toColorInt()),
                    imageVector = Icons.Default.Star,
                    contentDescription = "Rating"
                )
                Text(
                    text = drama.rating,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//private fun DramaCardPreview() {
//    DramaListTheme {
//        DramaCard(drama = Drama)
//    }
//}