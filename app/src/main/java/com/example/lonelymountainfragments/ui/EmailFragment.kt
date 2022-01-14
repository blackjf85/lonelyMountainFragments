package com.example.lonelymountainfragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lonelymountainfragments.R
import com.example.lonelymountainfragments.databinding.FragmentEmailBinding

class EmailFragment: Fragment() {

    private var _binding: FragmentEmailBinding? = null
    private val binding: FragmentEmailBinding get() = _binding!!

    private var firstName = ""
    private var lastName = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            emailEt.editText?.addTextChangedListener { text ->
                nextBtn.isEnabled = text.toString().length > 1

                firstName = arguments?.getString("First") ?: "First"
                lastName = arguments?.getString("Last") ?: "Last"
            }

            nextBtn.setOnClickListener {
                val bundle = Bundle()

                bundle.putString("First", firstName)
                bundle.putString("Last", lastName)
                bundle.putString("Email", emailEt.editText?.text.toString())

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, PasswordFragment::class.java, bundle)
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