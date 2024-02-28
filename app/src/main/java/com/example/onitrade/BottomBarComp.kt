package com.example.onitrade

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.onitrade.ui.theme.iconColor

@Composable
fun BottomBarComp(navController: NavController, selected: MutableState<String>,show:Boolean) {
if(show) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp
    if (screenWidth < 400) {
        Column(Modifier.background(MaterialTheme.colorScheme.primary)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(51.dp)
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                    .background(MaterialTheme.colorScheme.background),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                var selectedColor = MaterialTheme.colorScheme.onBackground
                IconButton(
                    modifier = Modifier.size(32.dp),
                    onClick = {
                        navController.navigate("homePage")
                        selected.value = "homePage"
                    }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.homepage),
                        contentDescription = null,
                        tint = if (selected.value == "homePage") selectedColor else iconColor
                    )
                }

                IconButton(
                    modifier = Modifier.size(32.dp),
                    onClick = {
                        navController.navigate("tradePage")//change
                        selected.value = "tradePage"
                    }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.trade),
                        contentDescription = null,
                        tint = if (selected.value == "tradePage") selectedColor else iconColor
                    )
                }

                IconButton(
                    modifier = Modifier.size(32.dp),
                    onClick = {
                        navController.navigate("homePage")//change
                        selected.value = "walletPage"
                    }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.wallet),
                        contentDescription = null,
                        tint = if (selected.value == "walletPage") selectedColor else iconColor
                    )
                }

                IconButton(
                    modifier = Modifier.size(32.dp),
                    onClick = {
                        navController.navigate("homePage")//change
                        selected.value = "bookmarkPage"
                    }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.bookmark),
                        contentDescription = null,
                        tint = if (selected.value == "bookmarkPage") selectedColor else iconColor
                    )
                }

            }
        }
    }
    if (screenWidth > 400) {
        Column(Modifier.background(MaterialTheme.colorScheme.primary)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                    .background(MaterialTheme.colorScheme.background),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                var selectedColor = MaterialTheme.colorScheme.onBackground
                IconButton(
                    modifier = Modifier.size(38.dp),
                    onClick = {
                        navController.navigate("homePage")
                        selected.value = "homePage"
                    }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.homepage),
                        contentDescription = null,
                        tint = if (selected.value == "homePage") selectedColor else iconColor
                    )
                }

                IconButton(
                    modifier = Modifier.size(38.dp),
                    onClick = {
                        navController.navigate("tradePage")//change
                        selected.value = "tradePage"
                    }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.trade),
                        contentDescription = null,
                        tint = if (selected.value == "tradePage") selectedColor else iconColor
                    )
                }

                IconButton(
                    modifier = Modifier.size(38.dp),
                    onClick = {
                        navController.navigate("homePage")//change
                        selected.value = "walletPage"
                    }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.wallet),
                        contentDescription = null,
                        tint = if (selected.value == "walletPage") selectedColor else iconColor
                    )
                }

                IconButton(
                    modifier = Modifier.size(38.dp),
                    onClick = {
                        navController.navigate("homePage")//change
                        selected.value = "bookmarkPage"
                    }) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.bookmark),
                        contentDescription = null,
                        tint = if (selected.value == "bookmarkPage") selectedColor else iconColor
                    )
                }

            }
        }
    }
}
}