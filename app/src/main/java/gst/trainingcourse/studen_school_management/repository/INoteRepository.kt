package gst.trainingcourse.studen_school_management.repository

import gst.trainingcourse.studen_school_management.database.entity.Note
import kotlinx.coroutines.flow.Flow

interface INoteRepository {
    suspend fun insertNote(note :Note)

   fun getAllNotes() :Flow<List<Note>>
}