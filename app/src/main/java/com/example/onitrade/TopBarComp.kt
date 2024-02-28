package com.example.onitrade

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onitrade.ui.theme.iconColor
import com.example.onitrade.ui.theme.mainYellowColor

@Composable
fun TopBarComp(navController: NavController,showBack:Boolean,showSetting:Boolean) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.primary)
        .padding(bottom = 0.dp, top = 5.dp, start = 10.dp, end = 10.dp)
    ){
        Box(modifier = Modifier
            .align(Alignment.Center)){
            Text(text = buildAnnotatedString {
                withStyle(SpanStyle(fontSize = 15.sp, fontWeight = FontWeight(1000), color = MaterialTheme.colorScheme.tertiary)){
                    append("Oni")
                }

                withStyle(SpanStyle(fontSize = 15.sp, fontWeight = FontWeight(1000), color = mainYellowColor)){
                    append("T")
                }

                withStyle(SpanStyle(fontSize = 15.sp, fontWeight = FontWeight(1000), color = MaterialTheme.colorScheme.tertiary)){
                    append("rade")
                }
            })
        }


            Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    if(showSetting) {
                    IconButton(onClick = { navController.navigate("settingPage") }) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = null,
                            tint = iconColor
                        )
                    }
                    }
                    Box(
                        modifier = Modifier.size(45.dp).clip(RoundedCornerShape(100))
                            .background(Color.LightGray).clickable { })
                }
            }



            Box(modifier = Modifier.align(Alignment.CenterStart)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    if(showBack) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            modifier = Modifier.fillMaxSize(),
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = iconColor
                        )
                    }
                    }
                }
            }

    }
}