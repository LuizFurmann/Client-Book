package com.example.clientbook.view.purchase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clientbook.databinding.FragmentPurchaseBinding
import com.example.clientbook.model.Order
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

        val orderList = arrayListOf(
            Order(
                UUID.randomUUID().toString(),
                "Chapéu de praia",
                "26/04/2026",
            ),
            Order(
                UUID.randomUUID().toString(),
                "Calça jeans feminina",
                "15/02/2026",
            ),
            Order(
                UUID.randomUUID().toString(),
                "Camiseta feminina",
                "20/12/2025",
            ),
            Order(
                UUID.randomUUID().toString(),
                "Camiseta masculina",
                "20/12/2025",
            ),
        )

        val layoutManager = LinearLayoutManager(requireContext())
        binding.rvPurchases.layoutManager = layoutManager;
        binding.rvPurchases.adapter = purchaseAdapter
        binding.rvPurchases.setHasFixedSize(true)

        updateList(orderList)
    }

    fun updateList(orders: List<Order>){
        if (orders.isEmpty()) {
            binding.rvPurchases.visibility = View.GONE
            //TODO image to empty list
        } else {
            binding.rvPurchases.visibility = View.VISIBLE

            purchaseAdapter.updateList(orders)
        }
    }
}