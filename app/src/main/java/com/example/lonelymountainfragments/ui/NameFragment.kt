package com.example.lonelymountainfragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.lonelymountainfragments.R
import com.example.lonelymountainfragments.databinding.FragmentNameBinding

class NameFragment: Fragment() {

    private var _binding: FragmentNameBinding? = null
    private val binding: FragmentNameBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            firstNameEt.editText?.addTextChangedListener { text ->
                nextBtn.isEnabled = text.toString().length > 8
            }

            nextBtn.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(FIRST_EXTRA, firstNameEt.editText?.text.toString())
                bundle.putString(LAST_EXTRA, lastNameEt.editText?.text.toString())

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, EmailFragment::class.java, bundle)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}