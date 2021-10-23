package disiiy.khaper.doadzikirapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import disiiy.khaper.doadzikirapp.activity.DzikirDoaShalatActivity
import disiiy.khaper.doadzikirapp.activity.DzikirHarianActivity
import disiiy.khaper.doadzikirapp.activity.DzikirPagiPetangActivity
import disiiy.khaper.doadzikirapp.activity.DzikirSetiapSaatActivity
import disiiy.khaper.doadzikirapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding : ActivityMainBinding

    companion object{
        fun getLaunchService(from : Context)= Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()
        initView()
    }

    private fun initView() {
        mainBinding.llDzikirDoaShalat.setOnClickListener {
            startActivity(DzikirDoaShalatActivity.getLaunchService(this))
        }
        mainBinding.llDzikirSetiapSaat.setOnClickListener {
            startActivity(DzikirSetiapSaatActivity.getLaunchService(this))
        }
        mainBinding.llDzikirDoaHarian.setOnClickListener {
            startActivity(DzikirHarianActivity.getLaunchService(this))
        }
        mainBinding.llDzikirPagiPetang.setOnClickListener {
            startActivity(DzikirPagiPetangActivity.getLaunchService(this))
        }
    }

}