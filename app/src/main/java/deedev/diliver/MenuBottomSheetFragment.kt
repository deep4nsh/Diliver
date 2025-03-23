package deedev.diliver

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import deedev.diliver.adapter.MenuAdapter
import deedev.diliver.databinding.FragmentMenuBottomSheetBinding

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }

        val menuFoodName= listOf("Pizza","Burger","Sandwich","momo")
        val menuItemPrice= listOf("300Rs.","100Rs.","70Rs.","200Rs.")
        val cartImage= listOf(
            R.drawable.pizza_image,
            R.drawable.burger,
            R.drawable.sandwich,
            R.drawable.momo)
        val adapter= MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(cartImage))
        binding.menuRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter
        return binding.root
    }
    companion object{

    }


}