package com.example.onitrade

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgs
import com.example.onitrade.ui.theme.OniTradeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var darkTheme = isSystemInDarkTheme()
            OniTradeTheme(darkTheme = darkTheme) {
                val screenWidth = LocalConfiguration.current.screenWidthDp
                val screenHeight = LocalConfiguration.current.screenHeightDp

                val navState = rememberNavController()
                //scaffold
                var scaffoldState = rememberScaffoldState()
                var selected = remember {
                    mutableStateOf("homePage")
                }
                    androidx.compose.material.Scaffold(
                        scaffoldState = scaffoldState,
                        topBar = {
                            TopBarComp(navController = navState )
                        },
                        bottomBar = {
                            BottomBarComp(navController = navState,selected)
                        }
                    ) {
                        //inside scaffold

                        NavHost(navController = navState, startDestination = "homePage") {
                            composable(route = "homePage") {
                                if(screenWidth<400) {
                                    HomeComp(navState)
                                }
                                else{
                                    HomeComp2(navState)
                                }
                                selected.value = "homePage"
                                //DrawCubic()
                            }
                        }
                        //end of scaffold
                    }



            }

        }
    }
}
