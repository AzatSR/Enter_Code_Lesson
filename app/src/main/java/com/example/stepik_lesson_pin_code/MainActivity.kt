package com.example.stepik_lesson_pin_code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

const val CORRECT_CODE = "1567"
const val CODE_LENGTH = 4
class MainActivity : AppCompatActivity() {

    private var enterField = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNumButton()
        initBackSpace()
        initOKButton()

    }

    private fun initOKButton() {
        val ok: Button = findViewById(R.id.button12)
        ok.setOnClickListener {
            checkedCorrectEneterCode()
        }
    }

    private fun checkedCorrectEneterCode() {
        if (enterField == CORRECT_CODE){
            Toast.makeText(this, R.string.code_correct, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initNumButton(){
        val firstBt: Button = findViewById(R.id.button1)
        firstBt.setOnClickListener(this::onClickButton)
        val secondBt: Button = findViewById(R.id.button2)
        secondBt.setOnClickListener(this::onClickButton)
        val threeBt: Button = findViewById(R.id.button3)
        threeBt.setOnClickListener(this::onClickButton)
        val fourBt: Button = findViewById(R.id.button4)
        fourBt.setOnClickListener(this::onClickButton)
        val fiveBt: Button = findViewById(R.id.button5)
        fiveBt.setOnClickListener(this::onClickButton)
        val sixBt: Button = findViewById(R.id.button6)
        sixBt.setOnClickListener(this::onClickButton)
        val sevenBt: Button = findViewById(R.id.button7)
        sevenBt.setOnClickListener(this::onClickButton)
        val eightBt: Button = findViewById(R.id.button8)
        eightBt.setOnClickListener(this::onClickButton)
        val nineBt: Button = findViewById(R.id.button9)
        nineBt.setOnClickListener(this::onClickButton)
        val zeroBt: Button = findViewById(R.id.button11)
        zeroBt.setOnClickListener(this::onClickButton)

    }

    private fun onClickButton(view: View){
        if (view !is Button) {
            return // если view-а не кнопка, то уходим
                   // в остальных случаях можно взять из нее текст
        }
        val clickedBt = view.text
        enterField += clickedBt
        updateTextView()
    }

    private fun updateTextView(){
        val tv: TextView = findViewById(R.id.textView)
        if (enterField.length > CODE_LENGTH){
            enterField = enterField.substring(0, CODE_LENGTH)
        }
        tv.text = enterField
    }

    private fun initBackSpace(){
        val back: Button = findViewById(R.id.button10)
        back.setOnClickListener {
            enterField = enterField.dropLast(1)
            updateTextView()
        }
    }

}