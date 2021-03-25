package com.example.calculator_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        One.setOnClickListener{
            calculations("1",clearText = true)
        }
        Two.setOnClickListener {
            calculations("2",clearText = true)
        }
        Three.setOnClickListener {
            calculations("3",clearText = true)
        }
        Four.setOnClickListener {
            calculations("4",clearText = true)
        }
        Five.setOnClickListener {
            calculations("5",clearText = true)
        }
        Six.setOnClickListener {
            calculations("6",clearText = true)
        }
        Seven.setOnClickListener {
            calculations("7",clearText = true)
        }
        Eight.setOnClickListener {
            calculations("8",clearText = true)
        }
        Nine.setOnClickListener {
            calculations("9",clearText = true)
        }
        Zero.setOnClickListener {
            calculations("0",clearText = true)
        }

        Plus.setOnClickListener {
            calculations("+",clearText = true)
        }
        Minus.setOnClickListener {
            calculations("-",clearText = true)
        }
        Multiply.setOnClickListener {
            calculations("*",clearText = true)
        }
        Divide.setOnClickListener {
            calculations("/",clearText = true)
        }
        Dot.setOnClickListener {
            calculations(".",clearText = true)
        }
        Clear.setOnClickListener {
            Expression.text =""
            Result.text=""
        }
        Equals.setOnClickListener {
            val text = Expression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                Result.text = longResult.toString()
            } else {
                Result.text = result.toString()
            }
        }

        Delete.setOnClickListener {
            val text = Expression.text.toString()
            if(text.isNotEmpty()) {
                Expression.text = text.dropLast(1)
            }

            Result.text = ""
        }
    }
    fun calculations(string: String,clearText: Boolean)
    {
        if(clearText)
        {
            Result.text = "";
            Expression.append(string);
        }else{
            Result.append(Result.text);
            Result.append(string)
            Result.text= ""
        }

    }
}