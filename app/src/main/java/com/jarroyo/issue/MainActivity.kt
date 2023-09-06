package com.jarroyo.issue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.jarroyo.issue.ui.theme.Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Theme {
                val bottomSheetNavigator = rememberBottomSheetNavigator()
                val navHostController = rememberNavController(bottomSheetNavigator)
                NavHost(
                    navController = navHostController,
                    startDestination = "home",
                    builder = {
                        addComposableDestinations()
                    },
                )
            }
        }
    }
}

fun NavGraphBuilder.addComposableDestinations() {
    composable("home") { MainContent() }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    BottomSheetScaffold(
        sheetContent = { SheetContent() },
    ) { _ ->
        Column {
            Text(text = "CONTENT")
        }
    }
}

@Composable
fun SheetContent() {
    Column {
        Text(text = "SheetContent")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Theme {
        MainContent()
    }
}