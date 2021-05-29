package edu.memento.thedogapi.room

import edu.memento.thedogapi.model.Dog
import edu.memento.thedogapi.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():EntityMapper<DogCacheEntity, Dog> {
    override fun mapFromEntity(entity: DogCacheEntity): Dog {
        TODO("Not yet implemented")
        return Dog(
            id = entity.id,
            name = entity.name,
            bredFor = entity.bredFor,
            temperament = entity.temperament
        )
    }

    override fun mapToEntity(domainObject: Dog): DogCacheEntity {
        TODO("Not yet implemented")
        return DogCacheEntity(
            id = domainObject.id,
            name = domainObject.name,
            bredFor = domainObject.bredFor,
            temperament = domainObject.temperament
        )
    }

    fun mapListEntity(entities:List<DogCacheEntity>):List<Dog> {
        return entities.map { mapFromEntity(it) }
    }

}