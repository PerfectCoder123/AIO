package com.example.aio.presentation.ui.category.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.aio.presentation.ui.home.data.Category


@Composable
fun CategoryGrid(
    items: List<Category>,
    columns: Int,
    modifier: Modifier = Modifier,
    verticalSpacing: Dp,
    horizontalSpacing: Dp,
    itemContent: @Composable (Category) -> Unit
) {
    val rows = (items.size + columns - 1) / columns
    Column(modifier) {
        for (rowIndex in 0 until rows) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = if (rowIndex < rows - 1) verticalSpacing else 0.dp),
                horizontalArrangement = Arrangement.spacedBy(horizontalSpacing)
            ) {
                for (columnIndex in 0 until columns) {
                    val itemIndex = rowIndex * columns + columnIndex
                    if (itemIndex < items.size) {
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            itemContent(items[itemIndex])
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}
