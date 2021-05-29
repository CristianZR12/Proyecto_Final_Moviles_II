package edu.memento.thedogapi.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import edu.memento.thedogapi.utils.AdaptersDog
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdaptersDog {
        return AdaptersDog()
    }
}