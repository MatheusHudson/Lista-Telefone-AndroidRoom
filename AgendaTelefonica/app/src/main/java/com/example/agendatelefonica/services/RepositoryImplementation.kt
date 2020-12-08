package com.example.agendatelefonica.services

import com.example.agendatelefonica.dao.ContatoDAO
import com.example.sqliteandroidroom.models.Contato

class RepositoryImplementation(val contatoDAO: ContatoDAO): Repository{



    override suspend fun addContatoTask(contato: Contato): List<Contato> {
        contatoDAO.addContato(contato)
        return contatoDAO.getAllContatos()
    }

    override suspend fun getAllContatosTask() = contatoDAO.getAllContatos()

}

interface Repository {

    suspend fun addContatoTask(contato: Contato): List<Contato>
    suspend fun getAllContatosTask(): List<Contato>

}
