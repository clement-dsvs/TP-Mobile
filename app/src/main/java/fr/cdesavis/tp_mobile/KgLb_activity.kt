package fr.cdesavis.tp_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged

class KgLb_activity : AppCompatActivity() {

    val ratio = 2.20462

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kg_lb)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val txtKg = findViewById<EditText>(R.id.txtKg)
        val txtLivre = findViewById<EditText>(R.id.txtLivre)


        txtKg.doOnTextChanged { text: CharSequence?, start, before, count ->
            print(start)
        }
        txtLivre.doOnTextChanged { text: CharSequence?, start, before, count ->
            txtKg.setText(
                livre_to_kg(text)
            )
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            (android.R.id.home) -> {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    fun kg_to_livre(value: CharSequence?): String {
        return (value.toString().toDouble() * ratio).toBigDecimal().toPlainString()
    }

    fun livre_to_kg(value: CharSequence?): String {
        return (value.toString().toDouble() / ratio).toBigDecimal().toPlainString()
    }


}