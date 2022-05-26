package com.vungoclong.viewmodel.main.search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import com.vungoclong.model.Book
import com.vungoclong.util.Constants
import com.vungoclong.util.State
import java.util.*


class SearchScreenViewModel : ViewModel() {

    val text = mutableStateOf("")
    val searchState: MutableState<State> = mutableStateOf(State.None)
    val listResult: MutableState<MutableList<Book>> = mutableStateOf(mutableListOf())

    fun searchStory() {
        try {
            searchState.value = State.Loading
            listResult.value.clear()
            val databaseReference: DatabaseReference =
                FirebaseDatabase.getInstance(Constants.FIREBASE_DB_URL).reference
            databaseReference.child("all_story").get().addOnSuccessListener {
                val list = it.getValue<List<Book>>()!!
                list.forEach {
                    if ((it.author!!.lowercase(Locale.getDefault()).contains(
                            text.value.lowercase(Locale.getDefault()).trim()
                        ) || it.name!!.lowercase(Locale.getDefault()).contains(
                            text.value.lowercase(Locale.getDefault()).trim()
                        )) && text.value.isNotEmpty()
                    ) {
                        listResult.value.add(it)
                    }
                }
                if (listResult.value.size == 0) {
                    searchState.value = State.NotFound
                } else {
                    searchState.value = State.Success
                }

            }.addOnFailureListener {
                searchState.value = State.Error("")
            }
        } catch (e: Exception) {
            searchState.value = State.Error("")
        }
    }

}