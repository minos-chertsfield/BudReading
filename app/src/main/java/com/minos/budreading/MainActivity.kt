package com.minos.budreading

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var mFragmentReading: ReadingFragment? = null
    private var mFragmentBookshelf: BookshelfFragment? = null
    private var mFragmentAudiobook: AudiobookFragment? = null
    private var mFragmentMine: MineFragment? = null

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_reading -> {
                    showFragment(0)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_bookshelf -> {
                    showFragment(1)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_audiobook -> {
                    showFragment(2)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_mine -> {
                    showFragment(3)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun showFragment(index: Int) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        hideFragment(transaction)
        when (index) {
            0 -> {
                if (mFragmentReading == null) {
                    mFragmentReading = ReadingFragment()
                    transaction.add(R.id.content, mFragmentReading!!)
                } else {
                    transaction.show(mFragmentReading!!)
                }
            }

            1 -> {
                if (mFragmentBookshelf == null) {
                    mFragmentBookshelf = BookshelfFragment()
                    transaction.add(R.id.content, mFragmentBookshelf!!)
                } else {
                    transaction.show(mFragmentBookshelf!!)
                }
            }

            2 -> {
                if (mFragmentAudiobook == null) {
                    mFragmentAudiobook = AudiobookFragment()
                    transaction.add(R.id.content, mFragmentAudiobook!!)
                } else {
                    transaction.show(mFragmentAudiobook!!)
                }
            }

            3 -> {
                if (mFragmentMine == null) {
                    mFragmentMine = MineFragment()
                    transaction.add(R.id.content, mFragmentMine!!)
                } else {
                    transaction.show(mFragmentMine!!)
                }
            }
        }
        transaction.commit()
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        mFragmentReading?.let {
            transaction.hide(it)
        }
        mFragmentBookshelf?.let {
            transaction.hide(it)
        }
        mFragmentAudiobook?.let {
            transaction.hide(it)
        }
        mFragmentMine?.let {
            transaction.hide(it)
        }
    }

}