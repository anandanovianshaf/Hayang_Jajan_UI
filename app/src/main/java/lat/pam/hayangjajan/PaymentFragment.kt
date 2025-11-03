package lat.pam.hayangjajan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.google.android.material.card.MaterialCardView
import lat.pam.hayangjajan.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    private var _binding: FragmentPaymentBinding? = null
    private val binding get() = _binding!!

    private var selectedPaymentCard: MaterialCardView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi: Pilih QRIS sebagai default
        selectedPaymentCard = binding.cardQris

        setupListeners()
    }

    private fun setupListeners() {
        // Tombol Close (X)
        binding.btnClosePayment.setOnClickListener {
            // Kembali ke halaman sebelumnya (AddressFragment)
            findNavController().popBackStack()
        }

        // --- Logika Pemilihan Kartu ---
        binding.cardQris.setOnClickListener { selectPaymentMethod(binding.cardQris) }
        binding.cardBank.setOnClickListener { selectPaymentMethod(binding.cardBank) }
        binding.cardCod.setOnClickListener { selectPaymentMethod(binding.cardCod) }
        binding.cardDana.setOnClickListener { selectPaymentMethod(binding.cardDana) }

        // Tombol Bayar
        binding.btnBayar.setOnClickListener {
            Toast.makeText(context, "Pesanan Berhasil! Gasskeun!", Toast.LENGTH_LONG).show()

            // Selesaikan alur checkout dan kembali ke Home.
            // Kita hapus semua halaman (Cart, Address, Payment) dari tumpukan (back stack)
            val navOptions = navOptions {
                popUpTo(R.id.homeFragment) {
                    inclusive = true
                }
            }
            // Navigasi ke Home
            findNavController().navigate(R.id.homeFragment, null, navOptions)
        }
    }

    private fun selectPaymentMethod(card: MaterialCardView) {
        // 1. Reset kartu yang dipilih sebelumnya
        selectedPaymentCard?.strokeWidth = 1
        // Gunakan ContextCompat untuk kompatibilitas
        selectedPaymentCard?.strokeColor = requireContext().getColor(R.color.app_pink_light)

        // 2. Set kartu baru yang dipilih
        card.strokeWidth = 2
        card.strokeColor = requireContext().getColor(R.color.app_pink_primary)

        // 3. Simpan referensi
        selectedPaymentCard = card
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}