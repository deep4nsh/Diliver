package deedev.diliver.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import deedev.diliver.databinding.CartItemBinding
import deedev.diliver.databinding.CartItemBinding.*

class CartAdapter(
    private val CartItems: MutableList<String>,
    private val CartItemPrice: MutableList<String>,
    private var CartImage: MutableList<Int>):
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

private val itemQuantities = IntArray(CartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
    val binding= inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)

    }

    override fun getItemCount(): Int = CartItems.size
    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartFoodName.text = CartItems[position]
                cartItemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemQuantity.text = quantity.toString()

                minusButton.setOnClickListener {
                    decreaseQuantity(position)
                }
                plusButton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    it.playSoundEffect(android.view.SoundEffectConstants.CLICK)
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(itemPosition)
                    }
                    }
                }
            }
    private fun increaseQuantity(position: Int) {
        if (itemQuantities[position] < 10) {
            itemQuantities[position]++
            binding.cartItemQuantity.text = itemQuantities[position].toString()
        }
    }
    private fun decreaseQuantity(position: Int) {
        if (itemQuantities[position] > 1) {
            itemQuantities[position]--
            binding.cartItemQuantity.text = itemQuantities[position].toString()
        }
    }
        private fun deleteItem(position: Int) {
            CartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, CartItems.size)
        }
    }
}