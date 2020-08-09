package com.example.leado.mainNavigation.fragments.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.leado.data.Person

class ProfileViewModel: ViewModel() {

    fun getStats(): LiveData<Person>{
        return ProfileRepository.getStats()
    }
}