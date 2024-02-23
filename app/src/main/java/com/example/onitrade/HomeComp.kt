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
import com.example.onitrade.ui.theme.iconColor
import com.example.onitrade.ui.theme.mainFontColorStatic
import com.example.onitrade.ui.theme.mainRedColor
import com.example.onitrade.ui.theme.mainfontDark
import com.example.onitrade.ui.theme.selectedUpBTNLight
import com.example.onitrade.ui.theme.unSelectedDownBTNLight
import kotlin.math.roundToInt

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
                .background(Color.Red)
                .horizontalScroll(scrollState)
        ) {
            var fontColor = MaterialTheme.colorScheme.tertiary
            val bgcColor = MaterialTheme.colorScheme.primaryContainer

            //in box har kodomesh ye item bayd bashe

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

            Box {
                Box(
                    modifier = Modifier
                        .size(if (turn == 1) 30.dp else 7.dp, 7.dp)
                        .clip(RoundedCornerShape(100))
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .size(if (turn == 2) 30.dp else 7.dp, 7.dp)
                    .clip(RoundedCornerShape(100))
                    .background(MaterialTheme.colorScheme.primaryContainer)
            )

            Spacer(modifier = Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .size(if (turn == 3) 30.dp else 7.dp, 7.dp)
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


        //sec 3

        //sec 4

        //sec n
        //end body
    }

}

@Composable
fun DrawCubic() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        val density = LocalDensity.current.density

        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp

        val screenWidthInPx = screenWidth.value * density

        // (x0, y0) is initial coordinate where path is moved with path.moveTo(x0,y0)
        var x0 by remember { mutableStateOf(0f) }
        var y0 by remember { mutableStateOf(0f) }

        /*
        Adds a cubic bezier segment that curves from the current point(x0,y0) to the
        given point (x3, y3), using the control points (x1, y1) and (x2, y2).
     */
        var x1 by remember { mutableStateOf(0f) }
        var y1 by remember { mutableStateOf(screenWidthInPx) }
        var x2 by remember { mutableStateOf(screenWidthInPx / 2) }
        var y2 by remember { mutableStateOf(0f) }

        var x3 by remember { mutableStateOf(screenWidthInPx) }
        var y3 by remember { mutableStateOf(screenWidthInPx / 2) }

        val path = remember { Path() }
        Canvas(
            modifier = Modifier
                .padding(8.dp)
                .shadow(1.dp)
                .background(Color.White)
                .size(screenWidth, screenWidth / 2)
        ) {
            path.reset()
            path.moveTo(x0, y0)
            path.cubicTo(x1 = x1, y1 = y1, x2 = x2, y2 = y2, x3 = x3, y3 = y3)


            drawPath(
                color = Color.Green,
                path = path,
                style = Stroke(
                    width = 3.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                )
            )

            // Draw Control Points on screen
            drawPoints(
                listOf(Offset(x1, y1), Offset(x2, y2)),
                color = Color.Green,
                pointMode = PointMode.Points,
                cap = StrokeCap.Round,
                strokeWidth = 40f
            )
        }

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {

            Text(text = "X0: ${x0.roundToInt()}")
            Slider(
                value = x0,
                onValueChange = { x0 = it },
                valueRange = 0f..screenWidthInPx,
            )

            Text(text = "Y0: ${y0.roundToInt()}")
            Slider(
                value = y0,
                onValueChange = { y0 = it },
                valueRange = 0f..screenWidthInPx,
            )

            Text(text = "X1: ${x1.roundToInt()}")
            Slider(
                value = x1,
                onValueChange = { x1 = it },
                valueRange = 0f..screenWidthInPx,
            )

            Text(text = "Y1: ${y1.roundToInt()}")
            Slider(
                value = y1,
                onValueChange = { y1 = it },
                valueRange = 0f..screenWidthInPx,
            )

            Text(text = "X2: ${x2.roundToInt()}")
            Slider(
                value = x2,
                onValueChange = { x2 = it },
                valueRange = 0f..screenWidthInPx,
            )

            Text(text = "Y2: ${y2.roundToInt()}")
            Slider(
                value = y2,
                onValueChange = { y2 = it },
                valueRange = 0f..screenWidthInPx,
            )

            Text(text = "X3: ${x3.roundToInt()}")
            Slider(
                value = x3,
                onValueChange = { x3 = it },
                valueRange = 0f..screenWidthInPx,
            )

            Text(text = "Y3: ${y3.roundToInt()}")
            Slider(
                value = y3,
                onValueChange = { y3 = it },
                valueRange = 0f..screenWidthInPx,
            )
        }
    }
}