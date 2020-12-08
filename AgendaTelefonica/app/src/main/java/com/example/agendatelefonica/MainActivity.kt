package com.example.agendatelefonica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agendatelefonica.database.AppDataBase
import com.example.agendatelefonica.models.MainViewModel
import com.example.agendatelefonica.services.Repository
import com.example.agendatelefonica.services.RepositoryImplementation
import com.example.sqliteandroidroom.models.Contato
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapterResult: ContatosAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var db: AppDataBase
    private  lateinit var repository: Repository




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModel by viewModels<MainViewModel>{
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return MainViewModel(repository)  as T
                }
            }
        }


        initDB()
        repository = RepositoryImplementation(db.contatoDAO())
        viewModel.addGastoDB(Contato(55557777, "João"))

        adapterResult = ContatosAdapter()
        linearLayoutManager = LinearLayoutManager(this)
        recycler.adapter = adapterResult
        recycler.layoutManager = linearLayoutManager
        recycler.hasFixedSize()

       viewModel.listaContatos.observe(this){
            adapterResult.addList(it)
       }

    }

    fun initDB(){
        db = AppDataBase.invoke(this)
    }


}