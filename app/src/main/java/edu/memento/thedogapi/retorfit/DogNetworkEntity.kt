package edu.memento.thedogapi.retorfit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DogNetworkEntity(
    @SerializedName("id")
    @Expose
    var id:Int,

    @SerializedName("name")
    @Expose
    var name:String,

    @SerializedName("bred_for")
    @Expose
    var bredFor:String,

    @SerializedName("temperament")
    @Expose
    var temperament:String,
)