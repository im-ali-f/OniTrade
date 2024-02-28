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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onitrade.ui.theme.BTCColor
import com.example.onitrade.ui.theme.ETHColor
import com.example.onitrade.ui.theme.PPCColor
import com.example.onitrade.ui.theme.XLMColor
import com.example.onitrade.ui.theme.mainSeperatorColor

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
            .fillMaxSize()
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
        tradeInfosList.forEach {
            token ->

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
            Column(modifier = if(isSelected) modifSelected else modifUnSelected,
                horizontalAlignment = Alignment.CenterHorizontally) {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(60.dp)
                            .background(Color.Red), contentAlignment = Alignment.Center
                    ) {
                        val iconColor = token["color"] as Color
                        Box(modifier = Modifier
                            .fillMaxSize(0.8f)
                            .clip(RoundedCornerShape(100)).background(iconColor), contentAlignment = Alignment.Center) {
                            val icon = token["icon"] as Int

                            Icon(modifier = Modifier.fillMaxSize(0.8f),painter = painterResource(id = icon), contentDescription =null , tint = Color.White )
                        }
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Transparent), contentAlignment = Alignment.BottomEnd) {

                            Box(modifier = Modifier
                                .fillMaxSize(0.5f)
                                .clip(RoundedCornerShape(100)).background(iconColor), contentAlignment = Alignment.Center) {
                                val icon = token["icon"] as Int

                                Icon(modifier = Modifier.fillMaxSize(0.8f),painter = painterResource(id = icon), contentDescription =null , tint = Color.White )
                            }

                        }

                    }
                }//badan por mikonim

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
                            .height(200.dp)
                            .background(Color.Transparent)
                    ) {

                    }
                }


            }

            //loop end

        }


            //endtest

            //section +1 ?


            Spacer(modifier = Modifier.height(50.dp))
            //end main inner
        }
    }