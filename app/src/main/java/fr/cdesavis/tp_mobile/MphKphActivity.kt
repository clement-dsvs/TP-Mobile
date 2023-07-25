package fr.cdesavis.tp_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import androidx.core.widget.doOnTextChanged

class MphKphActivity : AppCompatActivity() {
    private lateinit var txtMph : EditText
    private lateinit var txtKph : EditText
    private var ratio = 1.60934

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mph_kph)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        this.txtMph = findViewById<EditText>(R.id.txtMph)
        this.txtKph = findViewById<EditText>(R.id.txtKph)


        txtMph.doOnTextChanged { text: CharSequence?, start, before, count ->
            if (!txtMph.isFocused) return@doOnTextChanged;
            txtKph.setText(
                mph_to_kph(text)
            )
        }
        txtKph.doOnTextChanged { text: CharSequence?, start, before, count ->
            if (!txtKph.isFocused) return@doOnTextChanged;
            txtMph.setText(
                kph_to_mph(text)
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

    fun mph_to_kph(value: CharSequence?): String {
        return (value.toString().toDouble() * ratio).toBigDecimal().toPlainString()
    }

    fun kph_to_mph(value: CharSequence?): String {
        return (value.toString().toDouble() / ratio).toBigDecimal().toPlainString()
    }
}