package com.kelly.requestapp.ui

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kelly.requestapp.api.RequestProvider
import com.kelly.requestapp.models.Item
import com.kelly.requestapp.models.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel() : ViewModel() {

    val itemsLiveData = MutableLiveData<List<Item>>()
    val studentsLiveData = MutableLiveData<List<Student>>()

    //    val studentsLiveData = liveData<List<Student>> {
//        itemsLiveData.postValue(ServiceProvider.placeHolderApi.getItems())
//    }
    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                itemsLiveData.postValue(RequestProvider.apiRequests.getItems())
            } catch (ex: Exception) {

            }
        }
    }

    fun addStudent(newStudent: Student) {
        CoroutineScope(Dispatchers.IO).launch {
            studentsLiveData.postValue(RequestProvider.apiRequests.addStudents(newStudent))
        }
    }
}