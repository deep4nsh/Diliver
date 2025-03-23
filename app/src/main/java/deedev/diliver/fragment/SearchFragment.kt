package deedev.diliver.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.common.collect.Multimaps.index
import deedev.diliver.R
import deedev.diliver.adapter.MenuAdapter
import deedev.diliver.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    private val originalMenuFoodNames=listOf("Pizza","Burger","Sandwich","Momo")
    private val originalMenuItemPrice= listOf("300Rs.","100Rs.","70Rs.","200Rs.")
    private val originalMenuImage= listOf(
        R.drawable.pizza_image,
        R.drawable.burger,
        R.drawable.sandwich,
        R.drawable.momo)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName= mutableListOf<String>()
    private val filteredMenuItemPrice= mutableListOf<String>()
    private val filteredMenuImage= mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSearchBinding.inflate(inflater, container, false)
        adapter= MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage)
        binding.menuRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter

        //show all menu items
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(originalMenuFoodNames)
        filteredMenuItemPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImage)

        adapter.notifyDataSetChanged()

    }


    //setup code for search view

        private fun setupSearchView() {
            binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    filterMenuItems(query)
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    filterMenuItems(newText)
                    return true
                }

            })
        }

        private fun filterMenuItems(query: String) {
            filteredMenuFoodName.clear()
            filteredMenuItemPrice.clear()
            filteredMenuImage.clear()

            originalMenuFoodNames.forEachIndexed { index, foodName ->
                    if(foodName.contains(query,ignoreCase = true)){
                        filteredMenuFoodName.add(foodName)
                        filteredMenuItemPrice.add(originalMenuItemPrice[index])
                        filteredMenuImage.add(originalMenuImage[index])
                    }
            }
            adapter.notifyDataSetChanged()


        }




        // Inflate the layout for this fragment


    companion object{

    }
}