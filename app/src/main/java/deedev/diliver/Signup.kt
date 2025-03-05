package deedev.diliver

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import deedev.diliver.databinding.ActivitySignupBinding

class Signup: AppCompatActivity() {
    private val binding: ActivitySignupBinding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.haveAccountText.setOnClickListener {
            val intent= Intent(this,LoginPage::class.java)
            startActivity(intent)
            finish()
        }

    }
}