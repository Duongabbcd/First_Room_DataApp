package gst.trainingcourse.studen_school_management.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import gst.trainingcourse.studen_school_management.database.NoteDAO
import gst.trainingcourse.studen_school_management.repository.INoteRepository
import gst.trainingcourse.studen_school_management.repository.NoteRepository
import gst.trainingcourse.studen_school_management.utils.DispatcherProvider
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideNoteRepository(noteDAO: NoteDAO ,dispatcherProvider: DispatcherProvider) :INoteRepository{
        return  NoteRepository(noteDAO,dispatcherProvider)
    }
}