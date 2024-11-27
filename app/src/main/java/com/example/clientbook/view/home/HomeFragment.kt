package com.example.clientbook.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.clientbook.R
import com.example.clientbook.databinding.FragmentHomeBinding
import com.example.clientbook.model.Carousel
import com.example.clientbook.model.Product
import java.util.UUID


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val carouselAdapter = CarouselAdapter()
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
    }

    private fun setupCarousel(){

        val imageRV = binding.rvCarousel

        val imageList = arrayListOf(
            Carousel(
                UUID.randomUUID().toString(),
                "PRIMEIRA",
                "https://i.postimg.cc/Vdbzgg06/banner1.jpg"
            ),
            Carousel(
                UUID.randomUUID().toString(),
                "segunda",
                "https://i.postimg.cc/cJ4pdXL8/banner2.jpg"
            ),
            Carousel(
                UUID.randomUUID().toString(),
                "terceira",
                "https://i.postimg.cc/PxvFqcsN/banner3.jpg"
            ),
        )

        val imageAdapter = CarouselAdapter()
        imageRV.adapter = imageAdapter
        imageAdapter.submitList(imageList)
    }

    private fun setupBestSale(){
        val rvBestSale = binding.rvBestSale

        val productList = arrayListOf(
            Product(
                UUID.randomUUID().toString(),
                "Produto 1",
                "Detalhes do produto",
                "Tipo A",
                100.00,
                true
            ),
            Product(
                UUID.randomUUID().toString(),
                "Produto 2",
                "Detalhes do produto",
                "Tipo B",
                70.00,
                false
            ),
            Product(
                UUID.randomUUID().toString(),
                "Produto 3",
                "Detalhes do produto",
                "Tipo 5",
                150.00,
                true
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

//    @Override
//    override //For Fragments.
//     fun onCreateOptionsMenu (menu:Menu, inflater:MenuInflater){
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.menu_cart, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.getItemId()) {
//            R.id.idCard -> {
//                Toast.makeText(requireContext(), "Carrinho", Toast.LENGTH_SHORT).show()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}