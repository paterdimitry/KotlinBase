package com.geekbrain.kotlinbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val textView: TextView = findViewById(R.id.textView)
        val cats: List<Cat> = initCatList()
        initButton(cats, textView)
    }

    private fun initCatList(): List<Cat> {
        val cat1 = Cat("Barsik", 12, "red")
        val cat2 = Cat("Myrsik", 6, "white")
        return listOf(cat1, cat2)
    }

    private fun initButton(cats: List<Cat>, textView: TextView) {
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            var text = ""
            for (cat in cats) {
                val color = when (cat.color) {
                    "red" -> "Красный"
                    "white" -> "Белый"
                    else -> "Неизвестный"
                }
                text += "Кот по имени ${cat.name} возраста ${cat.age} лет и его цвет - $color \n"
            }
            textView.text = text
        }
    }
}