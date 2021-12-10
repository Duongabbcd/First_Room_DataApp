package gst.trainingcourse.studen_school_management.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import gst.trainingcourse.studen_school_management.utils.Constant

@Entity(tableName =  Constant.NOTE_TABLE)
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constant.ID_COLUMN)
    var id :Int = 0 ,
    @ColumnInfo(name = Constant.NAME_COLUMN)
    var title :String =Constant.EMPTY ,
    @ColumnInfo(name = Constant.DESCRIPTION_COLUMN)
    var description :String =Constant.EMPTY
)