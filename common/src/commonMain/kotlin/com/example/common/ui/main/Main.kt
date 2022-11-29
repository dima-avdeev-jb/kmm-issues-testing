package comcommon.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.components.main.Main
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(component: Main) {

  Scaffold {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      Button(
        onClick = {
          component.openAuthorizationPage()
        }) {
        Text("Press me", Modifier.padding(20.dp))
      }
    }
  }
}
