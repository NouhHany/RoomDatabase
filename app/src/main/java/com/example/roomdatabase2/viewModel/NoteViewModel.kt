package com.example.roomdatabase2.viewModel

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase2.roomDb.Note
import kotlinx.coroutines.launch

class NoteViewModel(
	private val repository: Repository
) : ViewModel() {
	fun getAllNotes() = repository.getAllNotes().asLiveData(viewModelScope.coroutineContext)

	fun upsertNote(note: Note) {
		viewModelScope.launch {
			repository.upsertNote(note)
		}
	}

	fun deleteNote(note: Note) {
		viewModelScope.launch {
			repository.deleteNote(note)
		}
	}
}
