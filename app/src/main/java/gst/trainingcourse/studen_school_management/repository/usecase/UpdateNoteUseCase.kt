package gst.trainingcourse.studen_school_management.repository.usecase

import gst.trainingcourse.studen_school_management.database.entity.Note
import gst.trainingcourse.studen_school_management.repository.INoteRepository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val noteRepository: INoteRepository){


    suspend fun  insertNote(note :Note){
        return noteRepository.insertNote(note)
    }
}