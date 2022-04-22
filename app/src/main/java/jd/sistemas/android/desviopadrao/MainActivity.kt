package jd.sistemas.android.desviopadrao

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val button by lazy {
        findViewById<Button>(R.id.btnCalculate)
    }

    private val value1 by lazy {
        findViewById<EditText>(R.id.edt1)
    }

    private val value2 by lazy {
        findViewById<EditText>(R.id.edt2)
    }

    private val result by lazy {
        findViewById<TextView>(R.id.result)
    }

    private val calcula by lazy {
        Calcula()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
    }

    private fun setupListener() {
        button.setOnClickListener {
            val dp =
                calcula.calculaDesvioPadrao(
                    listOf(
                        value1.text.parseToDouble(),
                        value2.text.parseToDouble()
                    )
                )

            result.apply {
                this.visibility = View.VISIBLE
                text = getString(R.string.resultado, dp)
            }
        }
    }

    private fun Editable.parseToDouble() = when (isNotEmpty()) {
        true -> trim().toString().toDoubleOrNull() ?: 0.0
        else -> 0.0
    }
}