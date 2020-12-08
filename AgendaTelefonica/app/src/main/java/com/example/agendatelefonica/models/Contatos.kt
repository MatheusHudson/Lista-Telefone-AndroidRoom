package com.example.sqliteandroidroom.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contatos")
data class Contato(
    @PrimaryKey(autoGenerate = true)
    val telefone: Int,
    var nome: String
)
