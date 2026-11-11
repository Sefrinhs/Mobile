package com.example.per_3sefriansyah_3tie.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.per_3sefriansyah_3tie.Home.pertemuan_9.NinthActivity
import com.example.per_3sefriansyah_3tie.Pertemuan2.SecondActivity
import com.example.per_3sefriansyah_3tie.Pertemuan3.ThirdActivity
import com.example.per_3sefriansyah_3tie.Pertemuan4.FourthActivity
import com.example.per_3sefriansyah_3tie.R
import com.example.per_3sefriansyah_3tie.databinding.FragmentHomeBinding
import com.example.per_3sefriansyah_3tie.pertemuan10.FragmentMessage
import com.example.per_3sefriansyah_3tie.pertemuan10.FragmentMore
import com.example.per_3sefriansyah_3tie.pertemuan7.SeventhActivity

class FragmentHome : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPertemuan2.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnPertemuan3.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        binding.btnPertemuan4.setOnClickListener {
            startActivity(Intent(requireContext(), FourthActivity::class.java))
        }

        binding.btnPertemuan5.setOnClickListener {
            startActivity(Intent(requireContext(), com.example.per_3sefriansyah_3tie.pertemuan5.MainActivity::class.java))
        }

        binding.btnPertemuan7.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }

        binding.btnPertemuan9.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }

        binding.btnPertemuan10.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentMessage())
                .addToBackStack(null)
                .commit()
        }

        binding.btnPertemuan10More.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentMore())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
