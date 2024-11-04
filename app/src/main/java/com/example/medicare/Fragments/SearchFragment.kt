package com.example.medicare.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.medicare.R
import com.example.medicare.adapter.MedicineAdapter
import com.example.medicare.adapter.MedicineItem
import com.example.medicare.adapter.MedicineType
import com.example.medicare.databinding.FragmentSearchBinding
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.widget.SearchView // Ensure this import is correct


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var medicineAdapter: MedicineAdapter
    private var allMedicines: List<MedicineItem> = listOf() // Store all medicines

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        // Setup Search View
        setUpSearchView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        allMedicines = listOf(
            MedicineItem("Saridon Advance Tablet for 5 person", "Bayer Pharmaceuticals Pvt Ltd", "Expires on or after: Jan 2026", "4", "50", "strip of 10 tablets", "32", R.drawable.saridonimg, MedicineType.REGULAR),
            MedicineItem("PCM", "Pfizer", "Expires on or after: Jan 2026", "2", "20", "strip of 8 tablets", "10", R.drawable.doc, MedicineType.REGULAR),
            MedicineItem("Condom", "Cipla", "Expires on or after: Jan 2026", "3", "10", "box of 2", "5", R.drawable.dia, MedicineType.SPECIAL)
            // Add more items as needed
        )

        binding.medicineslists.layoutManager = LinearLayoutManager(requireContext())
        medicineAdapter = MedicineAdapter(allMedicines) { medicineItem ->
            val snackbar = Snackbar.make(binding.root, "You have to upload a photo of your prescription for purchasing ${medicineItem.name}.", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("OK") { snackbar.dismiss() } // Optional action
            snackbar.setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.red))
            snackbar.setActionTextColor(ContextCompat.getColor(requireContext(), R.color.yellow))
            snackbar.show()
        }
        binding.medicineslists.adapter = medicineAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpSearchView() {
        binding.searchBox.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMedicines(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMedicines(newText)
                return true
            }
        })
    }

    private fun filterMedicines(query: String?) {
        val filteredMedicines = if (query.isNullOrEmpty()) {
            allMedicines // Show all medicines if the query is empty
        } else {
            allMedicines.filter { medicineItem ->
                medicineItem.name.contains(query, ignoreCase = true) // Filter by medicine name
                medicineItem.company.contains(query, ignoreCase = true) // Filter by company name
            }
        }

        // Update the adapter with the filtered list
        medicineAdapter = MedicineAdapter(filteredMedicines) { medicineItem ->
            val snackbar = Snackbar.make(binding.root, "You have to upload a photo of your prescription for purchasing ${medicineItem.name}.", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("OK") { snackbar.dismiss() }
            snackbar.setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.red))
            snackbar.setActionTextColor(ContextCompat.getColor(requireContext(), R.color.yellow))
            snackbar.show()
        }
        binding.medicineslists.adapter = medicineAdapter // Update the RecyclerView
    }
}
