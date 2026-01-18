package com.example.mycoffeeapp.presentation.Screens.cartScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mycoffeeapp.domain.modal.Product
import com.example.mycoffeeapp.presentation.theme.LightBrown
import com.example.mycoffeeapp.presentation.theme.LightGray


@Composable
fun CartItemCard(product: Product) {

    var quantity by remember { mutableStateOf(1) }

    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightGray
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(product.imageRes),
                contentDescription = "Coffee Image",
                modifier = Modifier.size(70.dp).clip(RoundedCornerShape(10.dp))
            )

            Column(
                modifier = Modifier.weight(1f).padding(start = 12.dp)
            ) {
                Text(
                    product.name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )

                )

                Text(
                    product.description,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                IconButton(
                    onClick = { quantity-- },
                    enabled = quantity > 1,
                    modifier = Modifier.background(
                        color = LightBrown.copy(alpha = 0.1f),
                        shape = CircleShape
                    )
                        .size(24.dp)

                ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Decrease",
                        tint = LightBrown
                        )
                }

                Text(text = quantity.toString(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    )
                    )

                IconButton( onClick = { quantity++ },
                    modifier = Modifier.background(
                        color = LightBrown.copy(alpha = 0.1f),
                        shape = CircleShape
                    )

                        .size(24.dp)

                    ) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "Increase",
                        tint = LightBrown
                        )
                }
            }
        }
    }
}