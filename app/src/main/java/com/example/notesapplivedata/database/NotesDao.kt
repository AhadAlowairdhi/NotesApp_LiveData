package com.example.notesapplivedata.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {
    @Query("SELECT * FROM Notes ORDER BY id ASC ")
    fun getallnotes(): LiveData<List<Notes>>

    @Insert
    fun insertNote(note: Notes)

    @Update
    fun updtNote(note: Notes)

    @Delete
    fun delNote(note:Notes)
}