package fr.cdesavis.tp_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.preference.PreferenceManager

import fr.cdesavis.tp_mobile.SettingsActivity
import fr.cdesavis.tp_mobile.databinding.ActivityLauncherBinding

class LauncherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)


        val btn_kg_livrees = findViewById<Button>(R.id.btn_kg_livres)
        btn_kg_livrees.setOnClickListener { startActivity(Intent(this, KgLb_activity::class.java)) }

        val settings_btn: View = findViewById(R.id.floatingActionButton)
        settings_btn.setOnClickListener{startSettingActivity()}

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val font_size = prefs.getString("font_size", "12")!!.toFloat()
        val enabled = prefs.getBoolean("switch_preference_1", true)

        binding = ActivityLauncherBinding.inflate(layoutInflater)
        binding.apply {


            if(enabled) {
                textView.text = "Checked"
            }
            else {
                textView.visibility = View.GONE
            }

        }
    }

    private fun startSettingActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

    private fun mySettings() {

    }

}

class convert(var input_decimal: EditText, var input_binary: EditText, var input_hexa: EditText) {
    var d: Int = 0
    lateinit var b: String
    lateinit var h: String

    private fun fromDec2Bin(dec: Int): String {
        return Integer.toBinaryString(dec)
    }

    private fun fromDec2Hex(dec: Int): String {
        return Integer.toHexString(dec)
    }

    private fun fromBin2Dec(bin: String): Int {
        return Integer.parseInt(bin, 2)
    }

    private fun fromBin2Hex(bin: String): String {
        return Integer.toHexString(Integer.parseInt(bin, 2))
    }

    private fun fromHex2Dec(hex: String): Int {
        return Integer.parseInt(hex, 16)
    }

    private fun fromHex2Bin(hex: String): String {
        return Integer.toBinaryString(Integer.parseInt(hex, 16))
    }

    public fun synchronizeFromBin() {
        var bin_value = input_binary.text.split("0b").last()
        input_decimal.setText(fromBin2Dec(bin_value).toString())
        input_hexa.setText("0x" + fromBin2Hex(bin_value))
    }

    public fun synchronizeFromDec() {
        var dec_value = input_decimal.text.toString().toInt()
        input_binary.setText("0b" + fromDec2Bin(dec_value))
        input_hexa.setText("0x" + fromDec2Hex(dec_value))
    }

    public fun synchronizeFromHex() {
        var hex_value = input_hexa.text.split("0x").last()
        input_binary.setText("0b" + fromHex2Bin(hex_value))
        input_decimal.setText(fromHex2Dec(hex_value).toString())
    }

}