package com.sergiollull.calculatorapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sergiollull.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : AppCompatActivity() {
    private var canAddOperation = false
    private var canAddDecimal = true
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var workingsTV= findViewById(R.id.workingsTV) as TextView
        var resultTV= findViewById(R.id.resultsTV) as TextView
        var backSpaceAction= findViewById(R.id.backSpaceAction) as Button
        fun allClearAction(view: View){
            workingsTV.text= ""
            resultTV.text=""
        }
        fun backSpaceAction(view: View){
            val length=workingsTV.length()
            if (length>0)
                workingsTV.text= workingsTV.text.subSequence(0,length-1)
        }
        fun numberAction(view: View){
            if(view is Button)
            {
                if (view.text =="."){
                    if (canAddDecimal)
                        workingsTV.append(view.text)
                    canAddDecimal=false
                }else{
                    workingsTV.append(view.text)
                    canAddOperation=true

                }
            }
        }
        fun operationAction(view:View){
            if (view is Button && canAddOperation){
                workingsTV.append(view.text)
                canAddOperation=false
            }
        }
    }

}
