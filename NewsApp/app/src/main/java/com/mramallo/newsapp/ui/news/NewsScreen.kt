package com.mramallo.newsapp.ui.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.mramallo.newsapp.R
import com.mramallo.newsapp.domain.entity.News
import com.mramallo.newsapp.ui.theme.NewsAppTheme


@Composable
fun NewsScreen(
    navController: NavController,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val newList by viewModel.getAllNews().observeAsState(initial = emptyList())
    NewScreen(navController = navController, news = newList)

}


@Composable
fun NewScreen(
    navController: NavController,
    news: List<News>
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top news") }
            )
        },
        backgroundColor = Color.LightGray
    ) {
        LazyColumn() {
            items(news) { new ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                        .clickable {
                            // TODO - Navigation to Details
                        }
                ) {
                    Column {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(16f / 9f),
                            painter = rememberImagePainter(
                                data = new.urlToImage,
                                builder = {
                                    placeholder(R.drawable.placeholder)
                                    error(R.drawable.placeholder)
                                }
                            ),
                            contentScale = ContentScale.FillWidth,
                            contentDescription = null
                        )

                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = new.title,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = new.content ?: "",
                                fontSize = 14.sp,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )

                        }
                    }


                }
            }
        }


    }


}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview(
) {
    NewsAppTheme {
        NewScreen(
            navController = rememberNavController(),
            news = arrayListOf(
                News(
                    title = "Title",
                    content = "Content description",
                    description = "Description",
                    author = "",
                    url = "",
                    urlToImage = "https://sportshub.cbsistatic.com/i/r/2022/07/22/328009e3-83eb-4224-a9c0-8b48d4da7bd3/thumbnail/1200x675/031a28c6591f51596bd309e8d675b09e/soto-reacts-getty.png"
                ),
                News(
                    title = "Title",
                    content = "Content description",
                    description = "",
                    author = "",
                    url = "",
                    urlToImage = "https://sportshub.cbsistatic.com/i/r/2022/07/22/328009e3-83eb-4224-a9c0-8b48d4da7bd3/thumbnail/1200x675/031a28c6591f51596bd309e8d675b09e/soto-reacts-getty.png"
                ),

                )
        )
    }

}