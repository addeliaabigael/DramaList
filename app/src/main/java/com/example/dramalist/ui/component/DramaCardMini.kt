package com.example.dramalist.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.dramalist.model.Drama

@Composable
fun DramaCardMini(
    modifier: Modifier = Modifier,
    drama: Drama
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .width(140.dp)
    ) {
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(drama.image),
            contentDescription = "model",
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .height(180.dp)
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            overflow = TextOverflow.Ellipsis,
            text = drama.title,
            maxLines = 2,
            color = Color.White
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun DramaCardMiniPreview() {
//    DramaListTheme {
//        DramaCardMini()
//    }
//}