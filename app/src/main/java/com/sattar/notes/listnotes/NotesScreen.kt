package com.sattar.notes.listnotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sattar.notes.R
import com.sattar.notes.model.Note
import com.sattar.notes.ui.theme.lightGray200


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NotesScreen() {

    val notes: List<Note> = listOf(
        Note("Title1", "12:23"),
        Note("Title2", "16:12"),
        Note("Title3", "21:32")
    )
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = White
                )
            )
        },
        content = {
            Card(
                modifier = Modifier
                    .padding(it)
                    .padding(16.dp)
            ) {
                LazyColumn (
                    Modifier.background(lightGray200)
                        ){
                    items(
                        items = notes,
                        itemContent = {
                            NoteCard(it)
                        })
                }
            }
        }
    )
}


@Composable
fun NoteCard(note: Note) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            text = note.title,
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            text = note.date,
            style = MaterialTheme.typography.titleSmall
        )
    }
}