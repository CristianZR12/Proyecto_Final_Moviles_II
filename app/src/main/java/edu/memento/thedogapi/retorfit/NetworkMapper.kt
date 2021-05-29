package edu.memento.thedogapi.retorfit

import edu.memento.thedogapi.model.Dog
import edu.memento.thedogapi.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor():EntityMapper<DogNetworkEntity, Dog> {
    override fun mapFromEntity(entity: DogNetworkEntity): Dog {
        TODO("Not yet implemented")
        return Dog(
            id = entity.id,
            name = entity.name,
            bredFor = entity.bredFor,
            temperament = entity.temperament
        )
    }

    override fun mapToEntity(domainObject: Dog): DogNetworkEntity {
        TODO("Not yet implemented")
        return DogNetworkEntity(
            id = domainObject.id,
            name = domainObject.name,
            bredFor = domainObject.bredFor,
            temperament = domainObject.temperament
        )
    }

    fun mapListEntities(entities:List<DogNetworkEntity>):List<Dog> {
        return entities.map { mapFromEntity(it) }
    }

}