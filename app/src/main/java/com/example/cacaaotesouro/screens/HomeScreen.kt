import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController, onStart: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Caça ao Tesouro", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            onStart()
            navController.navigate("") // primeira pista
        }) {
            Text("") //inicia a caça
        }
    }
}
