package com.farhanryanda.tugaskelompoksharedpref.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.farhanryanda.tugaskelompoksharedpref.R
import com.farhanryanda.tugaskelompoksharedpref.databinding.FragmentHomeBinding
import com.farhanryanda.tugaskelompoksharedpref.databinding.FragmentLoginBinding
import com.farhanryanda.tugaskelompoksharedpref.databinding.FragmentRegisterBinding

class HomeFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().applicationContext.getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.tvFullname.text = "Hello " + sharedPreferences.getString("fullname","")
        binding.btnLogout.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            Toast.makeText(activity, "Berhasil Logout", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }

}