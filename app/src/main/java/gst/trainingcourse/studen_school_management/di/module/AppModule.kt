package gst.trainingcourse.studen_school_management.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gst.trainingcourse.studen_school_management.database.NoteDAO
import gst.trainingcourse.studen_school_management.database.NoteDatabase
import gst.trainingcourse.studen_school_management.database.entity.Note
import gst.trainingcourse.studen_school_management.utils.DispatcherProvider
import gst.trainingcourse.studen_school_management.utils.StandardDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) :NoteDatabase = NoteDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideNoteDao(database: NoteDatabase) :NoteDAO= database.getNoteDao()

    @Singleton
    @Provides
    fun provideDispatcherProvider():DispatcherProvider =StandardDispatcher()
}