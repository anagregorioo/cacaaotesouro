import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cacaaotesouro.screens.HomeScreen

@Composable
fun TreasureHuntApp() {
    val navController = rememberNavController()
    var startTime by remember { mutableLongStateOf(System.currentTimeMillis()) }

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
