package lat.pam.hayangjajan

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lat.pam.hayangjajan.databinding.FragmentDetailProdukBinding
import lat.pam.hayangjajan.databinding.ItemAddOnBinding

class DetailProdukFragment : Fragment() {

    private var _binding: FragmentDetailProdukBinding? = null
    private val binding get() = _binding!!

    private var currentQuantity = 1
    private var basePrice = 66000 // Harga dummy

    private lateinit var addOnAdapter: AddOnAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailProdukBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
        setupAddOnRecyclerView()
        updatePrice()
    }

    private fun setupListeners() {
        // Tombol Close
        binding.btnClose.setOnClickListener {
            findNavController().popBackStack()
        }

        // Tombol Kurangi Kuantitas
        binding.btnRemoveQuantity.setOnClickListener {
            if (currentQuantity > 1) {
                currentQuantity--
                updateQuantityAndPrice()
            }
        }

        // Tombol Tambah Kuantitas
        binding.btnAddQuantity.setOnClickListener {
            currentQuantity++
            updateQuantityAndPrice()
        }

        // Tombol Add to Cart
        binding.btnAddToCart.setOnClickListener {
            Toast.makeText(context, "$currentQuantity item ditambahkan", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.cartFragment)
        }
    }

    private fun updateQuantityAndPrice() {
        binding.tvQuantity.text = currentQuantity.toString()
        updatePrice()
    }

    @SuppressLint("SetTextI18n")
    private fun updatePrice() {
        val totalPrice = basePrice * currentQuantity
        binding.btnAddToCart.text = "Add to Cart\nRp $totalPrice"
    }

    private fun setupAddOnRecyclerView() {
        // --- PERUBAHAN DI SINI ---
        val addOnData = listOf(
            AddOnItem("Keju", "+ Rp 3.000", R.drawable.keju),
            AddOnItem("Strawberry", "+ Rp 3.000", R.drawable.strawberry_jam),
            AddOnItem("Onion", "+ Rp 3.000", R.drawable.blueberry_jam) // <-- Harga sudah diubah
        )
        // --- BATAS PERUBAHAN ---

        addOnAdapter = AddOnAdapter(addOnData)
        binding.rvAddOns.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = addOnAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // --- INNER CLASS UNTUK DATA & ADAPTER ADD-ON ---
    data class AddOnItem(
        val name: String,
        val price: String,
        val imageResId: Int
    )

    inner class AddOnAdapter(private val items: List<AddOnItem>) :
        RecyclerView.Adapter<AddOnAdapter.ViewHolder>() {

        inner class ViewHolder(binding: ItemAddOnBinding) : RecyclerView.ViewHolder(binding.root) {
            val image: ImageView = binding.imgAddOn
            val name: TextView = binding.tvAddOnName
            val price: TextView = binding.tvAddOnPrice
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemAddOnBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            holder.name.text = item.name
            holder.price.text = item.price
            holder.image.setImageResource(item.imageResId)
        }
    }
}