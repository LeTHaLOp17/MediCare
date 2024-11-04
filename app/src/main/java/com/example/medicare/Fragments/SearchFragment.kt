package com.example.medicare.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicare.R
import com.example.medicare.adapter.AllMedicines
import com.example.medicare.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment with ViewBinding
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data lists
        val medicinesName = listOf("Saridon Advance Tablet for 5 in 1 Pain Relief", "PCM", "Condom")
        val mrpPrice = listOf("50", "20", "10")
        val medicineImages = listOf(R.drawable.saridonimg, R.drawable.doc, R.drawable.dia)
        val offPrice = listOf("32", "10", "5")
        val offPercent = listOf("4", "2", "3")
        val companyName = listOf("Bayer Pharmaceuticals Pvt Ltd", "Pfizer", "Cipla")
        val quantity = listOf("strip of 10.0 tablets", "strip of 8.0 tablets", "box of 2")
        val expiryDate = listOf(
            "Expires on or after: January, 2026",
            "Expires on or after: January, 2026",
            "Expires on or after: January, 2026"
        )

        // Adapter setup
        val adapter = AllMedicines(
            medicinesName, companyName, expiryDate, offPercent, mrpPrice, quantity, offPrice, medicineImages
        )

        binding.medicineslists.layoutManager = LinearLayoutManager(requireContext())
        binding.medicineslists.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}
