package com.example.lonelymountainfragments.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.lonelymountainfragments.R
import com.example.lonelymountainfragments.databinding.FragmentPasswordBinding

class PasswordFragment: Fragment() {

    private var _binding: FragmentPasswordBinding? = null
    private val binding: FragmentPasswordBinding get() = _binding!!

    var firstName = ""
    var lastName = ""
    var emailInfo = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            passwordEt.editText?.addTextChangedListener { text ->
                nextBtn.isEnabled = text.toString().length > 1

                firstName = arguments?.getString(FIRST) ?: "First"
                lastName = arguments?.getString(LAST) ?: "Last"
                emailInfo = arguments?.getString(EMAIL) ?: "Email"
            }

            nextBtn.setOnClickListener {

                val bundle = Bundle()

                bundle.putString(FIRST, firstName)
                bundle.putString(LAST, lastName)
                bundle.putString(EMAIL, emailInfo)
                bundle.putString(PASSWORD, passwordEt.editText?.text.toString())

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, InfoFragment::class.java, bundle)
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