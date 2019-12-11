package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener{calculate()};
        buttonReset.setOnClickListener{reset()};
    }

    private fun calculate(){
        Toast.makeText(this, "Car Loan calculated",
            Toast.LENGTH_SHORT).show()

        var carPrice = editTextCarPrice.text.toString().toDouble()
        var downPayment = editTextDownPayment.text.toString().toDouble()
        var interestRate = editTextInterestRate.text.toString().toDouble()
        var loanPeriod = editTextLoanPeriod.text.toString().toInt()

        var totalLoan1 = carPrice - downPayment
        var interes1 = totalLoan1 * interestRate * loanPeriod
        var monthlyRepay1 = (totalLoan1 + interes1)/ loanPeriod/ 12

        val totalLoan:Double = String.format("%.2f",totalLoan1).toDouble()
        val interes:Double = String.format("%.2f",interes1).toDouble()
        val monthlyRepay:Double = String.format("%.2f",monthlyRepay1).toDouble()

        textViewLoan.text=String.format("Car Loan = " + totalLoan)
        textViewInterest.text=String.format("Interest = "+ interes)
        textViewMonthlyRepayment.text=String.format("Monthly Repayment = " + monthlyRepay)

    }

    private fun reset(){
        editTextCarPrice.setText(null)
        editTextDownPayment.setText(null)
        editTextInterestRate.setText(null)
        editTextLoanPeriod.setText(null)
        textViewLoan.setText(null)
        textViewInterest.setText(null)
        textViewMonthlyRepayment.setText(null)
    }
}
