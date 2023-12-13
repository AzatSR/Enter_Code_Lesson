package com.example.stepik_lesson_pin_code

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlin.properties.Delegates


const val CORRECT_CODE = "1567"
const val CODE_LENGTH = 4
const val KEY_COUNTER = "001"
const val KEY_COUNTER_COLOR = "002"
class MainActivity : AppCompatActivity() {

    private var enterField = ""
    private lateinit var tv: TextView
    private var primaryColor by Delegates.notNull<Int>()
    private var redColor by Delegates.notNull<Int>()
    private var greenColor by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.getString(KEY_COUNTER)?.let { it ->
            enterField = it
        }

        initTextView()
        initNumButton()
        initBackSpace()
        initOKButton()
        initColors()
        updateTextView()

        savedInstanceState?.getInt(KEY_COUNTER_COLOR)?.let { it ->
            tv.setTextColor(it)
        }
    }
    private fun initColors(){
        primaryColor = ResourcesCompat.getColor(resources, R.color.color_primary, null)
        redColor = ResourcesCompat.getColor(resources, R.color.error, null)
        greenColor = ResourcesCompat.getColor(resources, R.color.green, null)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(KEY_COUNTER, enterField)
        outState.putInt(KEY_COUNTER_COLOR, tv.currentTextColor)
        super.onSaveInstanceState(outState)
    }

    private fun initTextView(){
        tv = findViewById(R.id.textView)
    }

    private fun initOKButton() {
        val ok: Button = findViewById(R.id.button12)
        ok.setOnClickListener {
            checkedCorrectEnterCode()
        }
    }

    private fun checkedCorrectEnterCode() {
        if (enterField == CORRECT_CODE){
            tv.setTextColor(greenColor)

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

        } else {
            tv.setTextColor(redColor)
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
        if (enterField.length > CODE_LENGTH){
            enterField = enterField.substring(0, CODE_LENGTH)
        }
        tv.text = enterField
        tv.setTextColor(primaryColor)
    }

    private fun initBackSpace(){
        val back: Button = findViewById(R.id.button10)
        back.setOnClickListener {
            enterField = enterField.dropLast(1)
            updateTextView()
        }
    }

}