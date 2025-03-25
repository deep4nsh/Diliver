package deedev.diliver.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import deedev.diliver.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainFoodNames: ArrayList<String>,
    private val buyAgainFoodPrice: ArrayList<String>,
    private val buyAgainFoodImage: ArrayList<Int>): RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(buyAgainFoodNames[position],buyAgainFoodPrice[position],buyAgainFoodImage[position])

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding=BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun getItemCount(): Int=buyAgainFoodNames.size
    class BuyAgainViewHolder(private val binding: BuyAgainItemBinding): RecyclerView.ViewHolder
        (binding.root) {
        fun bind(
            foodName: String,
            foodPrice: String,
            foodImage: Int
        ) {
            binding.buyAgainFoodName.text=foodName
            binding.buyAgainFoodPrice.text=foodPrice
            binding.buyAgainFoodImage.setImageResource(foodImage)
            binding.buyAgainFoodButton.setOnClickListener {

            }
        }
    }
}


