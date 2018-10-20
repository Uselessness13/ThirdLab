package com.example.aaand.thirdlab

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var list_of_items = arrayOf("Наличными", "Картой", "Электронными деньгами", "Курьеру", "Бонусами")

    var spinner: Spinner? = null

    var ham = 50
    var mushrooms = 40
    var cheese = 60
    var pineapple = 60

    var rad25 = 200
    var rad30 = 300
    var rad35 = 350

    var previous_cost = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = this.spinner3
        spinner!!.setOnItemSelectedListener(this)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.setAdapter(aa)

    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        Toast.makeText(this, "Выбрана оплата " + list_of_items[position].toLowerCase(), Toast.LENGTH_SHORT).show()
        val newValue = spinner!!.selectedItem;
        Log.d("kek", newValue.toString())
        when (newValue) {
            "Наличными" -> {
                cardNumber.setText("0")
                dateCardEnd.visibility = View.GONE
                cardNumber.visibility = View.GONE
                cardCVV.visibility = View.GONE
            }
            "Картой" -> {
                cardNumber.text = null
                cardNumber.hint = "Номер карты"
                dateCardEnd.visibility = View.VISIBLE
                cardNumber.visibility = View.VISIBLE
                cardCVV.visibility = View.VISIBLE
            }
            "Электронными деньгами" -> {
                cardNumber.text = null
                cardNumber.hint = "Номер кошелька"
                dateCardEnd.visibility = View.GONE
                cardNumber.visibility = View.VISIBLE
                cardCVV.visibility = View.GONE
            }
            "Курьеру" -> {
                cardNumber.setText("0")
                dateCardEnd.visibility = View.GONE
                cardNumber.visibility = View.GONE
                cardCVV.visibility = View.GONE
            }
            "Бонусами" -> {
                cardNumber.text = null
                cardNumber.hint = "Номер бонусной карты"
                dateCardEnd.visibility = View.GONE
                cardNumber.visibility = View.VISIBLE
                cardCVV.visibility = View.GONE
            }
            else -> {
                cardNumber.setText("0")
                dateCardEnd.visibility = View.GONE
                cardNumber.visibility = View.GONE
                cardCVV.visibility = View.GONE
            }
        }
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }

    fun switch_email_onClick(view: View) {
        if (email_switch.isChecked()) {
            email.visibility = View.VISIBLE
        } else {
            email.visibility = View.GONE
        }
    }

    fun observer() {
        var sum = 0
        sum += (if (hamCB.isChecked()) ham else 0) + (if (pineappleCB.isChecked()) pineapple else 0) + (if (cheeseCB.isChecked()) cheese else 0) + (if (mushroomCB.isChecked()) mushrooms else 0) + (if (little.isChecked()) rad25 else 0) + (if (medium.isChecked()) rad30 else 0) + (if (big.isChecked()) rad35 else 0)
        txtResult.text = if (sum > 0) sum.toString() else "Итого"
    }

    fun kek(view: View){
        observer()
    }

    fun button_order_onClick(view: View) {
        Toast.makeText(this, "Заказ оформлен", Toast.LENGTH_SHORT).show()
        observer()
    }
}
