package com.example.labexercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            calculate()
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            reset()
        }
    }
    private fun calculate(){
        val SpinnerAge = findViewById<Spinner>(R.id.spinnerAge)
        val age = SpinnerAge.selectedItemPosition + 1
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupGender)
        val radioGroupGender = radioGroup.checkedRadioButtonId
        val genderGroup = findViewById<RadioButton>(radioGroupGender)
        val gender = genderGroup.text
        val checkBoxSmoker = findViewById<CheckBox>(R.id.checkBoxSmoker)
        val checkSmoker = checkBoxSmoker.isChecked

        var premiumInsur = 0

        if(age == 1){
            premiumInsur+=60
        }else if (age == 2) {
            premiumInsur += 70

            if (gender == "Male") {
                premiumInsur += 50
            }

            if (checkSmoker) {
                premiumInsur += 100
            }
        } else if (age == 3) {
            premiumInsur += 90

            if (gender == "Male")
            {
                premiumInsur += 100
            }

            if (checkSmoker) {
                premiumInsur += 150
            }
        } else if (age == 4) {
            premiumInsur += 120

            if (gender == "Male") {
                premiumInsur += 150
            }

            if (checkSmoker) {
                premiumInsur += 200
            }
        } else if (age == 5) {
            premiumInsur += 150

            if (gender == "Male") {
                premiumInsur += 200
            }

            if (checkSmoker) {
                premiumInsur += 250
            }
        } else if (age == 6) {
            premiumInsur += 150

            if (gender == "Male") {
                premiumInsur += 200
            }

            if (checkSmoker) {
                premiumInsur += 300
            }
        }

        textViewPremium.text = String.format("%s \n         %s %d",getString(R.string.insurance_premium), "RM", premiumInsur)


    }

    fun reset(){
        spinnerAge.setSelection(0)
        checkBoxSmoker.isChecked = false
        radioGroupGender.clearCheck()
        textViewPremium.text = getString(R.string.insurance_premium)
    }
}
