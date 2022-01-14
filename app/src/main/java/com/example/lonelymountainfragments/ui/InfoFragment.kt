package com.example.lonelymountainfragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lonelymountainfragments.databinding.FragmentInfoBinding

class InfoFragment: Fragment() {

        private var _binding: FragmentInfoBinding? = null
        private val binding: FragmentInfoBinding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentInfoBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            with(binding) {
                firstNameTv.text = arguments?.getString("First") ?: "First"
                lastNameTv.text = arguments?.getString("Last") ?: "Last"
                emailTv.text = arguments?.getString("Email") ?: "Email"
                passwordTv.text = arguments?.getString("Password") ?: "Password"
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

    }
