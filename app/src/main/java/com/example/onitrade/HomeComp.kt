package com.example.onitrade

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onitrade.ui.theme.BTCColor
import com.example.onitrade.ui.theme.iconColor
import com.example.onitrade.ui.theme.mainFontColorStatic
import com.example.onitrade.ui.theme.mainRedColor
import com.example.onitrade.ui.theme.mainfontDark
import com.example.onitrade.ui.theme.selectedUpBTNLight
import com.example.onitrade.ui.theme.unSelectedDownBTNLight

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
        Row(
            Modifier
                .fillMaxWidth()

                .horizontalScroll(scrollState)
        ) {
            var fontColor= MaterialTheme.colorScheme.tertiary
            var drawColor = MaterialTheme.colorScheme.primaryContainer
            Spacer(modifier = Modifier.width(10.dp))
            //in box har kodomesh ye item bayd bashe
            Box(
                modifier = Modifier
                    .width(339.dp)
            ) {
                Canvas(modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(0.03f), onDraw = {
                    scale(33f, 1.5f) {
                        drawCircle(drawColor, center = Offset(20f, 23f))
                    }
                })

                Box(
                    modifier = Modifier
                        .width(339.dp)
                        .height(171.dp)
                        .padding(top = 14.dp, bottom = 14.dp)
                        .clip(
                            RoundedCornerShape(7.dp)
                        )
                        .background(drawColor)
                ) {
                    //inner topsec
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)) {
                        //row1
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = "Total Balance", fontSize = 11.5.sp, fontWeight = FontWeight(700), color = fontColor)
                            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(20.dp)) {
                                Icon(painter = painterResource(id = R.drawable.eye), contentDescription = null , tint = iconColor)
                            }
                        }
                        //row2
                        Row(Modifier.fillMaxWidth()) {
                            Text(text = buildAnnotatedString {
                                withStyle(SpanStyle(fontSize = 27.sp, fontWeight = FontWeight(500), color = fontColor)){
                                    append("234.")
                                }

                                withStyle(SpanStyle(fontSize = 27.sp, fontWeight = FontWeight(250), color = fontColor)){
                                    append("45698245")
                                }

                                withStyle(SpanStyle(fontSize = 27.sp, fontWeight = FontWeight(250), color = fontColor)){
                                    append("  "+"BTC")
                                }
                            })
                        }

                        //row 3
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "$10,554.88",fontSize = 14.sp, fontWeight = FontWeight(400), color = fontColor)
                            Spacer(modifier = Modifier.width(20.dp))
                            Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                                Text(text = "1.445%",fontSize = 14.sp, fontWeight = FontWeight(400), color = mainRedColor)
                                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = mainRedColor)
                            }

                        }
                        //row4
                        var BTN1 by remember {
                            mutableStateOf(true)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Button(onClick = { BTN1 = true }, modifier = Modifier.size(120.dp,30.dp), colors = ButtonDefaults.buttonColors(
                                containerColor = if(BTN1)MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ), contentPadding = PaddingValues(start = 5.dp, top = 0.dp, bottom = 0.dp, end = 5.dp)) {
                                Row( Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Default.Add, contentDescription = null , tint = mainfontDark)
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(text = "Deposit",fontSize = 15.sp, fontWeight = FontWeight(400), color = mainfontDark)
                                }

                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Button(onClick = { BTN1 = false }, modifier = Modifier.size(120.dp,30.dp), colors = ButtonDefaults.buttonColors(
                                containerColor = if(!BTN1)MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ), contentPadding = PaddingValues(0.dp)
                            ) {
                                Row( Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                    Text(text = "Withdraw",fontSize = 15.sp, fontWeight = FontWeight(400), color = mainfontDark)
                                }

                            }

                        }
                        
                        
                        //rows ended



                    }
                    //end inner
                }

                Canvas(modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(0.03f), onDraw = {
                    scale(33f, 1.5f) {
                        drawCircle(drawColor, center = Offset(20f, 212.5f))
                    }
                })

            }

            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .width(339.dp)
            ) {
                Canvas(modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(0.03f), onDraw = {
                    scale(33f, 1.5f) {
                        drawCircle(drawColor, center = Offset(20f, 23f))
                    }
                })

                Box(
                    modifier = Modifier
                        .width(339.dp)
                        .height(171.dp)
                        .padding(top = 14.dp, bottom = 14.dp)
                        .clip(
                            RoundedCornerShape(7.dp)
                        )
                        .background(drawColor)
                ) {
                    //inner topsec
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)) {
                        //row1
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = "Total Balance", fontSize = 11.5.sp, fontWeight = FontWeight(700), color = fontColor)
                            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(20.dp)) {
                                Icon(painter = painterResource(id = R.drawable.eye), contentDescription = null , tint = iconColor)
                            }
                        }
                        //row2
                        Row(Modifier.fillMaxWidth()) {
                            Text(text = buildAnnotatedString {
                                withStyle(SpanStyle(fontSize = 27.sp, fontWeight = FontWeight(500), color = fontColor)){
                                    append("234.")
                                }

                                withStyle(SpanStyle(fontSize = 27.sp, fontWeight = FontWeight(250), color = fontColor)){
                                    append("45698245")
                                }

                                withStyle(SpanStyle(fontSize = 27.sp, fontWeight = FontWeight(250), color = fontColor)){
                                    append("  "+"BTC")
                                }
                            })
                        }

                        //row 3
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "$10,554.88",fontSize = 14.sp, fontWeight = FontWeight(400), color = fontColor)
                            Spacer(modifier = Modifier.width(20.dp))
                            Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                                Text(text = "1.445%",fontSize = 14.sp, fontWeight = FontWeight(400), color = mainRedColor)
                                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = mainRedColor)
                            }

                        }
                        //row4
                        var BTN1 by remember {
                            mutableStateOf(true)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Button(onClick = { BTN1 = true }, modifier = Modifier.size(120.dp,30.dp), colors = ButtonDefaults.buttonColors(
                                containerColor = if(BTN1)MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ), contentPadding = PaddingValues(start = 5.dp, top = 0.dp, bottom = 0.dp, end = 5.dp)) {
                                Row( Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Default.Add, contentDescription = null , tint = mainfontDark)
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(text = "Deposit",fontSize = 15.sp, fontWeight = FontWeight(400), color = mainfontDark)
                                }

                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Button(onClick = { BTN1 = false }, modifier = Modifier.size(120.dp,30.dp), colors = ButtonDefaults.buttonColors(
                                containerColor = if(!BTN1)MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ), contentPadding = PaddingValues(0.dp)
                            ) {
                                Row( Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                    Text(text = "Withdraw",fontSize = 15.sp, fontWeight = FontWeight(400), color = mainfontDark)
                                }

                            }

                        }


                        //rows ended



                    }
                    //end inner
                }

                Canvas(modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(0.03f), onDraw = {
                    scale(33f, 1.5f) {
                        drawCircle(drawColor, center = Offset(20f, 212.5f))
                    }
                })

            }

            Spacer(modifier = Modifier.width(10.dp))

            Box(
                modifier = Modifier
                    .width(339.dp)
            ) {
                Canvas(modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(0.03f), onDraw = {
                    scale(33f, 1.5f) {
                        drawCircle(drawColor, center = Offset(20f, 23f))
                    }
                })

                Box(
                    modifier = Modifier
                        .width(339.dp)
                        .height(171.dp)
                        .padding(top = 14.dp, bottom = 14.dp)
                        .clip(
                            RoundedCornerShape(7.dp)
                        )
                        .background(drawColor)
                ) {
                    //inner topsec
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)) {
                        //row1
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(text = "Total Balance", fontSize = 11.5.sp, fontWeight = FontWeight(700), color = fontColor)
                            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(20.dp)) {
                                Icon(painter = painterResource(id = R.drawable.eye), contentDescription = null , tint = iconColor)
                            }
                        }
                        //row2
                        Row(Modifier.fillMaxWidth()) {
                            Text(text = buildAnnotatedString {
                                withStyle(SpanStyle(fontSize = 27.sp, fontWeight = FontWeight(500), color = fontColor)){
                                    append("234.")
                                }

                                withStyle(SpanStyle(fontSize = 27.sp, fontWeight = FontWeight(250), color = fontColor)){
                                    append("45698245")
                                }

                                withStyle(SpanStyle(fontSize = 27.sp, fontWeight = FontWeight(250), color = fontColor)){
                                    append("  "+"BTC")
                                }
                            })
                        }

                        //row 3
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "$10,554.88",fontSize = 14.sp, fontWeight = FontWeight(400), color = fontColor)
                            Spacer(modifier = Modifier.width(20.dp))
                            Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                                Text(text = "1.445%",fontSize = 14.sp, fontWeight = FontWeight(400), color = mainRedColor)
                                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = mainRedColor)
                            }

                        }
                        //row4
                        var BTN1 by remember {
                            mutableStateOf(true)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Button(onClick = { BTN1 = true }, modifier = Modifier.size(120.dp,30.dp), colors = ButtonDefaults.buttonColors(
                                containerColor = if(BTN1)MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ), contentPadding = PaddingValues(start = 5.dp, top = 0.dp, bottom = 0.dp, end = 5.dp)) {
                                Row( Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Default.Add, contentDescription = null , tint = mainfontDark)
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(text = "Deposit",fontSize = 15.sp, fontWeight = FontWeight(400), color = mainfontDark)
                                }

                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Button(onClick = { BTN1 = false }, modifier = Modifier.size(120.dp,30.dp), colors = ButtonDefaults.buttonColors(
                                containerColor = if(!BTN1)MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ), contentPadding = PaddingValues(0.dp)
                            ) {
                                Row( Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                                    Text(text = "Withdraw",fontSize = 15.sp, fontWeight = FontWeight(400), color = mainfontDark)
                                }

                            }

                        }


                        //rows ended



                    }
                    //end inner
                }

                Canvas(modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth(0.03f), onDraw = {
                    scale(33f, 1.5f) {
                        drawCircle(drawColor, center = Offset(20f, 212.5f))
                    }
                })

            }



        }


        var turn by remember {
            mutableStateOf(1)
        }
        Row (
            Modifier
                .fillMaxWidth()
                , verticalAlignment = Alignment.CenterVertically
        , horizontalArrangement = Arrangement.Center){
            //box koli

            Box{
                Box(modifier = Modifier
                    .size(if(turn == 1)30.dp else 7.dp, 7.dp)
                    .clip(RoundedCornerShape(100))
                    .background(MaterialTheme.colorScheme.primaryContainer))
            }
            Spacer(modifier = Modifier.width(5.dp))
            Box(modifier = Modifier
                .size(if(turn == 2)30.dp else 7.dp, 7.dp)
                .clip(RoundedCornerShape(100))
                .background(MaterialTheme.colorScheme.primaryContainer) )

            Spacer(modifier = Modifier.width(5.dp))
            Box(modifier = Modifier
                .size(if(turn == 3)30.dp else 7.dp, 7.dp)
                .clip(RoundedCornerShape(100))
                .background(MaterialTheme.colorScheme.primaryContainer) )


            if(scrollState.value>350 && scrollState.value<1050 ){
                turn =2
            }
            else if(scrollState.value>=1050){
                turn =3
            }
            else{
                turn =1
            }
        }

        /*
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            Modifier
                .fillMaxWidth()
                .background(Color.Gray)){
            Text(text = "scroll = ${scrollState.value}")


        }
        */

        //sec 2

        //sec 3

        //sec 4

        //sec n
        //end body
    }

}