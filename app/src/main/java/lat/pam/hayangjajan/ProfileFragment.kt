package lat.pam.hayangjajan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import lat.pam.hayangjajan.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        // --- 1. Logika untuk Toast Notifikasi (Sesuai Permintaan) ---

        // Klik tombol Edit Profil
        binding.btnEditProfil.setOnClickListener {
            Toast.makeText(context, getString(R.string.profile_toast_edit_profil), Toast.LENGTH_SHORT).show()
        }

        // Klik panah Alamat
        binding.arrowAlamat.setOnClickListener {
            Toast.makeText(context, getString(R.string.profile_toast_edit_alamat), Toast.LENGTH_SHORT).show()
        }

        // Klik panah Handphone
        binding.arrowHandphone.setOnClickListener {
            Toast.makeText(context, getString(R.string.profile_toast_edit_phone), Toast.LENGTH_SHORT).show()
        }

        // Klik panah Email
        binding.arrowEmail.setOnClickListener {
            Toast.makeText(context, getString(R.string.profile_toast_edit_email), Toast.LENGTH_SHORT).show()
        }

        // (Anda bisa tambahkan listener lain untuk My Payment atau Notifikasi di sini)
        binding.btnMyPayment.setOnClickListener {
            Toast.makeText(context, "Fitur 'My Payment' belum tersedia", Toast.LENGTH_SHORT).show()
        }

        binding.btnNotification.setOnClickListener {
            Toast.makeText(context, "Tidak ada notifikasi baru", Toast.LENGTH_SHORT).show()
        }


        // --- 2. Logika Tombol Log Out (Sesuai Permintaan) ---
        binding.btnLogOut.setOnClickListener {
            // Tampilkan pesan
            Toast.makeText(context, "Anda telah Log Out", Toast.LENGTH_LONG).show()

            // Siapkan opsi navigasi untuk "membersihkan" tumpukan (back stack)
            val navOptions = navOptions {
                popUpTo(R.id.nav_graph) { // Hapus SEMUA fragment di back stack
                    inclusive = true
                }
            }

            // Navigasi kembali ke halaman paling awal (Splash Screen)
            findNavController().navigate(R.id.splashFragment, null, navOptions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}