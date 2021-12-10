package gst.trainingcourse.studen_school_management.repository

import gst.trainingcourse.studen_school_management.database.NoteDAO
import gst.trainingcourse.studen_school_management.database.entity.Note
import gst.trainingcourse.studen_school_management.utils.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDAO: NoteDAO,
    private val dispatcherProvider: DispatcherProvider
        ) : INoteRepository{

    override suspend fun insertNote(note: Note) {
       return withContext(dispatcherProvider.io){
           noteDAO.insertNote(note)
       }
    }

    override  fun getAllNotes(): Flow<List<Note>> {
       return noteDAO.getAllNotes().flowOn(dispatcherProvider.io)
    }
}