@file:OptIn(ExperimentalSheetApi::class)

package eu.wewox.modalsheet.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import eu.wewox.modalsheet.Example
import eu.wewox.modalsheet.ExperimentalSheetApi
import eu.wewox.modalsheet.ui.components.TopBar
import eu.wewox.modalsheet.ui.theme.SpacingMedium

/**
 * Showcases the most simple usage of the modal sheet composable.
 * Shows the bottom sheet on button click.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun M3BottomModalSheetScreen() {
    Scaffold(
        topBar = { TopBar(Example.M3ModalBottomSheet.label) }
    ) { padding ->
        var visible by rememberSaveable { mutableStateOf(false) }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Button(onClick = { visible = true }) {
                Text(text = "Show m3 modal bottom sheet")
            }
        }

        if (visible) {
            ModalBottomSheet(
                onDismissRequest = { visible = false},
                sheetState = rememberModalBottomSheetState(
                    skipPartiallyExpanded = true
                )
            ) {
                Column(
                        modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(SpacingMedium)
                ) {
                    Text(
                        text = "Hello there \uD83D\uDC4B",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "Swipe down, tap on scrim above, tap on hardware " +
                            "back button or use a button below to close modal.",
                    )
                }
            }
        }
    }
}
