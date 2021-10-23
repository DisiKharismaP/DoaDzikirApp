package disiiy.khaper.doadzikirapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import disiiy.khaper.doadzikirapp.MainActivity
import disiiy.khaper.doadzikirapp.R
import disiiy.khaper.doadzikirapp.adapter.DzikirDoaAdapter
import disiiy.khaper.doadzikirapp.databinding.ActivityDzikirDoaShalatBinding
import disiiy.khaper.doadzikirapp.databinding.ActivityDzikirSetiapSaatBinding
import disiiy.khaper.doadzikirapp.model.DataDzikirDoa
import disiiy.khaper.doadzikirapp.model.DzikirDoa

class DzikirSetiapSaatActivity : AppCompatActivity() {
    private lateinit var dzikirSetiapSaatBinding : ActivityDzikirSetiapSaatBinding
    private var listDzikirSetiapSaat : ArrayList<DzikirDoa> = arrayListOf()

    companion object{
        fun getLaunchService(from : Context) = Intent(from, DzikirSetiapSaatActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirSetiapSaatBinding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(dzikirSetiapSaatBinding.root)
        supportActionBar?.hide()
        showRecycler()
        back()
    }

    private fun back() {
        dzikirSetiapSaatBinding.ivBackDzikirSetiapSaat.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }
    }

    private fun showRecycler() {
        dzikirSetiapSaatBinding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this)

        listDzikirSetiapSaat.clear()
        listDzikirSetiapSaat.addAll(DataDzikirDoa.listDzikir)

        dzikirSetiapSaatBinding.rvDzikirSetiapSaat.adapter = DzikirDoaAdapter(listDzikirSetiapSaat)
        dzikirSetiapSaatBinding.rvDzikirSetiapSaat.setHasFixedSize(true)
    }
}