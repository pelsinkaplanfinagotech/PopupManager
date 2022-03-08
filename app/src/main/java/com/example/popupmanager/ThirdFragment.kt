package com.example.popupmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.popupmanager.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    private lateinit var customPopUp: PopupManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        customPopUp = PopupManager(requireContext())
        val buttonList = listOf(Button("First", 1), Button("Second", 2), Button("Third", 3))
        val response = Response(
            "Üçüncü Fragment",
            "Content yazısı biraz daha uzun olsun, bir de böyleli deneyelim bakalım.",
            buttonList
        )
        customPopUp.setPopup(response, requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}