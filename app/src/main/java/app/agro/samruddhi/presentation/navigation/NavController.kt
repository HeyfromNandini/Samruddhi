package app.agro.samruddhi.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.agro.samruddhi.edutech.AgriEdu
import app.agro.samruddhi.edutech.PlantEdu
import app.agro.samruddhi.governmentschemes.GovSchemes
import app.agro.samruddhi.practice.Practice
import app.agro.samruddhi.presentation.apnabazaar.ui.BuyerAccRej
import app.agro.samruddhi.presentation.apnabazaar.ui.BuyerApnabazaar
import app.agro.samruddhi.presentation.apnabazaar.ui.BuyerList
import app.agro.samruddhi.presentation.apnabazaar.ui.FarmerApnabazaar
import app.agro.samruddhi.presentation.apnabazaar.ui.FarmerList
import app.agro.samruddhi.presentation.apnabazaar.ui.TransportChoice
import app.agro.samruddhi.presentation.home.ui.HomeScreen
import app.agro.samruddhi.presentation.login.LoginViewModel
import app.agro.samruddhi.presentation.login.ui.LoginScreen
import app.agro.samruddhi.presentation.login.ui.SelectOption
import app.agro.samruddhi.presentation.rentalservices.RentalServices
import app.agro.samruddhi.presentation.selectcrop.ui.SelectCropScreen
import app.agro.samruddhi.presentation.weather.Weather


@Composable
fun MainNavController() {
    val navHostController = rememberNavController()
    val loginViewModel: LoginViewModel = hiltViewModel()
    NavHost(
        navController = navHostController,
        startDestination = Screens.ChooseUserType.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300),
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300),
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300),
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300),
            )
        },

        ) {
        composable(Screens.Login.route) {
            LoginScreen(navController = navHostController)
        }

        composable(Screens.SelectCrop.route) {
            SelectCropScreen(navHostController)
        }

        composable(Screens.Home.route) {
            HomeScreen(navController = navHostController)
        }

        composable(Screens.ApnaBazaar.route) {
            FarmerApnabazaar(navHostController)
        }

        composable(Screens.Weather.route) {
            Weather()
        }

        composable(Screens.ChooseUserType.route) {
            SelectOption(navHostController)
        }

        composable(Screens.BuyerList.route) {
            BuyerList(navHostController)
        }

        composable(Screens.FarmerApnaBazaar.route) {
            FarmerApnabazaar(navHostController)
        }

        composable(Screens.ConfirmBuyer.route) {
            BuyerAccRej(navHostController)
        }

        composable(Screens.FarmerList.route) {
            FarmerList(navHostController)
        }


        composable(Screens.BuyerApnaBazaar.route) {
            BuyerApnabazaar(navHostController)
        }







        composable(Screens.TransportChoice.route) {
            TransportChoice(navHostController)
        }
        composable(Screens.RentalServices.route) {
            RentalServices(navHostController)
        }
        composable(Screens.GovSchemes.route) {
            GovSchemes(navHostController)
        }
        composable(Screens.AGRIEdu.route) {
           AgriEdu(navHostController)
        }
        composable(Screens.PlantEdu.route) {
            PlantEdu(navHostController)
        }
        composable(Screens.Practice.route) {
            Practice(navHostController)
        }


    }
}

