package com.cerabase.ui.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

object ClipboardUtil {
    fun copyToClipboard(
        context: Context,
        text: String,
        label: String = "CeraBase Data"
    ) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(label, text)
        clipboard.setPrimaryClip(clip)
    }

    fun copyAndShowSnackbar(
        context: Context,
        text: String,
        snackbarHostState: SnackbarHostState,
        coroutineScope: CoroutineScope,
        label: String = "CeraBase Data"
    ) {
        copyToClipboard(context, text, label)
        coroutineScope.launch {
            snackbarHostState.showSnackbar("✓ Kopyalandı")
        }
    }
}
