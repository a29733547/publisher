package com.czerny.publisher.publish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.czerny.publisher.databinding.DialogPublisherBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ArticlePage: BottomSheetDialogFragment() {

    lateinit var binding : DialogPublisherBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogPublisherBinding.inflate(inflater, container, false)





        return binding.root
    }
}