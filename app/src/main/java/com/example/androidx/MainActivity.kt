package com.example.androidx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidx.ui.theme.AndroidxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenContent()
        }
    }
}

val stringData = listOf("Hello", "World")

@Preview(showBackground = true)
@Composable
fun ScreenContent(
    listOfItems: List<String> = stringData,
) {
    Box(modifier = Modifier.padding(30.dp)) {
        Items(listOfType = listOfItems) {
            Card(
                Modifier.fillMaxWidth()
            ) {
                Text(text = it)
            }
        }
    }
}

@Composable
fun <T> Items(
    listOfType: List<T>,
    content: @Composable (item: T) -> Unit
) {
    LazyColumn {
        items(items = listOfType) { item ->
            content(item)
            Divider(modifier = Modifier.height(5.dp))
        }
    }
}

@Composable
fun Screen(
    padding: PaddingValues,
    content: @Composable () -> Unit
) {
    MainContent(
        padding = padding,
        content = content
    )
}

@Composable
private fun MainContent(
    padding: PaddingValues,
    content: @Composable () -> Unit
) {
    AndroidxTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            color = MaterialTheme.colorScheme.background
        ) {
            Column { content() }
        }
    }
}

