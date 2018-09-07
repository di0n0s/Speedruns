package com.example.sfuentes.speedruns.extensions

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

inline fun FragmentManager.inTransaction(func : FragmentTransaction.() -> FragmentTransaction) = beginTransaction().func().commit()
