package com.example.onitrade

import android.graphics.BlurMaskFilter
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onitrade.ui.theme.BTCColor
import com.example.onitrade.ui.theme.ETHColor
import com.example.onitrade.ui.theme.PPCColor
import com.example.onitrade.ui.theme.XLMColor
import com.example.onitrade.ui.theme.mainFontColorStatic
import com.example.onitrade.ui.theme.mainFontColorStatic2
import com.example.onitrade.ui.theme.mainGreenColor
import com.example.onitrade.ui.theme.mainIconContainer
import com.example.onitrade.ui.theme.mainSeperatorColor
import com.example.onitrade.ui.theme.mainYellowColor

@Composable
fun TradeComp(navController: NavController) {
    var tradeInfosList = listOf(
        mapOf(
            "token" to "XLM",
            "icon" to R.drawable.rocket,
            "color" to XLMColor,
            "pricer" to "BTC",
            "pricerIcon" to R.drawable.btc,
            "pricerColor" to BTCColor,
            "totalToken" to "1009000.9000076",
            "totalPricer" to "0.00112300",
            "percentFloat" to 1f,
            "percentInt" to 100
        ),
        mapOf(
            "token" to "PPC",
            "icon" to R.drawable.leaf,
            "color" to PPCColor,
            "pricer" to "ETH",
            "pricerIcon" to R.drawable.eter,
            "pricerColor" to ETHColor,
            "totalToken" to "1009000.9000076",
            "totalPricer" to "0.00112300",
            "percentFloat" to 0.7f,
            "percentInt" to 70
        ),
        mapOf(
            "token" to "BTC",
            "icon" to R.drawable.btc,
            "color" to BTCColor,
            "pricer" to "PPC",
            "pricerIcon" to R.drawable.leaf,
            "pricerColor" to PPCColor,
            "totalToken" to "1.30026",
            "totalPricer" to "2400.4221",
            "percentFloat" to 0.5f,
            "percentInt" to 50
        ),
        mapOf(
            "token" to "XLM",
            "icon" to R.drawable.rocket,
            "color" to XLMColor,
            "pricer" to "BTC",
            "pricerIcon" to R.drawable.btc,
            "pricerColor" to BTCColor,
            "totalToken" to "1009000.9000076",
            "totalPricer" to "0.00112300",
            "percentFloat" to 1f,
            "percentInt" to 100
        ),
        mapOf(
            "token" to "PPC",
            "icon" to R.drawable.leaf,
            "color" to PPCColor,
            "pricer" to "ETH",
            "pricerIcon" to R.drawable.eter,
            "pricerColor" to ETHColor,
            "totalToken" to "1009000.9000076",
            "totalPricer" to "0.00112300",
            "percentFloat" to 0.7f,
            "percentInt" to 70
        ),
        mapOf(
            "token" to "BTC",
            "icon" to R.drawable.btc,
            "color" to BTCColor,
            "pricer" to "ETH",
            "pricerIcon" to R.drawable.eter,
            "pricerColor" to ETHColor,
            "totalToken" to "1.30026",
            "totalPricer" to "2400.4221",
            "percentFloat" to 0.5f,
            "percentInt" to 50
        ),
        mapOf(
            "token" to "XLM",
            "icon" to R.drawable.rocket,
            "color" to XLMColor,
            "pricer" to "BTC",
            "pricerIcon" to R.drawable.btc,
            "pricerColor" to BTCColor,
            "totalToken" to "1009000.9000076",
            "totalPricer" to "0.00112300",
            "percentFloat" to 1f,
            "percentInt" to 100
        ),
        mapOf(
            "token" to "PPC",
            "icon" to R.drawable.leaf,
            "color" to PPCColor,
            "pricer" to "ETH",
            "pricerIcon" to R.drawable.eter,
            "pricerColor" to ETHColor,
            "totalToken" to "1009000.9000076",
            "totalPricer" to "0.00112300",
            "percentFloat" to 0.7f,
            "percentInt" to 70
        ),
        mapOf(
            "token" to "BTC",
            "icon" to R.drawable.btc,
            "color" to BTCColor,
            "pricer" to "ETH",
            "pricerIcon" to R.drawable.eter,
            "pricerColor" to ETHColor,
            "totalToken" to "1.30026",
            "totalPricer" to "2400.4221",
            "percentFloat" to 0.5f,
            "percentInt" to 50
        ),
    )
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.95f)
            .verticalScroll(scrollState)
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //start main inner
        //mainSection

        //test
        fun Modifier.shadow(
            color: Color = Color.Black,
            offsetX: Dp = 0.dp,
            offsetY: Dp = 0.dp,
            blurRadius: Dp = 0.5.dp,
            end: Int = 0
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
                                y2 = 10f,
                                x3 = size.width,
                                y3 = 0f
                            )
                            innerPath.lineTo(size.width, size.height)
                            innerPath.cubicTo(
                                x1 = size.width,
                                y1 = size.height,
                                x2 = size.width / 2,
                                y2 = size.height + end,
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

        fun genPathSelected(size: Size): Path {
            val innerPath = Path()
            innerPath.cubicTo(
                x1 = 0f,
                y1 = 0f,
                x2 = size.width / 2,
                y2 = 0f,
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

        fun genPathUnSelected(size: Size): Path {
            val innerPath = Path()
            innerPath.cubicTo(
                x1 = 0f,
                y1 = 0f,
                x2 = size.width / 2,
                y2 = 0f,
                x3 = size.width,
                y3 = 0f
            )
            innerPath.lineTo(size.width, size.height)
            innerPath.cubicTo(
                x1 = size.width,
                y1 = size.height,
                x2 = size.width / 2,
                y2 = size.height,
                x3 = 0f,
                y3 = size.height
            )
            innerPath.lineTo(0f, 0f)
            innerPath.close()

            return innerPath

        }


        var fontColor = MaterialTheme.colorScheme.tertiary
        val bgcColor = MaterialTheme.colorScheme.primaryContainer
        tradeInfosList.forEach { token ->

            //loop from here
            Spacer(modifier = Modifier.height(15.dp))
            var isSelected by remember {
                mutableStateOf(false)
            }
            val modifSelected = Modifier
                .fillMaxWidth(if (isSelected) 1f else 0.85f)
                .shadow(end = if (isSelected) 30 else 0)
                .drawWithCache {
                    onDrawBehind {
                        val path =
                            if (isSelected) genPathSelected(size) else genPathUnSelected(size)

                        drawPath(path, bgcColor, style = Fill)
                    }
                }
                .clickable { isSelected = !isSelected }

            val modifUnSelected = Modifier
                .fillMaxWidth(if (isSelected) 1f else 0.85f)
                .clip(RoundedCornerShape(12.dp))
                .shadow(end = if (isSelected) 30 else 0)
                .background(bgcColor)
                .clickable { isSelected = !isSelected }
            Column(
                modifier = if (isSelected) modifSelected else modifUnSelected,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    Modifier
                        .width(305.dp)
                        .height(60.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    //Icons & on Icons
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(0.9f)
                            .width(55.dp), contentAlignment = Alignment.Center
                    ) {
                        val iconColor = token["color"] as Color
                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .clip(RoundedCornerShape(100))
                                .background(iconColor)
                                .border(2.dp, Color.White, RoundedCornerShape(100)),
                            contentAlignment = Alignment.Center
                        ) {
                            val icon = token["icon"] as Int

                            Icon(
                                modifier = Modifier.fillMaxSize(0.7f),
                                painter = painterResource(id = icon),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Transparent),
                            contentAlignment = Alignment.BottomEnd
                        ) {
                            val pricerColor = token["pricerColor"] as Color
                            Box(
                                modifier = Modifier
                                    .size(25.dp)
                                    .clip(RoundedCornerShape(100))
                                    .background(pricerColor)
                                    .border(2.dp, Color.White, RoundedCornerShape(100)),
                                contentAlignment = Alignment.Center
                            ) {
                                val icon = token["pricerIcon"] as Int

                                Icon(
                                    modifier = Modifier.fillMaxSize(0.55f),
                                    painter = painterResource(id = icon),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }

                        }

                    }
                    // end icon & on icon
                    //start infos
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 10.dp, end = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        //sec 1
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            val tokenName = token["token"] as String
                            val pricerName = token["pricer"] as String
                            Text(
                                text = "$tokenName/$pricerName", fontSize = 15.sp,
                                fontWeight = FontWeight(600),
                                color = fontColor
                            )
                            val progressFloat = token["percentFloat"] as Float
                            val progressInt = token["percentInt"] as Int
                            val iconColor = token["color"] as Color
                            Row(
                                Modifier.fillMaxWidth(0.8f),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                LinearProgressIndicator(
                                    progress = progressFloat,
                                    modifier = Modifier
                                        .size(90.dp, 5.dp)
                                        .clip(
                                            RoundedCornerShape(100)
                                        ),
                                    color = iconColor

                                )
                                Text(
                                    text = "$progressInt%", fontSize = 13.sp,
                                    fontWeight = FontWeight(400),
                                    color = iconColor
                                )

                            }
                        }

                        //sec 2

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val tokenName = token["token"] as String
                            val pricerName = token["pricer"] as String
                            val tokenTotal = token["totalToken"] as String
                            val pricerTotal = token["totalPricer"] as String


                            Text(
                                text = "$tokenTotal $tokenName", fontSize = 11.sp,
                                fontWeight = FontWeight(300),
                                color = fontColor
                            )
                            Text(
                                text = "$pricerTotal $pricerName", fontSize = 11.sp,
                                fontWeight = FontWeight(300),
                                color = fontColor
                            )

                            IconButton(
                                onClick = { isSelected = !isSelected },
                                modifier = Modifier
                                    .clip(RoundedCornerShape(100))
                                    .size(20.dp)
                                    .background(mainIconContainer),
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .align(Alignment.CenterVertically),
                                    imageVector = if (isSelected) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = Color.White
                                )

                            }


                        }
                        //end secs
                    }
                    //end Infos

                }

                AnimatedVisibility(
                    modifier = Modifier.fillMaxWidth(), visible = isSelected,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(mainSeperatorColor)
                    )
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 35.dp, top = 30.dp, end = 35.dp, bottom = 15.dp)
                            .background(Color.Transparent)
                    ) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Order ID :", fontSize = 15.sp,
                                fontWeight = FontWeight(600),
                                color = fontColor
                            )
                            Text(
                                text = "0001320#4e5", fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = fontColor
                            )
                        }



                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Price :", fontSize = 15.sp,
                                fontWeight = FontWeight(600),
                                color = fontColor
                            )
                            Text(
                                text = "0.002300 BTC", fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = fontColor
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Date :", fontSize = 15.sp,
                                fontWeight = FontWeight(600),
                                color = fontColor
                            )
                            Text(
                                text = "2018.01.24 at 08:04:05", fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = fontColor
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Requested :", fontSize = 15.sp,
                                fontWeight = FontWeight(600),
                                color = fontColor
                            )
                            Text(
                                text = "150", fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = fontColor
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Canceled :", fontSize = 15.sp,
                                fontWeight = FontWeight(600),
                                color = fontColor
                            )
                            Text(
                                text = "10 (10%)", fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = fontColor
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Filled :", fontSize = 15.sp,
                                fontWeight = FontWeight(600),
                                color = fontColor
                            )
                            Text(
                                text = "140 (90%)", fontSize = 12.sp,
                                fontWeight = FontWeight(400),
                                color = fontColor
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Method :", fontSize = 15.sp,
                                fontWeight = FontWeight(600),
                                color = fontColor
                            )
                            Row(
                                Modifier.fillMaxWidth(0.75f),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(50.dp, 25.dp)
                                        .clip(RoundedCornerShape(7.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Mobile", fontSize = 13.5.sp,
                                        fontWeight = FontWeight(500),
                                        color = mainFontColorStatic2
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .size(50.dp, 25.dp)
                                        .clip(RoundedCornerShape(7.dp))
                                        .background(mainGreenColor),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Web", fontSize = 13.5.sp,
                                        fontWeight = FontWeight(500),
                                        color = mainFontColorStatic2
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .size(50.dp, 25.dp)
                                        .clip(RoundedCornerShape(7.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "API", fontSize = 13.5.sp,
                                        fontWeight = FontWeight(500),
                                        color = mainFontColorStatic2
                                    )
                                }
                            }
                        }


                    }
                }


            }

            //loop end

        }


        //endtest

        //section +1 ?


        Spacer(modifier = Modifier.height(35.dp))
        //end main inner
    }
}