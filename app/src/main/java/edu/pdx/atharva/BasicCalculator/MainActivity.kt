package edu.pdx.atharva.BasicCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.pdx.atharva.BasicCalculator.databinding.ActivityMainBinding
import kotlin.math.abs
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    // Binding for the Main Activity
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup button onClickListeners
        binding.addBtn.setOnClickListener { addBtn() }
        binding.subBtn.setOnClickListener { subBtn() }
        binding.multBtn.setOnClickListener { multBtn() }
        binding.divBtn.setOnClickListener { divBtn() }
        binding.pctBtn.setOnClickListener { pctBtn() }
        binding.sqrtBtn.setOnClickListener { sqrtBtn() }
    }

    // Empty operand check
    fun checkOperands(checkOp1: Boolean, checkOp2: Boolean): Boolean {
        if (checkOp1 && checkOp2) {
            if (binding.op1Input.text.toString().isEmpty() || binding.op2Input.text.toString().isEmpty()) {
                Toast.makeText(this, "Operands cannot be empty!", Toast.LENGTH_LONG).show()
                return false
            }
        } else if (checkOp1) {
            if (binding.op1Input.text.toString().isEmpty()) {
                Toast.makeText(this, "Operand cannot be empty!", Toast.LENGTH_LONG).show()
                return false
            }
        }

        return true
    }

    // Add button onClickListener
    fun addBtn() {
        if (checkOperands(true, true)) {
            val op1 = binding.op1Input.text.toString().toDouble()
            val op2 = binding.op2Input.text.toString().toDouble()

            val result = op1 + op2
            binding.resultsText.text = result.toString()
        }
    }

    // Subtract button onClickListener
    fun subBtn() {
        if (checkOperands(true, true)) {
            val op1 = binding.op1Input.text.toString().toDouble()
            val op2 = binding.op2Input.text.toString().toDouble()

            val result = op1 - op2
            binding.resultsText.text = result.toString()
        }
    }

    // Multiplication button onClickListener
    fun multBtn() {
        if (checkOperands(true, true)) {
            val op1 = binding.op1Input.text.toString().toDouble()
            val op2 = binding.op2Input.text.toString().toDouble()

            val result = op1 * op2
            binding.resultsText.text = "%.3f".format(result)
        }
    }

    // Divison button onClickListener
    fun divBtn() {
        if (checkOperands(true, true)) {
            val op1 = binding.op1Input.text.toString().toDouble()
            val op2 = binding.op2Input.text.toString().toDouble()

            // Check for divide by zero
            if (op2 == 0.0) {
                Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_LONG).show()
                binding.resultsText.text = "ERROR"
            } else {
                val result = op1 / op2
                binding.resultsText.text = "%.3f".format(result)
            }
        }
    }

    // Percent button onClickListener
    fun pctBtn() {
        if (checkOperands(true, false)) {
            val op1 = binding.op1Input.text.toString().toDouble()

            val result = op1 / 100.0
            binding.resultsText.text = result.toString()
        }
    }

    // Square Root button onClickListener
    fun sqrtBtn() {
        if (checkOperands(true, false)) {
            val op1 = binding.op1Input.text.toString().toDouble()
            val result = sqrt(abs(op1))
            binding.resultsText.text = "%.3f".format(result)
        }
    }
}