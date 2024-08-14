package com.example.clientbook.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clientbook.R
import com.example.clientbook.databinding.FragmentHomeBinding
import com.example.clientbook.model.Carousel
import java.util.UUID

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val carouselAdapter = CarouselAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCarousel()
    }

    private fun setupCarousel(){

        val imageRV = binding.imageRV

        val imageList = arrayListOf(
            Carousel(
                UUID.randomUUID().toString(),
                "PRIMEIRA",
                "https://fastly.picsum.photos/id/866/500/500.jpg?hmac=FOptChXpmOmfR5SpiL2pp74Yadf1T_bRhBF1wJZa9hg"
            ),
            Carousel(
                UUID.randomUUID().toString(),
                "segunda",
                "https://fastly.picsum.photos/id/270/500/500.jpg?hmac=MK7XNrBrZ73QsthvGaAkiNoTl65ZDlUhEO-6fnd-ZnY"
            ),
            Carousel(
                UUID.randomUUID().toString(),
                "terceira",
                "https://fastly.picsum.photos/id/320/500/500.jpg?hmac=2iE7TIF9kIqQOHrIUPOJx2wP1CJewQIZBeMLIRrm74s"
            ),
            Carousel(
                UUID.randomUUID().toString(),
                "quarta",
                "https://fastly.picsum.photos/id/798/500/500.jpg?hmac=Bmzk6g3m8sUiEVHfJWBscr2DUg8Vd2QhN7igHBXLLfo"
            )
        )

        val imageAdapter = CarouselAdapter()
        imageRV.adapter = imageAdapter
        imageAdapter.submitList(imageList)
    }

}