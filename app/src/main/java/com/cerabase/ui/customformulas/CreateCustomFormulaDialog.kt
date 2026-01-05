package com.cerabase.ui.customformulas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun CreateCustomFormulaDialog(
    onDismiss: () -> Unit,
    onCreate: (name: String, type: String, cone: String, ingredients: String, notes: String, properties: String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("Stoneware") }
    var cone by remember { mutableStateOf("6-8") }
    var ingredients by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    var properties by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .background(MaterialTheme.colorScheme.background, shape = RoundedCornerShape(16.dp))
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Yeni Formül Oluştur",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )

            // Name field
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Formül Adı") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Type field
            OutlinedTextField(
                value = type,
                onValueChange = { type = it },
                label = { Text("Tip (Porcelain, Stoneware, vb.)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Cone field
            OutlinedTextField(
                value = cone,
                onValueChange = { cone = it },
                label = { Text("Koni (6-8, 8-10, vb.)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Ingredients field
            OutlinedTextField(
                value = ingredients,
                onValueChange = { ingredients = it },
                label = { Text("Malzeme Listesi (virgülle ayrılmış)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                maxLines = 5,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            // Notes field
            OutlinedTextField(
                value = notes,
                onValueChange = { notes = it },
                label = { Text("Notlar (isteğe bağlı)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                maxLines = 3
            )

            // Properties field
            OutlinedTextField(
                value = properties,
                onValueChange = { properties = it },
                label = { Text("Özellikler (isteğe bağlı)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                maxLines = 3
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = onDismiss,
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Text("İptal")
                }

                Button(
                    onClick = {
                        if (name.isNotBlank() && type.isNotBlank() && cone.isNotBlank() && ingredients.isNotBlank()) {
                            onCreate(name, type, cone, ingredients, notes, properties)
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp),
                    enabled = name.isNotBlank() && type.isNotBlank() && cone.isNotBlank() && ingredients.isNotBlank(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF7F3F)
                    )
                ) {
                    Text("Oluştur")
                }
            }
        }
    }
}
