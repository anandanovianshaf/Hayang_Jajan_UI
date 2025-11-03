package lat.pam.hayangjajan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lat.pam.hayangjajan.databinding.FragmentAddressBinding

class AddressFragment : Fragment() {

    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        // Tombol Close (X)
        binding.btnCloseAddress.setOnClickListener {
            // Kembali ke halaman sebelumnya (CartFragment)
            findNavController().popBackStack()
        }

        // Tombol Kirim Alamat
        binding.btnKirimAlamat.setOnClickListener {
            // (Nanti di sini kita validasi dulu form-nya)

            // Navigasi ke halaman Payment (Step 3)
            // ID action ini sudah kita buat di nav_graph.xml
            findNavController().navigate(R.id.action_addressFragment_to_paymentFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}