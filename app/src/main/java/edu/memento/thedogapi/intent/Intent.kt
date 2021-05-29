package edu.memento.thedogapi.intent

sealed class Intent {
    object GetDogEvent: Intent()
    object None: Intent()
}