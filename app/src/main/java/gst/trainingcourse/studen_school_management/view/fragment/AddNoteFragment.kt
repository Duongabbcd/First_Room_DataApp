package gst.trainingcourse.studen_school_management.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import gst.trainingcourse.studen_school_management.R
import gst.trainingcourse.studen_school_management.base.BaseFragment
import gst.trainingcourse.studen_school_management.database.entity.Note
import gst.trainingcourse.studen_school_management.databinding.FragmentAddNoteBinding
import gst.trainingcourse.studen_school_management.view.viewmodel.NoteViewModel

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>() {
    private val noteViewModel : NoteViewModel by activityViewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentAddNoteBinding  = FragmentAddNoteBinding.inflate(inflater,container,false)

    override fun initAction() {
       binding.btnAddNote.setOnClickListener {
           handleAddNote()
         navigateToListNote()
       }
    }

    private fun handleAddNote() {
     val note =Note(
         title = binding.edtAddNote.text.toString(),
        description = binding.edtDescription.text.toString()
     )
        noteViewModel.inserNote(note)
    }


    private fun navigateToListNote() {
        val action = AddNoteFragmentDirections.fromAddNoteToListNote()
        findNavController().navigate(action)
    }


}