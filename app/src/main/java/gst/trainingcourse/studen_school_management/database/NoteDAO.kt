package gst.trainingcourse.studen_school_management.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gst.trainingcourse.studen_school_management.database.entity.Note
import gst.trainingcourse.studen_school_management.utils.Constant
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note : Note)

    @Query("Select * from ${Constant.NOTE_TABLE}")
     fun getAllNotes(): Flow<List<Note>>
}