package com.example.myrecipe

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrecipe.network.RecipeRetrofitService
import com.example.myrecipe.ui.theme.MyRecipeTheme
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofitService = Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeRetrofitService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val recipe = retrofitService.get(
                token = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48",
                id = 583
            )

            Log.d("MainActivity", "onCreate: ${recipe.title}")
        }





//        val mapper = RecipeNetworkMapper()
//        val recipe = Recipe()
//        val networkEntity = mapper.mapToEntity(recipe)
//
//        val r = mapper.mapFromEntity(networkEntity)


//        setContent {
//            MyRecipeTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//
//
//
//                }
//            }
//        }
    }
}

@Composable
fun Hello(){

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(color = Color(0xFFF2F2F2))
    ) {


        Image(painter = painterResource(id = R.drawable.happy_meal_small),
            contentDescription = "happyMeal",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.padding(16.dp)
        ){

            Row(modifier = Modifier.fillMaxWidth(0.95f),
                horizontalArrangement = Arrangement.SpaceBetween) {

                Text(
                    text = "Happy Meal",
                    style = TextStyle(
                        fontSize = 26.sp
                    )
                )

                Text(
                    text = "$5.99",
                    style = TextStyle(
                        color = Color(0xFF85bb65),
                        fontSize = 17.sp
                    ),
                    modifier = Modifier.align(CenterVertically)
                )

            }

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Text(
                text = "800 Calories",
                style = TextStyle(
                    fontSize = 17.sp
                )
            )
            
            Spacer(modifier = Modifier.padding(top = 10.dp))
            
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(CenterHorizontally)) {

                Text(text = "ORDER NOW")

            }

        }


    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyRecipeTheme {
        Hello()
    }
}