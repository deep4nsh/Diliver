package deedev.diliver.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import deedev.diliver.R
import deedev.diliver.adapter.PopularAdapter
import deedev.diliver.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add images to the slider
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner_1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner_2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner_3, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner_4, ScaleTypes.FIT))

        // Configure the image slider
        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun doubleClick(position: Int) {
                // Handle double click (optional)
                Toast.makeText(requireContext(), "Image double-clicked at position: $position", Toast.LENGTH_SHORT).show()
            }

            override fun onItemSelected(position: Int) {
                val itemMessage = "Selected Image at position $position"
                Toast.makeText(requireContext(), itemMessage, Toast.LENGTH_SHORT).show()
            }
        })
        val foodName = listOf("Pizza","Burger","Sandwich","Momo")
        val price = listOf("300Rs.","200Rs.","300Rs.","200Rs.")
        val popularFoodImages = listOf(R.drawable.pizza_image,R.drawable.burger,R.drawable.sandwich,R.drawable.momo)
        val adapter = PopularAdapter(foodName,price,popularFoodImages)
        binding.PopularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.PopularRecyclerView.adapter = adapter

    }
}
