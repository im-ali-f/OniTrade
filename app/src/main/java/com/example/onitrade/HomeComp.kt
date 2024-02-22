package com.example.onitrade

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeComp(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {

        //start body

        //sec 1
        var scrollState = rememberScrollState()
        Row (
            Modifier
                .fillMaxWidth()

                .horizontalScroll(scrollState)){
            var drawColor = MaterialTheme.colorScheme.primaryContainer
Spacer(modifier = Modifier.width(10.dp))
            Box(modifier = Modifier
                .width(339.dp)){
                Canvas(modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(0.03f), onDraw = {
                    scale(33f,1.5f){
                        drawCircle(drawColor,center = Offset(20f,23f))
                    }
                })

                Box(modifier = Modifier
                    .width(339.dp)
                    .height(171.dp)
                    .padding(top = 14.dp, bottom = 14.dp)
                    .clip(
                        RoundedCornerShape(7.dp)
                    )
                    .background(drawColor))

                Canvas(modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(0.03f), onDraw = {
                    scale(33f,1.5f){
                        drawCircle(drawColor,center = Offset(20f,212.5f))
                    }
                })

            }


        }

        //sec 2

        //sec 3

        //sec 4

        //sec n
        //end body
    }
}