package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var input1: Long = 0
    private var input2: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var signValue: Boolean = false

    fun onTap(view : View){
        val num = view as Button
        var id = ""
        when(num.tag.toString()){
            "0" -> id = "0";
            "1" -> id = "1";
            "2" -> id = "2";
            "3" -> id = "3";
            "4" -> id = "4";
            "5" -> id = "5";
            "6" -> id = "6";
            "7" -> id = "7";
            "8" -> id = "8";
            "9" -> id = "9";
            "." -> id = ".";

        }

        val str = findViewById<TextView>(R.id.input).text.toString()
        if(str.length >= 10){
            Toast.makeText(this, "Can't enter more than 10 digits", Toast.LENGTH_SHORT).show()
        }else{
            findViewById<TextView>(R.id.input).setText(str + id).toString()
        }
    }



    fun backSpace(view: View) {
        val input = findViewById<TextView>(R.id.input)
        var txt = input.text.toString()
        if(txt.length > 1){
            txt = txt.substring(0, txt.length - 1)
            input.setText(txt).toString()
        }else{
            input.setText("").toString()
        }
    }

    fun clear(view: View) {
        val res = findViewById<TextView>(R.id.result)
        val input = findViewById<TextView>(R.id.input)
        input.setText("").toString()
        res.setText("").toString()
        input1 = 0
        input2 = 0
        signValue = false
    }



    fun operator(view: View) {
        if (!signValue){
            val button = view as Button
            var sign = ""
            when(button.tag.toString()){
                "+" -> sign = "+"
                "-" -> sign = "-"
                "*" -> sign = "*"
                "/" -> sign = "/"
            }

            signValue = true

            val res = findViewById<TextView>(R.id.result)
            val input = findViewById<TextView>(R.id.input)

            input1 = input.text.toString().toLong()

            res.setText(input.text.toString() + sign).toString()
            input.setText("").toString()
        }


    }
    fun result(view: View) {
        val res = findViewById<TextView>(R.id.result)
        val input = findViewById<TextView>(R.id.input)

        val sign = res.text.toString()[res.text.toString().length - 1]

        input2 = input.text.toString().toLong()

        val str = res.text.toString()
        res.setText(str + input.text.toString()).toString()


        if(sign == '+'){
            input.setText(sum().toString()).toString()
        }else if(sign == '*'){
            input.setText(mul().toString()).toString()
        }else if(sign == '/'){
            input.setText(div().toString()).toString()
        }else if(sign == '-'){
            input.setText(minus().toString()).toString()
        }



    }

    private fun minus(): Long {
        return input1 - input2
    }

    private fun div(): Double {
        return input1.toDouble() / input2
    }

    private fun sum(): Long{
        return input1 + input2
    }

    private fun mul(): Long {
        return input1 * input2
    }
}