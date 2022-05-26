package com.vungoclong.viewmodel.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import com.vungoclong.model.Book
import com.vungoclong.util.Constants.FIREBASE_DB_URL
import com.vungoclong.util.State

class HomeScreenViewModel : ViewModel() {

    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance(FIREBASE_DB_URL).reference

    val listHighLightStory: MutableState<List<Book>> = mutableStateOf(listOf())
    val listNewUpdateStory: MutableState<List<Book>> = mutableStateOf(listOf())
    val listFavoriteStory: MutableState<List<Book>> = mutableStateOf(listOf())
    val highLightState: MutableState<State> = mutableStateOf(State.Loading)
    val newUpdateState: MutableState<State> = mutableStateOf(State.Loading)
    val favoriteState: MutableState<State> = mutableStateOf(State.Loading)

    init {
        getData()
    }

    fun getData() {
        try {
            highLightState.value = State.Loading
            newUpdateState.value = State.Loading
            favoriteState.value = State.Loading

            databaseReference.child("high_light_story").get().addOnSuccessListener {
                listHighLightStory.value = it.getValue<List<Book>>()!!
                highLightState.value=State.Success
            }.addOnFailureListener {
            }
            databaseReference.child("new_update_story").get().addOnSuccessListener {
                listNewUpdateStory.value = it.getValue<List<Book>>()!!
                newUpdateState.value = State.Success
            }.addOnFailureListener {
            }
            databaseReference.child("favorite_story").get().addOnSuccessListener {
                listFavoriteStory.value = it.getValue<List<Book>>()!!
                favoriteState.value = State.Success
            }.addOnFailureListener {
            }
        } catch (e: Exception) {
        }

    }
}