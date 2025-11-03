package lat.pam.hayangjajan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView
import lat.pam.hayangjajan.databinding.FragmentHomeBinding
import lat.pam.hayangjajan.databinding.ItemMenuAlusBinding
import lat.pam.hayangjajan.databinding.ItemMenuRameBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Adapter
    private lateinit var menuAlusAdapter: MenuAlusAdapter
    private lateinit var menuRameAdapter: MenuRameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMenuAlus()
        setupMenuRame()
    }

    private fun setupMenuAlus() {
        // 1. Siapkan data dummy
        val dummyData = listOf(
            MenuAlusItem("Martabak", R.drawable.martabak_full, R.color.app_category_martabak_bg),
            MenuAlusItem("Seblak", R.drawable.seblak, R.color.app_category_seblak_bg),
            MenuAlusItem("Basreng", R.drawable.basreng, R.color.app_category_basreng_bg),
            MenuAlusItem("Makaroni", R.drawable.makaroni, R.color.app_category_makaroni_bg),
            MenuAlusItem("Matcha", R.drawable.matcha, R.color.app_category_matcha_bg),
            MenuAlusItem("Kopi Susu", R.drawable.kopi_susu, R.color.app_category_martabak_bg)
        )

        // 2. Buat adapter
        menuAlusAdapter = MenuAlusAdapter(dummyData)

        // 3. Setup RecyclerView
        binding.rvMenuAlus.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = menuAlusAdapter
        }
    }

    private fun setupMenuRame() {
        // 1. Siapkan data dummy
        val dummyData = listOf(
            MenuRameItem("Batagor", "Gurih & Pedas", R.drawable.batagor),
            MenuRameItem("Cimol", "Kenyeol Raos Pisan", R.drawable.cimol),
            MenuRameItem("Cireng", "Dicocol Saos Nikmat", R.drawable.cireng),
            MenuRameItem("Kelapa Muda", "Seger Pisan Euy", R.drawable.kelapa_muda),
            MenuRameItem("Es Cendol", "Haus Ilang & Perut Kenyang", R.drawable.cendol)
        )

        // 2. Buat adapter
        menuRameAdapter = MenuRameAdapter(dummyData)

        // 3. Setup RecyclerView
        binding.rvMenuRame.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = menuRameAdapter
            isNestedScrollingEnabled = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // --- INNER CLASS UNTUK DATA ---
    data class MenuAlusItem(
        val name: String,
        val imageResId: Int,
        val colorResId: Int
    )

    data class MenuRameItem(
        val name: String,
        val description: String,
        val imageResId: Int
    )

    // --- INNER CLASS UNTUK ADAPTER "MENU ALUS" ---
    inner class MenuAlusAdapter(private val items: List<MenuAlusItem>) :
        RecyclerView.Adapter<MenuAlusAdapter.ViewHolder>() {

        inner class ViewHolder(binding: ItemMenuAlusBinding) : RecyclerView.ViewHolder(binding.root) {
            val card: MaterialCardView = binding.cardCategoryRoot
            val image: ImageView = binding.imgCategory
            val name: TextView = binding.tvCategoryName
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemMenuAlusBinding.inflate(
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
            holder.image.setImageResource(item.imageResId)

            val color = ContextCompat.getColor(holder.itemView.context, item.colorResId)
            holder.card.setCardBackgroundColor(color)

            // --- PERUBAHAN DI SINI ---
            holder.itemView.setOnClickListener {
                // Navigasi ke Halaman Detail
                // (Nanti kita bisa kirim ID produk, misal item.id)
                findNavController().navigate(R.id.action_homeFragment_to_detailProdukFragment)
            }
        }
    }

    // --- INNER CLASS UNTUK ADAPTER "MENU RAME" ---
    inner class MenuRameAdapter(private val items: List<MenuRameItem>) :
        RecyclerView.Adapter<MenuRameAdapter.ViewHolder>() {

        inner class ViewHolder(binding: ItemMenuRameBinding) : RecyclerView.ViewHolder(binding.root) {
            val image: ShapeableImageView = binding.imgMenu
            val name: TextView = binding.tvMenuName
            val description: TextView = binding.tvMenuDesc
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemMenuRameBinding.inflate(
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
            holder.description.text = item.description
            holder.image.setImageResource(item.imageResId)

            // --- PERUBAHAN DI SINI ---
            holder.itemView.setOnClickListener {
                // Navigasi ke Halaman Detail
                findNavController().navigate(R.id.action_homeFragment_to_detailProdukFragment)
            }
        }
    }
}