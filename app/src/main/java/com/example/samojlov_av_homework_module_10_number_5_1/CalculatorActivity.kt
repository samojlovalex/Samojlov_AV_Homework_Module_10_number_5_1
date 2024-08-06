package com.example.samojlov_av_homework_module_10_number_5_1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samojlov_av_homework_module_10_number_5_1.databinding.ActivityCalculatorBinding
import com.example.samojlov_av_homework_module_10_number_5_1.databinding.ActivityMainBinding

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCalculatorBinding
    private lateinit var toolbarCalculator: androidx.appcompat.widget.Toolbar
    private lateinit var numberFirstET: EditText
    private lateinit var numberSecondET: EditText
    private lateinit var plusBTN: Button
    private lateinit var minusBTN: Button
    private lateinit var multiplicationBTN: Button
    private lateinit var divisionBTN: Button
    private val calculator = Calculator(numberFirstET.toString(), numberSecondET.toString())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init() {
        toolbarCalculator = binding.toolbarCalculator
        setSupportActionBar(toolbarCalculator)
        title = getString(R.string.toolbar_title)
        toolbarCalculator.subtitle = getString(R.string.toolbar_subtitle)
        toolbarCalculator.setLogo(R.drawable.toolbar_icon)

        numberFirstET = binding.numberFirstET
        numberSecondET = binding.numberSecondET
        plusBTN = binding.plusBTN
        minusBTN = binding.minusBTN
        multiplicationBTN = binding.multiplicationBTN
        divisionBTN = binding.divisionBTN

        fun resultOut(result: String) {
            val intent = Intent()
            intent.putExtra("result", result)
            setResult(RESULT_OK, intent)
            finish()
        }
        plusBTN.setOnClickListener(this)
        minusBTN.setOnClickListener(this)
        multiplicationBTN.setOnClickListener(this)
        divisionBTN.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("SetTextI18n", "ShowToast")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.resetMenuMain -> {
                numberFirstET.text.clear()
                numberSecondET.text.clear()
                Toast.makeText(
                    applicationContext,
                    getString(R.string.toast_reset),
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.exitMenuMain -> {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.toast_exit_calculator),
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        if (numberFirstET.text.isEmpty() || numberSecondET.text.isEmpty()) {
            return
        }

        val result = when (v?.id) {
            R.id.plusBTN -> calculator.plus.toString()
            R.id.minusBTN -> calculator.minus.toString()
            R.id.multiplicationBTN -> calculator.multiplication.toString()
            R.id.divisionBTN -> calculator.divisionBT.toString()
            else -> {""}
        }
        val intent = Intent()
        intent.putExtra("calculation", result)
        setResult(RESULT_OK,intent)
        finish()
    }
}