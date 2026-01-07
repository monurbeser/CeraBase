package com.cerabase.ui.dailyworknotes

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cerabase.data.database.WorkNoteEntity
import com.cerabase.data.repository.WorkNoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyWorkNotesScreen(
    repository: WorkNoteRepository,
    onBackClick: () -> Unit,
    onAddNoteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val allNotes by repository.getAllNotes().collectAsState(emptyList())
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    // Group notes by date
    val groupedNotes = allNotes.groupBy { it.date }
        .toSortedMap(compareByDescending { it })

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Günlük Çalışma Notları",
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Geri",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNoteClick,
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Yeni Kayıt")
            }
        }
    ) { paddingValues ->
        if (allNotes.isEmpty()) {
            EmptyState(paddingValues = paddingValues)
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                groupedNotes.forEach { (date, notes) ->
                    item {
                        DayHeader(
                            date = date,
                            noteCount = notes.size,
                            onExportPdf = {
                                coroutineScope.launch {
                                    exportDayToPdf(context, date, notes)
                                }
                            }
                        )
                    }

                    items(notes) { note ->
                        WorkNoteCard(
                            note = note,
                            onDelete = {
                                coroutineScope.launch {
                                    repository.deleteNote(note)
                                }
                            }
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun EmptyState(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "📋",
                fontSize = 64.sp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = "Henüz Kayıt Yok",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Günlük çalışma notlarınızı eklemek için + butonuna tıklayın",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
private fun DayHeader(
    date: Long,
    noteCount: Int,
    onExportPdf: () -> Unit
) {
    val dateFormat = SimpleDateFormat("dd MMMM yyyy, EEEE", Locale("tr", "TR"))
    val formattedDate = dateFormat.format(Date(date))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = formattedDate,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "$noteCount kayıt",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
            )
        }
        TextButton(onClick = onExportPdf) {
            Icon(
                imageVector = Icons.Default.PictureAsPdf,
                contentDescription = "PDF İndir",
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "PDF",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun WorkNoteCard(
    note: WorkNoteEntity,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    val imageUris = note.imageUris.split(",").filter { it.isNotBlank() }
    val timeFormat = SimpleDateFormat("HH:mm", Locale("tr", "TR"))
    val formattedTime = timeFormat.format(Date(note.createdAt))

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Saat: $formattedTime",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Sil",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }

        if (imageUris.isNotEmpty()) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(imageUris) { uriString ->
                    AsyncImage(
                        model = Uri.parse(uriString),
                        contentDescription = "Çalışma fotoğrafı",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        if (note.description.isNotBlank()) {
            Text(
                text = note.description,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)
            )
        }
    }
}

private suspend fun exportDayToPdf(context: Context, date: Long, notes: List<WorkNoteEntity>) {
    withContext(Dispatchers.IO) {
        try {
            val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale("tr", "TR"))
            val formattedDate = dateFormat.format(Date(date))
            val fileNameDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(date))

            val pdfDocument = PdfDocument()
            val pageWidth = 595 // A4 width in points
            val pageHeight = 842 // A4 height in points
            val margin = 40f
            val contentWidth = pageWidth - (margin * 2)

            var pageNumber = 1
            var currentY = margin
            var pageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()
            var page = pdfDocument.startPage(pageInfo)
            var canvas = page.canvas

            val titlePaint = Paint().apply {
                textSize = 24f
                isFakeBoldText = true
                color = android.graphics.Color.parseColor("#E85A3F")
            }

            val datePaint = Paint().apply {
                textSize = 16f
                color = android.graphics.Color.parseColor("#333333")
            }

            val textPaint = Paint().apply {
                textSize = 12f
                color = android.graphics.Color.BLACK
            }

            val timePaint = Paint().apply {
                textSize = 10f
                color = android.graphics.Color.GRAY
            }

            val linePaint = Paint().apply {
                color = android.graphics.Color.parseColor("#EEEEEE")
                strokeWidth = 1f
            }

            // Title
            canvas.drawText("Günlük Çalışma Raporu", margin, currentY + 24f, titlePaint)
            currentY += 40f

            // Date
            canvas.drawText(formattedDate, margin, currentY + 16f, datePaint)
            currentY += 40f

            // Line separator
            canvas.drawLine(margin, currentY, pageWidth - margin, currentY, linePaint)
            currentY += 20f

            val timeFormat = SimpleDateFormat("HH:mm", Locale("tr", "TR"))

            for (note in notes) {
                val formattedTime = timeFormat.format(Date(note.createdAt))
                val imageUris = note.imageUris.split(",").filter { it.isNotBlank() }

                // Calculate space needed for this note
                val imageHeight = if (imageUris.isNotEmpty()) 100f else 0f
                val textLines = wrapText(note.description, textPaint, contentWidth)
                val textHeight = textLines.size * 16f
                val noteHeight = 30f + imageHeight + textHeight + 30f // time + images + text + spacing

                // Check if we need a new page
                if (currentY + noteHeight > pageHeight - margin) {
                    pdfDocument.finishPage(page)
                    pageNumber++
                    pageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()
                    page = pdfDocument.startPage(pageInfo)
                    canvas = page.canvas
                    currentY = margin
                }

                // Time
                canvas.drawText("Saat: $formattedTime", margin, currentY + 12f, timePaint)
                currentY += 20f

                // Images (if any)
                if (imageUris.isNotEmpty()) {
                    var imageX = margin
                    val imageSize = 80f
                    val spacing = 10f

                    for (uriString in imageUris.take(4)) { // Max 4 images per row
                        try {
                            val uri = Uri.parse(uriString)
                            val inputStream = context.contentResolver.openInputStream(uri)
                            inputStream?.let { stream ->
                                val bitmap = BitmapFactory.decodeStream(stream)
                                stream.close()
                                if (bitmap != null) {
                                    val scaledBitmap = Bitmap.createScaledBitmap(
                                        bitmap,
                                        imageSize.toInt(),
                                        imageSize.toInt(),
                                        true
                                    )
                                    canvas.drawBitmap(scaledBitmap, imageX, currentY, null)
                                    imageX += imageSize + spacing
                                    scaledBitmap.recycle()
                                    bitmap.recycle()
                                }
                            }
                        } catch (e: Exception) {
                            // Skip this image if there's an error
                        }
                    }
                    currentY += imageSize + 10f
                }

                // Description text
                if (note.description.isNotBlank()) {
                    for (line in textLines) {
                        canvas.drawText(line, margin, currentY + 12f, textPaint)
                        currentY += 16f
                    }
                }

                // Separator line
                currentY += 10f
                canvas.drawLine(margin, currentY, pageWidth - margin, currentY, linePaint)
                currentY += 20f
            }

            pdfDocument.finishPage(page)

            // Save to Downloads folder
            val downloadsDir = context.getExternalFilesDir(null)
            val fileName = "calisma_raporu_$fileNameDate.pdf"
            val file = File(downloadsDir, fileName)
            FileOutputStream(file).use { outputStream ->
                pdfDocument.writeTo(outputStream)
            }
            pdfDocument.close()

            withContext(Dispatchers.Main) {
                Toast.makeText(
                    context,
                    "PDF kaydedildi: ${file.absolutePath}",
                    Toast.LENGTH_LONG
                ).show()
            }

        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(
                    context,
                    "PDF oluşturulurken hata: ${e.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}

private fun wrapText(text: String, paint: Paint, maxWidth: Float): List<String> {
    val words = text.split(" ")
    val lines = mutableListOf<String>()
    var currentLine = StringBuilder()

    for (word in words) {
        val testLine = if (currentLine.isEmpty()) word else "$currentLine $word"
        val testWidth = paint.measureText(testLine)

        if (testWidth > maxWidth && currentLine.isNotEmpty()) {
            lines.add(currentLine.toString())
            currentLine = StringBuilder(word)
        } else {
            currentLine = StringBuilder(testLine)
        }
    }

    if (currentLine.isNotEmpty()) {
        lines.add(currentLine.toString())
    }

    return lines.ifEmpty { listOf("") }
}
