package com.farhanryanda.tugaskelompoksharedpref.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.farhanryanda.tugaskelompoksharedpref.R
import com.farhanryanda.tugaskelompoksharedpref.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = requireActivity().applicationContext.getSharedPreferences("datauser",
            Context.MODE_PRIVATE)

        Handler().postDelayed ({
            if (sharedPreferences.getString("username","") == "" && sharedPreferences.getString("password","") == ""){
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }else {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }

        }, 3000)
    }

}