package deedev.diliver.adapter

import androidx.recyclerview.widget.RecyclerView

class BuyAgainAdapter(private val buyAgainFoodNames: ArrayList<String>,
    private val buyAgainFoodPrice: ArrayList<String>,
    private val buyAgainFoodImage: ArrayList<Int>): RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {
    annotation class BuyAgainViewHolder

}