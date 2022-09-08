package com.sattar.notes.listnotes

import androidx.lifecycle.ViewModel
import com.sattar.notes.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class NotesViewModel @Inject constructor() : ViewModel() {

    val uiState = MutableStateFlow(NotesUiState())

    init {
        uiState.update {
            it.copy(
                notes = listOf(
                    Note("Title1", "12:23"),
                    Note("Title2", "16:12"),
                    Note("Title3", "21:32")
                )
            )
        }
    }
}

data class NotesUiState(val notes: List<Note> = emptyList())