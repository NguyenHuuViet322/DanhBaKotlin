package com.example.android

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

import androidx.appcompat.widget.Toolbar

class ContactDetail: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)
        val toolBar: Toolbar = findViewById(R.id.toolbar)

        toolBar?.setNavigationOnClickListener {
            onBackPressed()
        }

        val intent: Intent = getIntent()
        val name: String = intent.getStringExtra("NAME_DETAIL") as String
        val ID: String = intent.getStringExtra("ID_DETAIL") as String
        val email: String = intent.getStringExtra("EMAIL_DETAIL") as String
        val phone: String = intent.getStringExtra("PHONE_DETAIL") as String

        findViewById<TextView>(R.id.idDetail).text = ID
        findViewById<TextView>(R.id.phoneDetail).text = phone
        findViewById<TextView>(R.id.emailDetail).text = email
        findViewById<TextView>(R.id.nameDetail).text = name
    }
}