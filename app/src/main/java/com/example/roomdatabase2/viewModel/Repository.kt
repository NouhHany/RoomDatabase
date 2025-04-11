package com.example.roomdatabase2.viewModel

import com.example.roomdatabase2.roomDb.Note
import com.example.roomdatabase2.roomDb.NoteDatabase

class Repository(private val db: NoteDatabase) {
	suspend fun upsertNote(note: Note) {
		db.dao.upsertNote(note)
	}

	suspend fun deleteNote(note: Note) {
		db.dao.deleteNote(note)
	}

	fun getAllNotes() = db.dao.getAllNotes()
}
