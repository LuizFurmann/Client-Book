package com.example.clientbook.view.purchase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clientbook.R
import com.example.clientbook.databinding.FragmentHomeBinding
import com.example.clientbook.databinding.FragmentPurchaseBinding
import com.example.clientbook.model.Carousel
import com.example.clientbook.model.Order
import com.example.clientbook.model.Product
import com.example.clientbook.view.home.BestSaleAdapter
import java.util.UUID

class PurchaseFragment : Fragment() {

    private var _binding: FragmentPurchaseBinding? = null
    private val binding get() = _binding!!

    private val purchaseAdapter = PurchaseAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPurchaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }

    fun setupRecyclerView(){

//        val orderList = arrayListOf(
//            Order(
//                UUID.randomUUID().toString(),
//                "Produto 1",
//                "20/08/2024",
//            ),
//            Order(
//                UUID.randomUUID().toString(),
//                "Produto 2",
//                "20/08/2024",
//            ),
//            Order(
//                UUID.randomUUID().toString(),
//                "Produto 3",
//                "17/08/2024",
//            ),
//            Order(
//                UUID.randomUUID().toString(),
//                "Produto 4",
//                "15/08/2024",
//            ),
//            Order(
//                UUID.randomUUID().toString(),
//                "Produto 5",
//                "15/08/2024",
//            ),
//            Order(
//                UUID.randomUUID().toString(),
//                "Produto 6",
//                "14/08/2024",
//            ),
//            Order(
//                UUID.randomUUID().toString(),
//                "Produto 7",
//                "14/08/2024",
//            ),
//            Order(
//                UUID.randomUUID().toString(),
//                "Produto 8",
//                "12/08/2024",
//            ),
//
//        )

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvPurchases.layoutManager = layoutManager;
        binding.rvPurchases.adapter = purchaseAdapter
        binding.rvPurchases.setHasFixedSize(true)

//        updateList(orderList)
    }

    fun updateList(orders: List<Product>){
        if (orders.isEmpty()) {
            binding.rvPurchases.visibility = View.GONE
//            binding.myTrainingTittle.visibility = View.GONE
//            binding.emptyTrainingList.visibility = View.VISIBLE
        } else {
            binding.rvPurchases.visibility = View.VISIBLE

            purchaseAdapter.updateList(orders)
        }
    }
}