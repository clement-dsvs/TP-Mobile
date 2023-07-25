package fr.cdesavis.tp_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import androidx.core.widget.doOnTextChanged

class KgLbActivity : AppCompatActivity() {

    private lateinit var txtKg: EditText
    private lateinit var txtLivre: EditText
    val ratio = 2.20462

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kg_lb)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        this.txtKg = findViewById<EditText>(R.id.txtMph)
        this.txtLivre = findViewById<EditText>(R.id.txtKph)


        txtKg.doOnTextChanged { text: CharSequence?, start, before, count ->
            if (!txtKg.isFocused) return@doOnTextChanged;
            txtLivre.setText(
                livre_to_kg(text)
            )
        }
        txtLivre.doOnTextChanged { text: CharSequence?, start, before, count ->
            if (!txtLivre.isFocused) return@doOnTextChanged;
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