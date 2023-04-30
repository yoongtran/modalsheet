package eu.wewox.modalsheet.ui.components

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * The reusable bottom navigation component.
 *
 * @param current The currently selected item.
 * @param onClick Called when user selects the bottom navigation item.
 */
@Composable
fun BottomNavigation(
    current: BottomNavItem,
    onClick: (BottomNavItem) -> Unit,
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.navigationBarsPadding(),
        ) {
            BottomNavItem.values().forEach { item ->
                NavigationBarItem(
                    icon = { Icon(item.imageVector, item.title) },
                    label = { Text(item.title) },
                    selected = current == item,
                    onClick = { onClick(item) },
                )
            }
        }
    }
}

/**
 * The bottom navigation item with [title] for label and [imageVector] for icon.
 */
enum class BottomNavItem(var title: String, var imageVector: ImageVector) {
    Home("Home", Icons.Default.Home),
    Counter("Counter", Icons.Default.AddCircle),
    Profile("Profile", Icons.Default.Person),
}
