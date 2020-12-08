package com.example.agendatelefonica.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agendatelefonica.services.Repository
import com.example.sqliteandroidroom.models.Contato
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository): ViewModel() {
    val listaContatos = MutableLiveData<List<Contato>>()

    fun addGastoDB(contato: Contato){
        viewModelScope.launch {
            listaContatos.value = repository.addContatoTask(contato)
        }

        fun getContatos() {
            viewModelScope.launch {

            }
        }

    }
}
