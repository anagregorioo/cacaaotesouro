import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PistaScreen(navController: NavHostController, pista: String, respostaCerta: String, nextRoute: String) {
    var resposta by remember { mutableStateOf(TextFieldValue("")) }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = pista, style = MaterialTheme.typography.headlineMedium) //mudar estilo depois
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = resposta,
            onValueChange = { resposta = it },
            label = { Text("") } //resposta
        )
        if (showError) {
            Text("", color = MaterialTheme.colors.error) //resposta errada //material 3 é diferente
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(onClick = { navController.popBackStack() }) {
                Text("Voltar")
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                if (resposta.text.trim().lowercase() == respostaCerta) {
                    navController.navigate(nextRoute)
                } else {
                    showError = true
                }
            }) {
                Text("") //proxima pista
            }
        }
    }
}
