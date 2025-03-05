package deedev.diliver.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import deedev.diliver.R
import deedev.diliver.adapter.CartAdapter
import deedev.diliver.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding:FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName= listOf("Pizza","Burger","Sandwich","momo")
        val cartItemPrice= listOf("300Rs.","100Rs.","70Rs.","200Rs.")
        val cartImage= listOf(R.drawable.pizza_image,R.drawable.burger,R.drawable.sandwich,R.drawable.momo)
        val adapter= CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter=adapter
        return binding.root
    }


}