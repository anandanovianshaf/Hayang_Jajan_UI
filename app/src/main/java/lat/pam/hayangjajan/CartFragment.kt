package lat.pam.hayangjajan

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import lat.pam.hayangjajan.databinding.FragmentCartBinding
import lat.pam.hayangjajan.databinding.ItemCartBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private lateinit var cartAdapter: CartAdapter
    private val dummyCartItems = mutableListOf<CartItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupDummyData()
        setupRecyclerView()
        setupListeners()
        updateTotalPrice()
    }

    private fun setupDummyData() {
        // Kita buat data dummy (nanti ini akan jadi data asli)
        dummyCartItems.clear()
        dummyCartItems.add(CartItem(1, "Martabak", 66000, 3, R.drawable.martabak))
        dummyCartItems.add(CartItem(2, "Seblak", 15000, 1, R.drawable.seblak))
        dummyCartItems.add(CartItem(3, "Basreng", 10000, 3, R.drawable.basreng))
        dummyCartItems.add(CartItem(4, "Matcha", 12250, 4, R.drawable.matcha))
    }

    private fun setupRecyclerView() {
        cartAdapter = CartAdapter(dummyCartItems)
        binding.rvCartItems.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cartAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupListeners() {
        // Tombol Close
        binding.btnCloseCart.setOnClickListener {
            // Kembali ke fragment sebelumnya (misal Home)
            findNavController().popBackStack()
        }

        // Tombol Clear All
        binding.tvClearAll.setOnClickListener {
            dummyCartItems.clear()
            cartAdapter.notifyDataSetChanged()
            updateTotalPrice()
            Toast.makeText(context, "Keranjang dibersihkan", Toast.LENGTH_SHORT).show()
        }

        // Tombol Lanjut Beli
        binding.btnLanjutBeli.setOnClickListener {
            // Navigasi ke Halaman Alamat (Step 2)
            findNavController().navigate(R.id.action_cartFragment_to_addressFragment)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateTotalPrice() {
        var totalPrice = 0
        dummyCartItems.forEach { item ->
            totalPrice += (item.price * item.quantity)
        }
        binding.btnLanjutBeli.text = "Lanjut Beli   Rp $totalPrice"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // --- INNER CLASS UNTUK DATA & ADAPTER ---
    data class CartItem(
        val id: Int,
        val name: String,
        val price: Int,
        var quantity: Int,
        val imageResId: Int
    )

    inner class CartAdapter(private val cartList: MutableList<CartItem>) :
        RecyclerView.Adapter<CartAdapter.ViewHolder>() {

        inner class ViewHolder(binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root) {
            val image: ShapeableImageView = binding.imgCartItem
            val name: TextView = binding.tvCartItemName
            val price: TextView = binding.tvCartItemPrice
            val quantity: TextView = binding.tvCartQuantity
            val btnRemove: ImageButton = binding.btnCartRemove
            val btnAdd: ImageButton = binding.btnCartAdd
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemCartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun getItemCount(): Int = cartList.size

        @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = cartList[position]

            holder.image.setImageResource(item.imageResId)
            holder.name.text = item.name
            holder.price.text = "Rp ${item.price}"
            holder.quantity.text = item.quantity.toString()

            // Listener untuk tombol minus
            holder.btnRemove.setOnClickListener {
                if (item.quantity > 1) {
                    item.quantity--
                    holder.quantity.text = item.quantity.toString()
                } else {
                    // Jika kuantitas jadi 0, hapus item dari list
                    cartList.removeAt(position)
                    notifyDataSetChanged()
                }
                updateTotalPrice()
            }

            // Listener untuk tombol plus
            holder.btnAdd.setOnClickListener {
                item.quantity++
                holder.quantity.text = item.quantity.toString()
                updateTotalPrice()
            }
        }
    }
}