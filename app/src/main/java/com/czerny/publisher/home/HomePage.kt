package com.czerny.publisher.home

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.czerny.publisher.R
import com.czerny.publisher.databinding.FragmentHomePageBinding

class HomePage : Fragment() {
    private val viewModel: HomePageViewModel by lazy {
        ViewModelProvider(this).get(HomePageViewModel::class.java)
    }

    lateinit var binding : FragmentHomePageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        binding.homeViewMode = viewModel
        binding.lifecycleOwner = this

        val homeAdapter = HomePagaAdapter()
        binding.recyclerviewHomePage.adapter = homeAdapter

        val mockData: MutableList<MockData> = mutableListOf()
        mockData.add(MockData(1, "teest", "IU「亂穿」竟美出新境界!笑稱自己品味奇怪 網笑:靠顏值撐住女神氣場",
            "AKA小安老師", "Beauty", "12345",
            "南韓歌手IU(李知恩)無論在歌唱方面或是近期的戲劇作品都有亮眼的成績，但俗話說人無完美、美玉微瑕，曾"))

        viewModel.editableList = mockData
        homeAdapter.submitList(viewModel.editableList)
        viewModel.homeProduct.observe(viewLifecycleOwner, Observer {
            it?.let {
                homeAdapter.notifyDataSetChanged()
            }
        })

        binding.imageButtonPublish.setOnClickListener{
//            findNavController().navigate(HomePageDirections.actionHomePageToArticlePage())

            var sucessDialog = Dialog(this.requireContext())
            val view = layoutInflater.inflate(R.layout.dialog_publisher, null)
            sucessDialog.setContentView(view)
            sucessDialog.show()
//            this.dismiss()


            //後面抓取資料
//                val bottomSheepFragment = BottomSheepFragment()
//                bottomSheepFragment.show()

//            val dialoagView = layoutInflater.inflate(R.layout.fragment_bottom_sheep, null)
//            val dialog = BottomSheepFragment(this)
//            dialog.setContenView(dialoagView)
//            dialog.show()
        }


        binding.lifecycleOwner = this
        return binding.root
    }

}

