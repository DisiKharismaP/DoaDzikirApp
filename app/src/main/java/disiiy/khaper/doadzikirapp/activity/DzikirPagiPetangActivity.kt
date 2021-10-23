package disiiy.khaper.doadzikirapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import disiiy.khaper.doadzikirapp.MainActivity
import disiiy.khaper.doadzikirapp.R
import disiiy.khaper.doadzikirapp.databinding.ActivityDzikirPagiPetangBinding
import disiiy.khaper.doadzikirapp.model.DzikirDoa

class DzikirPagiPetangActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var pagiPetangBinding: ActivityDzikirPagiPetangBinding
    private var listDikirDoa : ArrayList<DzikirDoa> = arrayListOf()

    companion object{
        fun getLaunchService(from : Context) = Intent(from, DzikirPagiPetangActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pagiPetangBinding = ActivityDzikirPagiPetangBinding.inflate(layoutInflater)
        setContentView(pagiPetangBinding.root)
        supportActionBar?.hide()

        pagiPetangBinding.ivDzikirPagi.setOnClickListener(this)
        pagiPetangBinding.ivDzikirPetang.setOnClickListener(this)
        pagiPetangBinding.ivBackDzikirPagiPetang.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.ivDzikirPagi -> startActivity(PagiActivity.getLaunchService(this))
            R.id.ivDzikirPetang -> startActivity(PetangActivity.getLaunchService(this))
            R.id.ivBackDzikirPagiPetang -> startActivity(MainActivity.getLaunchService(this))
        }
    }
}