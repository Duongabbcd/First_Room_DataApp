package gst.trainingcourse.studen_school_management.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import gst.trainingcourse.studen_school_management.base.BaseFragment
import gst.trainingcourse.studen_school_management.databinding.FragmentListNoteBinding
import gst.trainingcourse.studen_school_management.view.adapter.NoteAdapter
import gst.trainingcourse.studen_school_management.view.viewmodel.NoteViewModel

@AndroidEntryPoint
class ListNoteFragment : BaseFragment<FragmentListNoteBinding> (){
    private val listNoteViewModel :NoteViewModel by activityViewModels()

    private val noteAdapter =NoteAdapter()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentListNoteBinding = FragmentListNoteBinding.inflate(inflater,container,false)

    override fun initAction() {
        binding.btnAddNote.setOnClickListener{
            navigationAddNoteFragment()
        }


    }

    override fun observerLiveData() {
      listNoteViewModel.notes.observe(this){
          notes -> noteAdapter.submitList(notes)
          println("Size ${notes.size}")
      }
    }

    override fun initData() {
        listNoteViewModel.getAllNotes()
    }

    override fun initView() {
      binding.rvNotes.setHasFixedSize(true)
        binding.rvNotes.layoutManager =LinearLayoutManager(requireContext())
        binding.rvNotes.adapter=noteAdapter
    }

    private fun navigationAddNoteFragment() {
        val action = ListNoteFragmentDirections.fronListNoteFragmentToAddFragment()
        findNavController().navigate(action)
    }
}