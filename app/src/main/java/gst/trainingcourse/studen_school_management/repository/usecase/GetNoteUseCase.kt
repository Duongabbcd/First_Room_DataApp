package gst.trainingcourse.studen_school_management.repository.usecase

import gst.trainingcourse.studen_school_management.database.entity.Note
import gst.trainingcourse.studen_school_management.repository.INoteRepository
import gst.trainingcourse.studen_school_management.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(private val noteRepository: INoteRepository) {
    fun getAllNote() :Flow<List<Note>>{
        return noteRepository.getAllNotes()
    }
}