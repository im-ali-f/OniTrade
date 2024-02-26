package com.example.onitrade

import android.graphics.BlurMaskFilter
import android.graphics.Typeface.NORMAL
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Shapes
import androidx.compose.material.Slider
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onitrade.ui.theme.BTCColor
import com.example.onitrade.ui.theme.ETHColor
import com.example.onitrade.ui.theme.PPCColor
import com.example.onitrade.ui.theme.iconColor
import com.example.onitrade.ui.theme.mainFontColorStatic
import com.example.onitrade.ui.theme.mainRedColor
import com.example.onitrade.ui.theme.mainSeperatorColor
import com.example.onitrade.ui.theme.mainYellowColor
import com.example.onitrade.ui.theme.mainfontDark
import com.example.onitrade.ui.theme.selectedUpBTNLight
import com.example.onitrade.ui.theme.unSelectedDownBTNLight
import kotlin.math.roundToInt

@Composable
fun HomeComp(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .verticalScroll(scrollState)
    ) {

        //start body
        fun genPath(size: Size): Path {
            val innerPath = Path()
            innerPath.cubicTo(
                x1 = 0f,
                y1 = 0f,
                x2 = size.width / 2,
                y2 = -30f,
                x3 = size.width,
                y3 = 0f
            )
            innerPath.lineTo(size.width, size.height)
            innerPath.cubicTo(
                x1 = size.width,
                y1 = size.height,
                x2 = size.width / 2,
                y2 = size.height + 30,
                x3 = 0f,
                y3 = size.height
            )
            innerPath.lineTo(0f, 0f)
            innerPath.close()

            return innerPath

        }

        var fontColor = MaterialTheme.colorScheme.tertiary
        val bgcColor = MaterialTheme.colorScheme.primaryContainer

        //1 bar mikhaym
        fun Modifier.shadow(
            color: Color = Color.Black,
            offsetX: Dp = 0.dp,
            offsetY: Dp = 0.dp,
            blurRadius: Dp = 0.5.dp,
        ) = then(
            drawWithCache {
                onDrawBehind {
                    drawIntoCanvas { canvas ->
                        val paint = Paint()
                        val frameworkPaint = paint.asFrameworkPaint()
                        if (blurRadius != 0.dp) {
                            frameworkPaint.maskFilter =
                                (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
                        }
                        frameworkPaint.color = color.toArgb()


                        fun genPath2(size: Size): Path {
                            val innerPath = Path()
                            innerPath.cubicTo(
                                x1 = 0f,
                                y1 = 0f,
                                x2 = size.width / 2,
                                y2 = -20f,
                                x3 = size.width,
                                y3 = 0f
                            )
                            innerPath.lineTo(size.width, size.height)
                            innerPath.cubicTo(
                                x1 = size.width,
                                y1 = size.height,
                                x2 = size.width / 2,
                                y2 = size.height + 30,
                                x3 = 0f,
                                y3 = size.height
                            )
                            innerPath.lineTo(0f, 0f)
                            innerPath.close()

                            return innerPath
                        }

                        val path = genPath2(size)



                        canvas.drawPath(path, paint)

                    }
                }
            }

        )
        //end shadow


        //sec 1
        var scrollState = rememberScrollState()
        Row(
            Modifier
                .fillMaxWidth()
                //.background(Color.Red)
                .horizontalScroll(scrollState)
        ) {


            //in box har kodomesh ye item bayd bashe


            Box(modifier = Modifier
                .width(355.dp)
                .height(191.dp)
                .padding(start = 5.dp, top = 10.dp, end = 5.dp, bottom = 10.dp)
                .shadow()
                .drawWithCache {
                    onDrawBehind {
                        val path = genPath(size)

                        drawPath(path, bgcColor, style = Fill)
                    }
                }
            )
            {

                //inner topsec
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    //row1
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "Total Balance",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight(700),
                            color = fontColor
                        )
                        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(20.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.eye),
                                contentDescription = null,
                                tint = iconColor
                            )
                        }
                    }
                    //row2
                    Row(Modifier.fillMaxWidth()) {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(500),
                                    color = fontColor
                                )
                            ) {
                                append("234.")
                            }

                            withStyle(
                                SpanStyle(
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(250),
                                    color = fontColor
                                )
                            ) {
                                append("45698245")
                            }

                            withStyle(
                                SpanStyle(
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(250),
                                    color = fontColor
                                )
                            ) {
                                append("  " + "BTC")
                            }
                        })
                    }

                    //row 3
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "$10,554.88",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = fontColor
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "1.445%",
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = mainRedColor
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = mainRedColor
                            )
                        }

                    }
                    //row4
                    var BTN1 by remember {
                        mutableStateOf(true)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Button(
                            onClick = { BTN1 = true },
                            modifier = Modifier.size(120.dp, 30.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (BTN1) MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ),
                            contentPadding = PaddingValues(
                                start = 5.dp,
                                top = 0.dp,
                                bottom = 0.dp,
                                end = 5.dp
                            )
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = mainfontDark
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Deposit",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = if (BTN1) mainfontDark else fontColor
                                )
                            }

                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Button(
                            onClick = { BTN1 = false },
                            modifier = Modifier.size(120.dp, 30.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (!BTN1) MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Withdraw",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = if (!BTN1) mainfontDark else fontColor
                                )
                            }

                        }

                    }


                    //rows ended


                }
                //end inner

            }

            Box(modifier = Modifier
                .width(355.dp)
                .height(191.dp)
                .padding(start = 0.dp, top = 10.dp, end = 5.dp, bottom = 10.dp)
                .shadow()
                .drawWithCache {
                    onDrawBehind {
                        val path = genPath(size)

                        drawPath(path, bgcColor, style = Fill)
                    }
                }
            )
            {

                //inner topsec
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    //row1
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "Total Balance",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight(700),
                            color = fontColor
                        )
                        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(20.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.eye),
                                contentDescription = null,
                                tint = iconColor
                            )
                        }
                    }
                    //row2
                    Row(Modifier.fillMaxWidth()) {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(500),
                                    color = fontColor
                                )
                            ) {
                                append("234.")
                            }

                            withStyle(
                                SpanStyle(
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(250),
                                    color = fontColor
                                )
                            ) {
                                append("45698245")
                            }

                            withStyle(
                                SpanStyle(
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(250),
                                    color = fontColor
                                )
                            ) {
                                append("  " + "BTC")
                            }
                        })
                    }

                    //row 3
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "$10,554.88",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = fontColor
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "1.445%",
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = mainRedColor
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = mainRedColor
                            )
                        }

                    }
                    //row4
                    var BTN1 by remember {
                        mutableStateOf(true)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Button(
                            onClick = { BTN1 = true },
                            modifier = Modifier.size(120.dp, 30.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (BTN1) MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ),
                            contentPadding = PaddingValues(
                                start = 5.dp,
                                top = 0.dp,
                                bottom = 0.dp,
                                end = 5.dp
                            )
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = mainfontDark
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Deposit",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = if (BTN1) mainfontDark else fontColor
                                )
                            }

                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Button(
                            onClick = { BTN1 = false },
                            modifier = Modifier.size(120.dp, 30.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (!BTN1) MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Withdraw",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = if (!BTN1) mainfontDark else fontColor
                                )
                            }

                        }

                    }


                    //rows ended


                }
                //end inner

            }

            Box(modifier = Modifier
                .width(355.dp)
                .height(191.dp)
                .padding(start = 0.dp, top = 10.dp, end = 5.dp, bottom = 10.dp)
                .shadow()
                .drawWithCache {
                    onDrawBehind {
                        val path = genPath(size)

                        drawPath(path, bgcColor, style = Fill)
                    }
                }
            )
            {

                //inner topsec
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    //row1
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "Total Balance",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight(700),
                            color = fontColor
                        )
                        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(20.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.eye),
                                contentDescription = null,
                                tint = iconColor
                            )
                        }
                    }
                    //row2
                    Row(Modifier.fillMaxWidth()) {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                SpanStyle(
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(500),
                                    color = fontColor
                                )
                            ) {
                                append("234.")
                            }

                            withStyle(
                                SpanStyle(
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(250),
                                    color = fontColor
                                )
                            ) {
                                append("45698245")
                            }

                            withStyle(
                                SpanStyle(
                                    fontSize = 27.sp,
                                    fontWeight = FontWeight(250),
                                    color = fontColor
                                )
                            ) {
                                append("  " + "BTC")
                            }
                        })
                    }

                    //row 3
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "$10,554.88",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = fontColor
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "1.445%",
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = mainRedColor
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = mainRedColor
                            )
                        }

                    }
                    //row4
                    var BTN1 by remember {
                        mutableStateOf(true)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Button(
                            onClick = { BTN1 = true },
                            modifier = Modifier.size(120.dp, 30.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (BTN1) MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ),
                            contentPadding = PaddingValues(
                                start = 5.dp,
                                top = 0.dp,
                                bottom = 0.dp,
                                end = 5.dp
                            )
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null,
                                    tint = mainfontDark
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Deposit",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = if (BTN1) mainfontDark else fontColor
                                )
                            }

                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Button(
                            onClick = { BTN1 = false },
                            modifier = Modifier.size(120.dp, 30.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (!BTN1) MaterialTheme.colorScheme.onPrimaryContainer else Color.Transparent
                            ),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "Withdraw",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight(400),
                                    color = if (!BTN1) mainfontDark else fontColor
                                )
                            }

                        }

                    }


                    //rows ended


                }
                //end inner

            }


        }


        var turn by remember {
            mutableStateOf(1)
        }
        Row(
            Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            //box koli


            Box(
                modifier = Modifier
                    .size(if (turn == 1) 30.dp else 7.dp, 7.dp)
                    .shadow(3.dp, RoundedCornerShape(100))
                    .clip(RoundedCornerShape(100))
                    .background(MaterialTheme.colorScheme.primaryContainer)

            )

            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .size(if (turn == 2) 30.dp else 7.dp, 7.dp)
                    .shadow(3.dp, RoundedCornerShape(100))
                    .clip(RoundedCornerShape(100))
                    .background(MaterialTheme.colorScheme.primaryContainer)
            )

            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .size(if (turn == 3) 30.dp else 7.dp, 7.dp)
                    .shadow(3.dp, RoundedCornerShape(100))
                    .clip(RoundedCornerShape(100))
                    .background(MaterialTheme.colorScheme.primaryContainer)
            )


            if (scrollState.value > 350 && scrollState.value < 1050) {
                turn = 2
            } else if (scrollState.value >= 1050) {
                turn = 3
            } else {
                turn = 1
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


        fun genPathBTN(size: Size): Path {
            val innerPath = Path()
            innerPath.cubicTo(
                x1 = 0f,
                y1 = 0f,
                x2 = size.width / 2,
                y2 = -15f,
                x3 = size.width,
                y3 = 0f
            )
            innerPath.cubicTo(
                x1 = size.width,
                y1 = 0f,

                x2 = size.width + 15,
                y2 = size.height / 2,

                x3 = size.width,
                y3 = size.height
            )
            innerPath.cubicTo(
                x1 = size.width,
                y1 = size.height,
                x2 = size.width / 2,
                y2 = size.height + 15,
                x3 = 0f,
                y3 = size.height
            )
            innerPath.cubicTo(
                x1 = 0f,
                y1 = size.height,

                x2 = 0f - 15,
                y2 = size.height / 2,

                x3 = 0f,
                y3 = 0f
            )
            innerPath.close()

            return innerPath

        }
        var BTNColor= MaterialTheme.colorScheme.secondary
        Box(modifier = Modifier
            .width(355.dp)
            .height(310.dp)
            .padding(start = 5.dp, top = 10.dp, end = 5.dp, bottom = 10.dp)
            .shadow()
            .drawWithCache {
                onDrawBehind {
                    val path = genPath(size)

                    drawPath(path, bgcColor, style = Fill)
                }
            }
            .align(Alignment.CenterHorizontally)
        )
        {

            //inner topsec


            Column(Modifier.fillMaxWidth()) {

                //sec 2.1
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 15.dp, end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(Modifier.padding()) {
                        Text(
                            text = "In Order: ",
                            fontWeight = FontWeight(300),
                            fontSize = 14.sp,
                            color = fontColor
                        )
                        Text(
                            text = " 256.45 BTC",
                            fontWeight = FontWeight(700),
                            fontSize = 14.sp,
                            color = fontColor
                        )

                    }
                    LinearProgressIndicator(
                        progress = 0.45f, modifier = Modifier
                            .size(100.dp, 6.dp)
                            .clip(
                                RoundedCornerShape(100)
                            ), backgroundColor = Color(0xFF979797),
                        color = mainYellowColor
                    )

                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 15.dp, end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Daily Limit: ",
                            fontWeight = FontWeight(300),
                            fontSize = 14.sp,
                            color = fontColor
                        )
                        Text(
                            text = " $75,000",
                            fontWeight = FontWeight(700),
                            fontSize = 14.sp,
                            color = fontColor
                        )

                        Spacer(modifier = Modifier.width(10.dp))
                        IconButton(onClick = { /*TODO*/ }, modifier = Modifier

                            .drawWithCache {
                                onDrawBehind {
                                    val path = genPathBTN(size)
                                    drawPath(path, BTNColor, style = Fill)
                                }
                            }
                            .size(25.dp)

                        ) {
                            Icon(
                                modifier = Modifier.fillMaxSize(),
                                painter = painterResource(id = R.drawable.arrowup),
                                contentDescription = null,
                                tint = Color.White
                            )

                        }


                    }
                    LinearProgressIndicator(
                        progress = 0.8f, modifier = Modifier
                            .size(100.dp, 6.dp)
                            .clip(
                                RoundedCornerShape(100)
                            ), backgroundColor = Color(0xFF979797),
                        color = mainRedColor
                    )

                }


                //sec 2.2
                Spacer(modifier = Modifier.height(15.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(0.7.dp)
                    .background(mainSeperatorColor))
                //sec 2.3
                Spacer(modifier = Modifier.height(15.dp))
                Row (
                    Modifier
                        .fillMaxWidth(0.6f)
                        .padding(start = 15.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){

                    var selected by remember {
                        mutableStateOf(1)
                    }
                    //btc
                    IconButton(onClick = { selected = 1 }, modifier = Modifier

                        .drawWithCache {
                            onDrawBehind {
                                val path = genPathBTN(size)
                                drawPath(
                                    path,
                                    if (selected == 1) BTCColor else BTNColor,
                                    style = Fill
                                )
                            }
                        }
                        .size(30.dp)

                    ) {
                        Icon(
                            modifier = Modifier.fillMaxSize(0.8f),
                            painter = painterResource(id = R.drawable.btc),
                            contentDescription = null,
                            tint = Color.White
                        )

                    }

                    //leaf
                    IconButton(onClick = { selected = 2 }, modifier = Modifier

                        .drawWithCache {
                            onDrawBehind {
                                val path = genPathBTN(size)
                                drawPath(
                                    path,
                                    if (selected == 2) PPCColor else BTNColor,
                                    style = Fill
                                )
                            }
                        }
                        .size(30.dp)

                    ) {
                        Icon(
                            modifier = Modifier.fillMaxSize(0.8f),
                            painter = painterResource(id = R.drawable.leaf),
                            contentDescription = null,
                            tint = Color.Green
                        )

                    }

                    //eter
                    IconButton(onClick = { selected = 3 }, modifier = Modifier

                        .drawWithCache {
                            onDrawBehind {
                                val path = genPathBTN(size)
                                drawPath(
                                    path,
                                    if (selected == 3) ETHColor else BTNColor,
                                    style = Fill
                                )
                            }
                        }
                        .size(30.dp)

                    ) {
                        Icon(
                            modifier = Modifier.fillMaxSize(0.8f),
                            painter = painterResource(id = R.drawable.eter),
                            contentDescription = null,
                            tint = Color.Blue
                        )

                    }


                    IconButton(onClick = { selected = 3 }, modifier = Modifier

                        .drawWithCache {
                            onDrawBehind {
                                val path = genPathBTN(size)
                                val stroke = Stroke(width = 3f,
                                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                                )

                                drawPath(
                                    path,
                                    BTNColor,
                                    style = Fill
                                )
                                drawPath(
                                    path,
                                    Color.White,
                                    style = stroke
                                )
                            }
                        }
                        .size(30.dp)

                    ) {
                        Icon(
                            modifier = Modifier.fillMaxSize(0.8f),
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.White
                        )

                    }


                }

                //sec2.4


                //sec 2.x



            }


            //end inner

        }

        //sec 3

        //sec 4

        //sec n
        //end body
    }

}
