package com.example.agendatelefonica.dao



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sqliteandroidroom.models.Contato

@Dao
interface ContatoDAO{

    //insert
    @Insert
    suspend fun addContato(contato: Contato)

    //select
    @Query("SELECT * FROM contatos")
    suspend fun getAllContatos():List<Contato>

    //update

    //delete
}
