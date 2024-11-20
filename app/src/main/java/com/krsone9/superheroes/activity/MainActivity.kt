package com.krsone9.superheroes.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.krsone9.superheroes.adapter.SuperheroesAdapter
import com.krsone9.superheroes.data.SuperheroesResponse
import com.krsone9.superheroes.databinding.ActivityMainBinding
import com.krsone9.superheroes.service.SuperheroesService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Token: 4c9698ec0b392b6e780c5ba4910c03f1 //
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofit: Retrofit

    private lateinit var adapter: SuperheroesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()


    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByNaMe(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        adapter = SuperheroesAdapter()
        binding.rvView.setHasFixedSize(true)
        binding.rvView.layoutManager = LinearLayoutManager(this)
        binding.rvView.adapter = adapter


    }

    private fun searchByNaMe(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(SuperheroesService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful) {
                val response: SuperheroesResponse? = myResponse.body()
                if (response != null) {
                    Log.i("krsone9", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.results)
                        binding.progressBar.isVisible = false
                    }

                }
                Log.i("krsone9", "funcionas?")
            } else {
                Log.i("krsone9", "pues no funciona")
            }
        }
    }

}

private fun getRetrofit(): Retrofit {
    return Retrofit
        .Builder()
        .baseUrl("https://superheroapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

}

