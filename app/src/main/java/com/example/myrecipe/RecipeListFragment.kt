package com.example.myrecipe

 import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import android.widget.Space
 import androidx.compose.foundation.border
 import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.Spacer
 import androidx.compose.foundation.layout.padding
 import androidx.compose.material.Button
 import androidx.compose.material.CircularProgressIndicator
 import androidx.compose.material.Text
 import androidx.compose.ui.Modifier
 import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
 import androidx.compose.ui.platform.LocalContext
 import androidx.compose.ui.text.TextStyle
 import androidx.compose.ui.unit.dp
 import androidx.compose.ui.unit.sp
 import androidx.compose.ui.viewinterop.AndroidView
 import androidx.fragment.app.Fragment
 import androidx.navigation.findNavController

class RecipeListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply { 
            setContent { 
                
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Recipe List",
                        style = TextStyle(
                            fontSize = 21.sp
                        )
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    
                    Button(
                        onClick = {
                            findNavController().navigate(R.id.viewRecipe)
                        }
                    ) {
                        Text(text = "TO RECIPE FRAGMENT")
                    }


                }
                
                
            }
        }















//        val view = inflater.inflate(R.layout.fragment_recipe_list, container, false)
//        view.findViewById<ComposeView>(R.id.compose_view).setContent {
//
//            Column(modifier = Modifier
//                .border(width = 2.dp, color = Color.Blue)
//                .padding(16.dp)
//            ){
//                Text(text = "THIS IS A COMPOSABLE INSIDE A FRAGMENT")
//                Spacer(modifier = Modifier.padding(10.dp))
//                CircularProgressIndicator()
//                Spacer(modifier = Modifier.padding(10.dp))
//                Text(text = "NEAT")
//                Spacer(modifier = Modifier.padding(10.dp))
//
//                val customView = HorizontalDottedProgress(LocalContext.current)
//                AndroidView(factory = {customView.apply {  }})
//
//
//            }
//
//        }


//        return ComposeView(requireContext()).apply {
//            setContent {
//                Text(text = "Hey look a composable", color = Color.White)
//            }
//        }


    }








//        val view = ComposeView(requireContext())
//        view.apply {
//            setContent {
//                Text(text = "Hey look a composable!!", modifier = Modifier.background(Color.White))
//            }
//        }
//        return view






//        return inflater.inflate(R.layout.fragment_recipe_list, container, false)


}