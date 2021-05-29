package edu.memento.thedogapi.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogBreeds")
class DogCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "bredFor")
    var bredFor:String,

    @ColumnInfo(name = "temperament")
    var temperament:String,
)