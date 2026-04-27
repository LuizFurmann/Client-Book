package com.example.clientbook.view.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clientbook.R
import com.example.clientbook.databinding.FragmentFavoriteBinding
import com.example.clientbook.model.Product
import com.example.clientbook.view.home.BestSaleAdapter
import java.util.UUID

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val bestSaleAdapter = BestSaleAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBestSale()
    }

    private fun setupBestSale(){
        val rvBestSale = binding.rvBestSale

        val productList = arrayListOf(
            Product(
                UUID.randomUUID().toString(),
                "Camiseta feminina",
                "Detalhes do produto",
                "Tipo A",
                100.00,
                false
            ),
            Product(
                UUID.randomUUID().toString(),
                "Camiseta masculina",
                "Detalhes do produto",
                "Tipo B",
                70.00,
                false
            ),
            Product(
                UUID.randomUUID().toString(),
                "Chapéu de praia",
                "Detalhes do produto",
                "Tipo 5",
                50.00,
                false
            ),
            Product(
                UUID.randomUUID().toString(),
                "Calça jeans feminina",
                "Detalhes do produto",
                "Tipo 5",
                130.99,
                false
            ),
            Product(
                UUID.randomUUID().toString(),
                "Camisa masculina",
                "Detalhes do produto",
                "Tipo 5",
                120.99,
                false
            ),
        )

        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvBestSale.layoutManager = layoutManager;
        binding.rvBestSale.adapter = bestSaleAdapter
        binding.rvBestSale.setHasFixedSize(true)

        updateList(productList)
    }

    private fun updateList(productList: List<Product>) {
        if (productList.isEmpty()) {

//            binding.rvExercise.visibility = View.GONE
//            binding.myExercisesTittle.visibility = View.GONE
//            binding.emptyExerciseList.visibility = View.VISIBLE
        } else {

            bestSaleAdapter.updateList(productList)
        }
    }
}