package gst.trainingcourse.studen_school_management.view.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import gst.trainingcourse.studen_school_management.database.entity.Note
import gst.trainingcourse.studen_school_management.repository.INoteRepository
import gst.trainingcourse.studen_school_management.repository.NoteRepository
import gst.trainingcourse.studen_school_management.repository.usecase.GetNoteUseCase
import gst.trainingcourse.studen_school_management.repository.usecase.UpdateNoteUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNoteUseCase: GetNoteUseCase ,
    private val updateNoteUseCase: UpdateNoteUseCase
):ViewModel() {

    private  val _notes = MutableLiveData<List<Note>>()
    val notes :LiveData<List<Note>>
    get() = _notes

    fun inserNote(note: Note){
        viewModelScope.launch {
            updateNoteUseCase.insertNote(note)
        }
    }


    fun getAllNotes(){
        viewModelScope.launch {
            getNoteUseCase.getAllNote().catch {
                ex ->
                Log.e("Fresher", "getAllNotes() Exception : $ex" )
                _notes.value = arrayListOf()
            }.collect {
                value ->  _notes.value =value
            }
        }
    }
}