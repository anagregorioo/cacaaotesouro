import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun TreasureScreen(navController: NavHostController, timeElapsed: Long) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(500)
        isVisible = true
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = isVisible, enter = fadeIn(), exit = fadeOut()) {
            Text(text = "", style = MaterialTheme.typography.h4) // finaliza encontrando o tesouro
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("Tempo total: $timeElapsed segundos")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate("home") }) {
            Text("") //reiniciar
        }
    }
}
