package jp.techacademy.kenichi.nadaya.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.content.Intent


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(v: View){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)


        val a = editText1.text.toString()
        val b = editText2.text.toString()
        var ans :Double? = null

        if (v.id == R.id.button1) {
            val (ed_a,ed_b) = check(a,b)
            ans = ed_a + ed_b
        }else if(v.id == R.id.button2) {
            val (ed_a,ed_b) = check(a,b)
            ans = ed_a - ed_b
        }else if(v.id == R.id.button3) {
            val (ed_a,ed_b) = check(a,b)
            ans = ed_a * ed_b
        }else if(v.id == R.id.button4) {
            if (b=="0"){
                ans = null
            }else{
                val (ed_a,ed_b) = check(a,b)
                ans = ed_a / ed_b
            }
        }
        Log.d("cal","答え：" + ans)
        intent.putExtra("answer", ans)
        startActivity(intent)

    }

    private fun check(a: String,b:String):Pair<Double, Double>{
        val edit_a :Double
        val edit_b :Double

        if(a==""){
            edit_a= 0.0
        }else{
            edit_a = a.toDouble()
        }
        if(b==""){
            edit_b= 0.0
        }else{
            edit_b = a.toDouble()
        }
        return Pair(edit_a, edit_b)
    }
}