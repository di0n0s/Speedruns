package com.example.sfuentes.speedruns.interfaces

import android.view.View

interface AdapterListOnClickListener {
    interface AdapterListener {
        fun onItemSelected(position: Int, view: View)
    }

    interface ViewListener {
        fun onItemSelected(position: Int, view: View)
    }
}