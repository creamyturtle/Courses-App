package com.example.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.data.Datasource
import com.example.courses.model.Course
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoursesApp(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CoursesApp(name: String, modifier: Modifier = Modifier) {
    CoursesList(
        courseList = Datasource().courses,
    )
}



@Composable
fun CoursesList(courseList: List<Course>, modifier: Modifier = Modifier) {
    LazyVerticalGrid (

        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),

        columns = GridCells.Fixed(2),

        // content padding
        contentPadding = PaddingValues(
            start = 0.dp,
            top = 0.dp,
            end = 0.dp,
            bottom = 0.dp
        ),

        content = {


            items(courseList) { course ->
                CourseCard(
                    course = course,
                    modifier = Modifier.padding(4.dp)
                )
            }


        }

    )


    }

@Composable
fun CourseCard(
    course: Course, modifier: Modifier = Modifier

) {




    Card(modifier = modifier.width(200.dp).height(68.dp)) {
        Row {
            Image(
                painter = painterResource(course.imageResourceId),
                contentDescription = stringResource(course.stringResourceId),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )



            Column(modifier = Modifier
                .padding(top = 12.dp, start = 12.dp)) {

                Text(
                    text = LocalContext.current.getString(course.stringResourceId),
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )



                Row() {

                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = "Cool Symbol",
                        modifier = Modifier.padding(4.dp),
                        colorFilter = ColorFilter.tint(Color.Black)


                    )

                    Text(
                        text = course.numCourses.toString(),
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.labelMedium
                    )





                }





            }



        }
    }



}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoursesApp(
        name = "Android",
        modifier = Modifier
    )
}