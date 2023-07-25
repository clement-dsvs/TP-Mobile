package fr.cdesavis.tp_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import androidx.core.widget.doOnTextChanged

class MetresPoucesActivity : AppCompatActivity() {

    private lateinit var txtMetres : EditText
    private lateinit var txtPouces : EditText
    private var ratio = 39.3701

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metres_pouces)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        this.txtMetres = findViewById<EditText>(R.id.txtMph)
        this.txtPouces = findViewById<EditText>(R.id.txtKph)


        txtMetres.doOnTextChanged { text: CharSequence?, start, before, count ->
            if (!txtMetres.isFocused) return@doOnTextChanged;
            txtPouces.setText(
                metres_to_pouces(text)
            )
        }
        txtPouces.doOnTextChanged { text: CharSequence?, start, before, count ->
            if (!txtPouces.isFocused) return@doOnTextChanged;
            txtMetres.setText(
                pouces_to_metres(text)
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

    fun metres_to_pouces(value: CharSequence?): String {
        return (value.toString().toDouble() * ratio).toBigDecimal().toPlainString()
    }

    fun pouces_to_metres(value: CharSequence?): String {
        return (value.toString().toDouble() / ratio).toBigDecimal().toPlainString()
    }
}