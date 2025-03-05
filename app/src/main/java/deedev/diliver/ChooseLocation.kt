package deedev.diliver

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import deedev.diliver.databinding.ActivityChooseLocationBinding
import kotlinx.coroutines.selects.select

class ChooseLocation : AppCompatActivity() {
    private val binding: ActivityChooseLocationBinding by lazy {
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val locations = arrayOf(
            "Choose Location",
            "Ahmedabad",
            "Bengaluru",
            "Bhopal",
            "Bhubaneswar",
            "Chandigarh",
            "Chennai",
            "Coimbatore",
            "Dehradun",
            "Delhi",
            "Faridabad",
            "Ghaziabad",
            "Gurugram",
            "Guwahati",
            "Hyderabad",
            "Indore",
            "Jaipur",
            "Jalandhar",
            "Jammu",
            "Jodhpur",
            "Kanpur",
            "Kochi",
            "Kolkata",
            "Lucknow",
            "Ludhiana",
            "Madurai",
            "Mumbai",
            "Nagpur",
            "Nashik",
            "Noida",
            "Patna",
            "Pune",
            "Raipur",
            "Rajkot",
            "Ranchi",
            "Srinagar",
            "Surat",
            "Thiruvananthapuram",
            "Udaipur",
            "Vadodara",
            "Varanasi",
            "Visakhapatnam"
        )
        val spinnerAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, locations)
        spinnerAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.locationSpinner.adapter = spinnerAdapter

        binding.chooseLocButton.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}