package disiiy.khaper.doadzikirapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import disiiy.khaper.doadzikirapp.R
import disiiy.khaper.doadzikirapp.adapter.DzikirDoaAdapter
import disiiy.khaper.doadzikirapp.databinding.ActivityPagiBinding
import disiiy.khaper.doadzikirapp.databinding.ActivityPetangBinding
import disiiy.khaper.doadzikirapp.model.DataDzikirDoa
import disiiy.khaper.doadzikirapp.model.DataDzikirDoa.listDzikirPagi
import disiiy.khaper.doadzikirapp.model.DzikirDoa

class PetangActivity : AppCompatActivity() {
    private lateinit var petangBinding: ActivityPetangBinding
    private var listDzikirPetang : ArrayList<DzikirDoa> = arrayListOf()

    companion object{
        fun getLaunchService(from : Context) = Intent(from, PetangActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        petangBinding = ActivityPetangBinding.inflate(layoutInflater)
        setContentView(petangBinding.root)
        supportActionBar?.hide()
        showRecyclerList()
        back()
    }

    private fun back() {
        petangBinding.ivBackDzikirPetang.setOnClickListener {
            startActivity(DzikirPagiPetangActivity.getLaunchService(this))
        }
    }

    private fun showRecyclerList() {
        petangBinding.rvDzikirPetang.setHasFixedSize(true)
        listDzikirPetang.clear()
        listDzikirPetang.addAll(DataDzikirDoa.listDzikirPetang)
        petangBinding.rvDzikirPetang.layoutManager = LinearLayoutManager(this)
        petangBinding.rvDzikirPetang.adapter = DzikirDoaAdapter(listDzikirPetang)
    }
}