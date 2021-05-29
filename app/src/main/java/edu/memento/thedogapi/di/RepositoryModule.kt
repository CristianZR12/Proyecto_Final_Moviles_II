package edu.memento.thedogapi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import edu.memento.thedogapi.repository.DogRepository
import edu.memento.thedogapi.retorfit.DogRetrofit
import edu.memento.thedogapi.retorfit.NetworkMapper
import edu.memento.thedogapi.room.CacheMapper
import edu.memento.thedogapi.room.DogDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideDogRepository(
        dogDao: DogDao,
        dogRetrofit: DogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): DogRepository {
        return DogRepository(dogDao, dogRetrofit,
            cacheMapper, networkMapper)
    }
}