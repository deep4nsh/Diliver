package deedev.diliver

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import deedev.diliver.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    private val binding: ActivityLoginPageBinding by lazy {
        ActivityLoginPageBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // optional for edge-to-edge display
        setContentView(binding.root)
        binding.noAccountText.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
            finish() // Finish this activity to prevent users from navigating back to it
        }
        binding.loginButtonLogin.setOnClickListener {
            val intent = Intent(this, ChooseLocation::class.java)
            startActivity(intent)
            finish() // Finish this activity to prevent users from navigating back to it
        }
    }
}
