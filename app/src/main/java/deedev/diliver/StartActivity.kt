package deedev.diliver

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class StartActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val nextButton: AppCompatButton=findViewById(R.id.nextButtonStart)
        nextButton.setOnClickListener{
            val intent= Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish()
        }
    }




}