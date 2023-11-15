package com.example.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.PopupMenu
import androidx.activity.ComponentActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    var listData: ArrayList<Contact> = ArrayList<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)

        var list: ArrayList<Contact> = dataList()
        listData = list

        val myAdapter: ContactAdapter = ContactAdapter(list, this)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = myAdapter



        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        myAdapter.setOnClickListener(object :
            ContactAdapter.OnClickListener {
            override fun onClick(position: Int, model: Contact) {
                val intent = Intent(this@MainActivity, ContactDetail::class.java)
                // Passing the data to the
                // EmployeeDetails Activity
                intent.putExtra("NAME_DETAIL", model.name)
                intent.putExtra("ID_DETAIL", model.ID )
                intent.putExtra("EMAIL_DETAIL", model.email)
                intent.putExtra("PHONE_DETAIL", model.phone)
                startActivity(intent)
            }
        })




    }


    fun dataList() : ArrayList<Contact>{
        var list: ArrayList<Contact> = ArrayList<Contact>()
        list.add(Contact("Nguyen Huu Viet", "0000001", "viet123@gmail.com", "0836059023"))
        list.add(Contact("Lai Quoc Trung", "0000003", "trung123@gmail.com", "091787062"))
        list.add(Contact("Le Nguyen Bao Ngoc", "0009701", "ngoc123@gmail.com", "0452259063"))
        list.add(Contact("Truong Gia Binh", "0234001", "binh123@gmail.com", "0916059234"))
        list.add(Contact("Le Duong Bao Lam", "0432001", "lam123@gmail.com", "0916000263"))
        list.add(Contact("Tran Duc", "0056701", "hoa123@gmail.com", "0912059062"))
        list.add(Contact("Duong Pham Thanh Hang", "0012801", "Hang123@gmail.com", "0516023463"))
        list.add(Contact("Le Loi", "0666601", "loi123@gmail.com", "0923059062"))
        list.add(Contact("Le Hoan", "0834501", "hoan123@gmail.com", "0913489263"))
        list.add(Contact("Phuong Thao", "0035001", "thao123@gmail.com", "0912234063"))
        list.add(Contact("Le Huu Trac", "0056321", "trac123@gmail.com", "0983059063"))
        list.add(Contact("Truong Dinh Ngoc", "0023401", "ngoc123@gmail.com", "2923679063"))
        return list
    }

}

