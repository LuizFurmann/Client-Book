package com.example.clientbook.view.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clientbook.R
import com.example.clientbook.databinding.FragmentHomeBinding
import com.example.clientbook.model.Carousel
import com.example.clientbook.model.Product
import com.example.clientbook.view.cart.CartActivity
import java.util.UUID

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val bestSaleAdapter = BestSaleAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true);
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCarousel()
        setupBestSale()

        binding.btnCart.setOnClickListener {
            Intent(requireContext(), CartActivity::class.java).also{
                startActivity(it)
            }
        }
    }

    private fun setupCarousel(){

        val imageRV = binding.rvCarousel

        val imageList = arrayListOf(
            Carousel(
                UUID.randomUUID().toString(),
                "PRIMEIRA",
                R.drawable.banner1
            ),
            Carousel(
                UUID.randomUUID().toString(),
                "segunda",
                R.drawable.banner2
            ),
        )

        val imageAdapter = CarouselAdapter()
        imageRV.adapter = imageAdapter
        imageAdapter.submitList(imageList)
    }

    private fun setupBestSale(){

        val productList = arrayListOf(
            Product(
                UUID.randomUUID().toString(),
                "Camiseta feminina",
                "Detalhes do produto",
                "Tipo A",
                100.00,
                true
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
                true
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
                130.99,
                false
            ),
            Product(
                UUID.randomUUID().toString(),
                "Camisa masculina cinza",
                "Detalhes do produto",
                "Tipo 5",
                130.99,
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
            //TODO image to empty list
        } else {

            bestSaleAdapter.updateList(productList)
        }
    }
}