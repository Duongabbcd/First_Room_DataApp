package gst.trainingcourse.studen_school_management.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gst.trainingcourse.studen_school_management.database.entity.Note
import gst.trainingcourse.studen_school_management.utils.Constant

@Database(entities =[Note::class]  ,version = 1)
abstract  class NoteDatabase :RoomDatabase(){

    abstract fun getNoteDao() :NoteDAO

    companion object{
        @Volatile
        private var INSTANCE :NoteDatabase ?= null

        fun getInstance(context: Context) :NoteDatabase = INSTANCE ?: synchronized(this){
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext ,
                NoteDatabase::class.java ,
            Constant.DATABASE_NAME).build()
                .also {
                    INSTANCE = it
                }
        }
    }
}