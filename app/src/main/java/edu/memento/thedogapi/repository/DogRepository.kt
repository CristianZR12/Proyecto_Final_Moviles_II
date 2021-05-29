package edu.memento.thedogapi.repository

import edu.memento.thedogapi.retorfit.DogRetrofit
import edu.memento.thedogapi.retorfit.NetworkMapper
import edu.memento.thedogapi.room.CacheMapper
import edu.memento.thedogapi.room.DogDao
import edu.memento.thedogapi.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException


class DogRepository constructor(
    private val dogDao:DogDao,
    private val dogRetrofit:DogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getDogs(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val dogData = dogRetrofit.getDogs()
            val dogMap = networkMapper.mapListEntities(dogData)
            for(tempDog in dogMap) {
                dogDao.insert(cacheMapper.mapToEntity(tempDog))
            }
            val cacheDog = dogDao.get()
            emit(DataState.Success(cacheMapper.mapListEntity(cacheDog)))
        } catch (e: HttpException) {
            val cacheDog = dogDao.get()
            emit(DataState.Success(cacheMapper.mapListEntity(cacheDog)))
        }
    }
}