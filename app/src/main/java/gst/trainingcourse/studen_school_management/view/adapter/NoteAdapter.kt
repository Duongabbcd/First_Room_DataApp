package gst.trainingcourse.studen_school_management.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import gst.trainingcourse.studen_school_management.database.entity.Note
import gst.trainingcourse.studen_school_management.databinding.NoteItemBinding
import gst.trainingcourse.studen_school_management.view.viewmodel.NoteViewModel

class NoteAdapter : ListAdapter<Note, NoteAdapter.NoteViewHolder>(DIFF_UTILS){
    companion object{
        val DIFF_UTILS by lazy{
            object  :DiffUtil.ItemCallback<Note>(){
                override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                   return oldItem.title ==newItem.title
                }

                override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                   return oldItem ==newItem
                }

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
      val binding =NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
      holder.onBind(getItem(position))
    }



    class NoteViewHolder(
        private val binding :NoteItemBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun onBind(note :Note) =with(binding){
            tvNoteName.text= note.title
            tvNoteDescription.text =note.description
        }

    }
}