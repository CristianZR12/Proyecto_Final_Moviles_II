package edu.memento.thedogapi.utils

import edu.memento.thedogapi.model.Dog
import java.lang.Exception

sealed class DataState {
    object Idle:DataState()
    data class Success(val dogs:List<Dog>):DataState()
    data class Error(val exception: Exception):DataState()
    object Loading:DataState()
}
