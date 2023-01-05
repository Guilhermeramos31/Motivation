package com.guilhermeramos31.motivation.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.guilhermeramos31.motivation.infra.MotivationConstants
import com.guilhermeramos31.motivation.R
import com.guilhermeramos31.motivation.data.Mock
import com.guilhermeramos31.motivation.infra.SecurityPreferences
import com.guilhermeramos31.motivation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding: ActivityMainBinding
    private var categoryId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        handleUserName()
        handleFilter(R.id.image_all)
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageFace.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)


    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textHello.text = "Olá, $name!"
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase){
            binding.textPhrases.text = handleNewPhrase()
        } else if(view.id in listOf(R.id.image_all, R.id.image_face, R.id.image_sunny)){
            handleFilter(view.id)
        }
    }
    private fun handleNewPhrase(): String{
        val phrase = Mock.getPhrase(categoryId)
        return phrase
    }
    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
        binding.imageFace.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_face -> {
                binding.imageFace.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryId = MotivationConstants.FILTER.FACE
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }
}
