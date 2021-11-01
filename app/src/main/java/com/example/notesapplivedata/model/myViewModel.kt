package com.example.notesapplivedata.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notesapplivedata.database.Notes
import com.example.notesapplivedata.database.NotesDatabase
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class myViewModel(activity: Application) : AndroidViewModel(activity){
    private val notes : LiveData<List<Notes>>

    // object
    val objndao = NotesDatabase.getInstance(activity).NotesDao()

    init {
        notes = objndao.getallnotes()
    }

    fun getnotes(): LiveData<List<Notes>>{
        return notes
    }

    fun addNote(note : Notes){
        GlobalScope.launch(Main){

            objndao.insertNote(note)
        }
    }

    fun updtNote(note: Notes){
        GlobalScope.launch(Main){
            objndao.updtNote(note)
        }
    }

    fun delNote(note: Notes){
        GlobalScope.launch(Main){
            objndao.delNote(note)
        }
    }

}