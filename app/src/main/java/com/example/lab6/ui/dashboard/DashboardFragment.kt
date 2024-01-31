package com.example.lab6.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.R
import com.example.lab6.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //insert code
        var recyclerView: RecyclerView? = null

        // ตัวแปรสําหรับเก็บชื1อข้อความที1จะแสดงในแต่ละภาพ
        var foods = arrayOf(
            "aespa",
            "Soshi",
            "Soshi1",
            "Soshi2",
            "aespa",
            "Soshi1",
            "Soshi2"
        )
        //ตัวแปรอาเรย์ที1ทําการเก็บรายชื1อภาพ จะเป็นชื1อภาพตามที1อยู่ในโฟลเดอร์ drawable
        var arrImg = arrayOf<Int>(
            R.drawable.aespa,
            R.drawable.soshi,
            R.drawable.soshi2,
            R.drawable.soshi3,
            R.drawable.aespa,
            R.drawable.soshi,
            R.drawable.soshi2
        )
        recyclerView = root.findViewById(R.id.recyclerView) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(root.context)
        var linearRadio = root.findViewById(R.id.linear_layout_rb) as RadioButton
        linearRadio.setOnClickListener {
            recyclerView!!.layoutManager = LinearLayoutManager(root.context) }
        var gridRadio = root.findViewById<RadioButton>(R.id.grid_layout_rb)
        gridRadio.setOnClickListener {
            recyclerView!!.setLayoutManager(GridLayoutManager(root.context, 2)) }
        val myAdapter = MyAdapter(foods,arrImg)
        recyclerView!!.adapter = myAdapter




//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}