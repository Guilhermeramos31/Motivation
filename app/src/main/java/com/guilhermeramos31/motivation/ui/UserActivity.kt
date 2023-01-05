package com.guilhermeramos31.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.guilhermeramos31.motivation.R
import com.guilhermeramos31.motivation.infra.SecurityPreferences
import com.guilhermeramos31.motivation.databinding.ActivityUserBinding
import com.guilhermeramos31.motivation.infra.MotivationConstants

class UserActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserBinding
    private lateinit var securityPreferences: SecurityPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        securityPreferences = SecurityPreferences(this)
        binding.buttonSave.setOnClickListener(this)

        verifyUserName()
    }

    private fun verifyUserName() {
        val name = securityPreferences.getString(MotivationConstants.KEY.USER_NAME)
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }


    private fun handleSave() {

        val name: String = binding.editYourName.text.toString()
        if (name == "") {
            Toast.makeText(this, getString(R.string.validation_mandatory_name), Toast.LENGTH_LONG)
                .show()
        } else {
            securityPreferences.storeString(MotivationConstants.KEY.USER_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onClick(view: View?) {
        val id: Int? = view?.id
        if (id == R.id.button_save) {
            handleSave()
        }
    }

}