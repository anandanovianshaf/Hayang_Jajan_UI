package lat.pam.hayangjajan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lat.pam.hayangjajan.databinding.FragmentSignUpBinding // Pastikan nama ini benar

class SignUpFragment : Fragment() {

    // Deklarasikan variabel binding
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout menggunakan View Binding
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Logika Tombol 1: Sign Up
        binding.btnSignup.setOnClickListener {
            // Untuk saat ini, kita navigasi kembali ke Login saja
            // (Anda bisa ubah ini ke Home nanti)
            findNavController().popBackStack()
        }

        // PERUBAHAN DI SINI:
        // Click listener sekarang dipasang ke 'tvPrompt2Login'
        binding.tvPrompt2Login.setOnClickListener {
            // Kembali ke halaman Login (Fragment sebelumnya)
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hindari memory leak dengan membersihkan binding
        _binding = null
    }
}