package deedev.diliver.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import deedev.diliver.R
import deedev.diliver.adapter.BuyAgainAdapter
import deedev.diliver.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setupRecyclerView()
        return (binding.root)
    }
    private fun setupRecyclerView() {
        val buyAgainFoodName = arrayListOf("Food 1","Food 2", "food 3")
        val buyAgainFoodPrice = arrayListOf("100 Rs.", "150 Rs.", "99 Rs.")
        val buyAgainFoodImage = arrayListOf(R.drawable.pizza_image, R.drawable.momo, R.drawable.burger)
        val buyAgainAdapter= BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
        binding.BuyAgainRecyclerView.adapter=buyAgainAdapter
        binding.BuyAgainRecyclerView.layoutManager= LinearLayoutManager(requireContext())
    }


}