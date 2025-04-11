package com.example.roomdatabase2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase2.roomDb.Note
import com.example.roomdatabase2.roomDb.NoteDatabase
import com.example.roomdatabase2.ui.theme.RoomDatabase2Theme
import com.example.roomdatabase2.viewModel.NoteViewModel
import com.example.roomdatabase2.viewModel.Repository

class MainActivity : ComponentActivity() {
	private val db by lazy {
		Room.databaseBuilder(
			applicationContext,
			NoteDatabase::class.java,
			name = "note.db"
		).build()
	}

	private val viewModel by viewModels<NoteViewModel>(
		factoryProducer = {
			object : ViewModelProvider.Factory {
				override fun <T : ViewModel> create(modelClass: Class<T>): T {
					return NoteViewModel(Repository(db)) as T
				}
			}
		}
	)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			var name by remember {
				mutableStateOf(value = "")
			}
			var body by remember {
				mutableStateOf(value = "")
			}
			val note = Note(
				name,
				body
			)

			var noteList by remember {
				mutableStateOf(listOf<Note>())
			}
			viewModel.getAllNotes().observe(this) {
				noteList = it
			}

			Column(
				modifier = Modifier.padding(30.dp, top = 50.dp),
				verticalArrangement = Arrangement.spacedBy(12.dp)
			) {
				Button(onClick = {
					viewModel.upsertNote(note = note)
				}) {
					Text(text = "set data")
				}

				TextField(
					value = name,
					onValueChange = { name = it },
					placeholder = { Text(text = "name") }
				)
				TextField(
					value = body,
					onValueChange = { body = it },
					placeholder = { Text(text = "body") }
				)

				LazyColumn {
					items(noteList) { note->
						Column(
							modifier = Modifier.clickable {
								viewModel.deleteNote(note)
							}
						) {
							Text(text = "Name: ${note.noteName}")
							Text(text = "Name: ${note.noteBody}")
						}
					}
				}
			}
		}
	}
}

