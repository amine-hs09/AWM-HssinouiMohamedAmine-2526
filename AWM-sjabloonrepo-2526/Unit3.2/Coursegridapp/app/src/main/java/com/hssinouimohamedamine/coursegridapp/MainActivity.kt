package com.hssinouimohamedamine.coursegridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hssinouimohamedamine.coursegridapp.data.DataSource
import com.hssinouimohamedamine.coursegridapp.ui.theme.CourseGridAppTheme
import com.hssinouimohamedamine.coursegridapp.data.Topic


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseGridAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TopicGrid()
                }
            }
        }
    }
}
//oke
@Composable
fun TopicGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {
        items(DataSource.topics.size) { index ->
            TopicCard(topic = DataSource.topics[index])
        }
    }
}

@Composable
fun TopicCard(topic: Topic) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = topic.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(68.dp)
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = stringResource(id = topic.name), style = MaterialTheme.typography.bodyMedium)
                Text(text = "${topic.availableCourses}", style = MaterialTheme.typography.labelMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicCardPreview1() {
    CourseGridAppTheme {
        TopicCard(topic = DataSource.topics[0])
    }
}

@Preview(showBackground = true)
@Composable
fun TopicCardPreview2() {
    CourseGridAppTheme {
        TopicCard(topic = DataSource.topics[1])
    }
}

@Preview(showBackground = true)
@Composable
fun TopicGridPreview() {
    CourseGridAppTheme {
        TopicGrid()
    }
}