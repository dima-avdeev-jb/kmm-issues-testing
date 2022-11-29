package comcommon.ui.authorization

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.components.authorization.Authorization

@Composable
fun ComposableB(component: Authorization) {
  Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    Button(
      onClick = component::doLogin,
    ) {
      Text("B", Modifier.padding(30.dp))
    }
  }
}
