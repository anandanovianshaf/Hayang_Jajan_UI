package lat.pam.hayangjajan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lat.pam.hayangjajan.databinding.FragmentLoginBinding // Ganti dengan ...LoginBinding

class LoginFragment : Fragment() {

    // Deklarasikan variabel binding
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout menggunakan View Binding
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Logika Tombol 1: Log In
        binding.btnLogin.setOnClickListener {
            // Pindah ke Home.
            // (Kita hapus 'Login' dari histori agar tombol Back tidak kembali ke sini)
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        // Logika Tombol 2: Sign Up
        binding.btnSignup.setOnClickListener {
            // Pindah ke Sign Up.
            // (Kita tidak hapus 'Login', agar pengguna bisa 'Back' dari Sign Up)
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Hindari memory leak dengan membersihkan binding
        _binding = null
    }
}