package com.farhanryanda.tugaskelompoksharedpref.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.farhanryanda.tugaskelompoksharedpref.R
import com.farhanryanda.tugaskelompoksharedpref.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().applicationContext.getSharedPreferences("datauser",Context.MODE_PRIVATE)
        binding.btnRegister.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val fullname = binding.edtFullname.text.toString()
            val password = binding.edtPassword.text.toString()
            val repeatpassword = binding.edtRepeatPassword.text.toString()
            var addData = sharedPreferences.edit()

            if (password == repeatpassword) {
                addData.putString("username",username)
                addData.putString("fullname",fullname)
                addData.putString("password",password)
                addData.apply()
                it.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                Toast.makeText(activity, "Register Berhasil", Toast.LENGTH_SHORT).show()
            } else if (password != repeatpassword) {
                Toast.makeText(activity, "Password Tidak Sama", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            it.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

}