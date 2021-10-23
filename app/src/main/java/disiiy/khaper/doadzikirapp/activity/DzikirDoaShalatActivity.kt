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
import disiiy.khaper.doadzikirapp.model.DataDzikirDoa
import disiiy.khaper.doadzikirapp.model.DzikirDoa

class DzikirDoaShalatActivity : AppCompatActivity() {
    private lateinit var dzikirDoaShalatBinding : ActivityDzikirDoaShalatBinding
    private var listDzikirDoaShalat : ArrayList<DzikirDoa> = arrayListOf()

    companion object{
        fun getLaunchService(from : Context) = Intent(from, DzikirDoaShalatActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirDoaShalatBinding = ActivityDzikirDoaShalatBinding.inflate(layoutInflater)
        setContentView(dzikirDoaShalatBinding.root)
        supportActionBar?.hide()
        showRecycler()
        back()
    }

    private fun back() {
        dzikirDoaShalatBinding.ivBackDzikirDoaShalat.setOnClickListener {
            startActivity(MainActivity.getLaunchService(this))
        }
    }

    private fun showRecycler() {
        listDzikirDoaShalat.clear()
        listDzikirDoaShalat.addAll(DataDzikirDoa.listQauliyah)

        dzikirDoaShalatBinding.rvDzikirDoaShalat.layoutManager = LinearLayoutManager(this)
        dzikirDoaShalatBinding.rvDzikirDoaShalat.adapter = DzikirDoaAdapter(listDzikirDoaShalat)
        dzikirDoaShalatBinding.rvDzikirDoaShalat.setHasFixedSize(true)
    }

}