package com.example.onitrade

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.onitrade.ui.theme.iconColor
import com.example.onitrade.ui.theme.mainGreenColor
import com.example.onitrade.ui.theme.mainSeperatorColor

@Composable
fun SettingComp(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(scrollState)
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //inner start
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
        //sec 1
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(start = 5.dp, top = 10.dp, end = 5.dp, bottom = 10.dp)
            .shadow()
            .drawWithCache {
                onDrawBehind {
                    val path = genPath(size)

                    drawPath(path, bgcColor, style = Fill)
                }
            }
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp, start = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "G",
                        fontSize = 35.sp,
                        fontWeight = FontWeight(1000),
                        color = iconColor
                    )
                    Column(
                        Modifier
                            .fillMaxWidth(0.7f)) {
                        Text(
                            text = "Recommended",
                            fontSize = 11.sp,
                            fontWeight = FontWeight(500),
                            color = mainGreenColor,
                            modifier = Modifier.align(
                                Alignment.End
                            )
                        )

                        Text(
                            text = "Authenticator App",
                            fontSize = 15.sp,
                            fontWeight = FontWeight(600),
                            color = iconColor,
                            modifier = Modifier.align(
                                Alignment.Start
                            )
                        )

                    }

                    var switchState by remember {
                        mutableStateOf(false)
                    }
                    Switch(checked = switchState, onCheckedChange ={switchState = !switchState} ,
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor =  mainGreenColor,

                        )
                    )
                }
                    Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,verticalAlignment = Alignment.CenterVertically){
                        Text(
                            text = "Prevent unauthorized access and used for withdrawls, and other security purposes.",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = iconColor,
                            lineHeight = 14.sp,
                            modifier = Modifier
                                .fillMaxWidth(0.7f)


                        )
                    }

            }

            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(mainSeperatorColor))
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 15.dp, start = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(modifier = Modifier.size(28.dp),painter = painterResource(id = R.drawable.text), tint = iconColor, contentDescription =null )
                    Column(
                        Modifier
                            .fillMaxWidth(0.7f)) {

                        Text(
                            text = "Voice or Text Message",
                            fontSize = 15.sp,
                            fontWeight = FontWeight(600),
                            color = iconColor,
                            modifier = Modifier.align(
                                Alignment.Start
                            )
                        )

                    }

                    var switchState by remember {
                        mutableStateOf(false)
                    }
                    Switch(checked = switchState, onCheckedChange ={switchState = !switchState} ,
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.White,
                            checkedTrackColor =  mainGreenColor,

                            )
                    )
                }
                Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,verticalAlignment = Alignment.CenterVertically){
                    Text(
                        text = "Prevent unauthorized access and used for withdrawls, and other security purposes.",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = iconColor,
                        lineHeight = 14.sp,
                        modifier = Modifier
                            .fillMaxWidth(0.7f)


                    )
                }

            }
        }

        //sec 2


        //sec n


        //inner end
    }
}