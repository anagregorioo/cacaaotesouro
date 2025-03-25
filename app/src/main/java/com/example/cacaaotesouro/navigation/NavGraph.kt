import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

@Composable
fun TreasureHuntApp() {
    val navController = rememberNavController()
    var startTime by remember { mutableStateOf(System.currentTimeMillis()) }

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController) { startTime = System.currentTimeMillis() }
        }
        composable("pista1") { PistaScreen(navController, "", "", "pista2") }
        composable("pista2") { PistaScreen(navController, "", "", "pista3") }
        composable("pista3") { PistaScreen(navController, "", "", "tesouro") }
        composable("tesouro") {
            val timeElapsed = (System.currentTimeMillis() - startTime) / 1000
            TreasureScreen(navController, timeElapsed)
        }
    }
}
