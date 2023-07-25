package fr.cdesavis.tp_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import androidx.core.widget.doOnTextChanged

class MetresPiedsActivity : AppCompatActivity() {

    private lateinit var txtMetres : EditText
    private lateinit var txtPieds : EditText
    private var ratio = 3.28084

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metres_pieds)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        this.txtMetres = findViewById<EditText>(R.id.txtMph)
        this.txtPieds = findViewById<EditText>(R.id.txtPieds)


        txtMetres.doOnTextChanged { text: CharSequence?, start, before, count ->
            if (!txtMetres.isFocused) return@doOnTextChanged;
            txtPieds.setText(
                metres_to_pieds(text)
            )
        }
        txtPieds.doOnTextChanged { text: CharSequence?, start, before, count ->
            if (!txtPieds.isFocused) return@doOnTextChanged;
            txtMetres.setText(
                pieds_to_metres(text)
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

    fun metres_to_pieds(value: CharSequence?): String {
        return (value.toString().toDouble() * ratio).toBigDecimal().toPlainString()
    }

    fun pieds_to_metres(value: CharSequence?): String {
        return (value.toString().toDouble() / ratio).toBigDecimal().toPlainString()
    }

}