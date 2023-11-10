package com.example.mobileassignment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class calc : AppCompatActivity() {
    private lateinit var tvInput: TextView
    private lateinit var tvOutput: TextView

    // Represent whether the lastly pressed key is numeric or not
    private var lastNumeric: Boolean = false

    // Represent that current state is in error or not
    private var stateError: Boolean = false

    // If true, do not allow to add another DOT
    private var lastDot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        tvInput = findViewById(R.id.tvInput)
        tvOutput = findViewById(R.id.tvOutput)
    }
    fun onDigit(view: View) {
        if (stateError) {
            // If current state is Error, replace the error message
            tvInput.text = (view as Button).text
            stateError = false
        } else {
            // If not, already there is a valid expression so append to it
            tvInput.append((view as Button).text)
        }
        // Set the flag
        lastNumeric = true
    }

    /**
     * Append . to the TextView
     */
    fun onDecimalPoint(view: View) {
        if (lastNumeric && !stateError && !lastDot) {
            tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    /**
     * Append +, -, *, /, or % to the TextView
     */
    fun onOperator(view: View) {
        if (lastNumeric && !stateError) {
            tvInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false    // Reset the DOT flag
        }
    }

    /**
     * Clear the TextView
     */
    fun onClear(view: View) {
        tvInput.text = ""
        tvOutput.text = ""
        lastNumeric = false
        stateError = false
        lastDot = false
    }

    /**
     * Calculate the output using exp4j library
     */
    fun onEqual(view: View) {
        // If the current state is error, nothing to do.
        // If the last input is not a number, nothing to do
        if (lastNumeric && !stateError) {
            // Read the expression
            val txt = tvInput.text.toString()
            // Create an Expression (A class from exp4j library)
            val expression = ExpressionBuilder(txt).build()
            try {
                // Calculate the result and display
                val result = expression.evaluate()
                tvOutput.text = result.toString()
                lastDot = true // Result contains a dot
            } catch (ex: ArithmeticException) {
                // Display an error message
                tvOutput.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }
    }
}