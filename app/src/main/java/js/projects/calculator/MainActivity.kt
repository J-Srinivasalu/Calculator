package js.projects.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import js.projects.calculator.databinding.ActivityMainBinding
import java.text.DecimalFormat
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var isDecimal = false
    private var invalidExpression = false

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Assigning button click for each operand and operator
        //to append the operand or operator to the expression to be evaluated
        binding.apply {


            btn1.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                input.text = input.text.toString() + "1"
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn1.startAnimation(animation)
            }

            btn2.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                input.text = input.text.toString() + "2"
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn2.startAnimation(animation)

            }
            btn3.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                input.text = input.text.toString() + "3"
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn3.startAnimation(animation)
            }
            btn4.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                input.text = input.text.toString() + "4"
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn4.startAnimation(animation)
            }
            btn5.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                input.text = input.text.toString() + "5"
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn5.startAnimation(animation)
            }
            btn6.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                input.text = input.text.toString() + "6"
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn6.startAnimation(animation)
            }
            btn7.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                input.text = input.text.toString() + "7"
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn7.startAnimation(animation)
            }
            btn8.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                input.text = input.text.toString() + "8"
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn8.startAnimation(animation)
            }
            btn9.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                input.text = input.text.toString() + "9"
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn9.startAnimation(animation)
            }
            btn0.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                if(input.text.isBlank()){
                    input.text = input.text.toString() + "0"
                }
                if(input.text.toString() != "0"){
                    input.text = input.text.toString() + "0"
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btn0.startAnimation(animation)
            }
            btnDecimal.setOnClickListener {
                if(input.text.toString() == "Invalid expression") {
                    input.text = ""
                    input.text = "0."
                }
                val str = input.text.toString()
                if (str.isNotBlank() && !isOperator() && str.get(index = str.length-1) != '.') {
                    if (input.text.equals("")) binding.input.text = "0."
                    else input.text = "$str."
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnDecimal.startAnimation(animation)
            }
            btnPlus.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                val str = input.text.toString()
                if(str.isNotBlank() && !isOperator() && str.get(index = str.length-1) != '+'){
                    input.text = input.text.toString() + "+"
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnPlus.startAnimation(animation)
            }
            btnDivide.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                val str = input.text.toString()
                if(str.isNotBlank() && !isOperator() && str.get(index = str.length-1) != '÷'){
                    input.text = input.text.toString() + "÷"
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnDivide.startAnimation(animation)
            }
            btnMinus.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                val str = input.text.toString()
                if(str.isNotBlank() && str.get(index = str.length-1) != '-'){
                    input.text = input.text.toString() + "-"
                }
                if(str.isBlank()){
                    input.text = input.text.toString() + "-"
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnMinus.startAnimation(animation)
            }
            btnMultiply.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                val str = input.text.toString()
                if(str.isNotBlank() && !isOperator() && str.get(index = str.length-1) != 'x'){
                    input.text = input.text.toString() + "x"
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnMultiply.startAnimation(animation)
            }
            btnPercent.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                val str = input.text.toString()
                if(str.isNotBlank() && !isOperator() && str.get(index = str.length-1) != '%'){
                    input.text = input.text.toString() + "%"
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnPercent.startAnimation(animation)
            }
            btnPower.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                val str = input.text.toString()
                if(str.isNotBlank() && !isOperator() && str.get(index = str.length-1) != '^'){
                    input.text = input.text.toString() + "^"
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnPower.startAnimation(animation)
            }
            btnEquals.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                val str = input.text.toString()
                val result = evaluate(str)
                val df = DecimalFormat("#")
                df.maximumFractionDigits = 8
                if(invalidExpression) {
                    val s = "Invalid expression"
                    input.text = s
                    invalidExpression = false
                }
                else{
                    val r = df.format(result).toString()
                    input.text = r
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnEquals.startAnimation(animation)
            }
            btnClear.setOnClickListener {
                input.text = ""
                output.text = ""
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnClear.startAnimation(animation)
            }
            btnBackspace.setOnClickListener {
                if(input.text.toString() == "Invalid expression") input.text = ""
                var str = input.text.toString()
                if(str != ""){
                    str = str.substring(0, str.length-1)
                    input.text = str
                }
                val animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.button_animation)
                btnBackspace.startAnimation(animation)
            }

            input.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun afterTextChanged(p0: Editable?) {
                    val str = input.text.toString()
                    val result = evaluate(str)
                    if(invalidExpression) {
                        output.text = ""
                        invalidExpression = false
                    }
                    else{
                        val r = result.toString()
                        output.text = r
                    }
                }

            })

        }
    }

    private fun isOperator(): Boolean{
        val str = binding.input.text.toString()
        if(str != ""){
            val operator = str.get(index = str.length-1).toString()
            if(operator == "÷" || operator == "x" ||
                operator == "-" || operator == "+" || operator == "%" || operator == "^" ) return true
        }
        return false
    }
    private fun evaluate(s: String): Double {
        val str = s.replace('÷', '/').replace('x', '*')
        return object : Any() {

            var pos = -1 // for tracking current position
            var ch = 0 // for tracking current char value

            // below method is for moving to next character.
            fun nextChar() {
                // incrementing position and moving it to next position.
                ch = if (++pos < str.length) str[pos].code else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()
                // on below line we are checking the char pos
                // if both is equal then we are returning it to true.
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            // method for parsing and returning the ans
            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) invalidExpression = true
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    when {
                        eat('+'.code) -> x += parseTerm() // addition
                        eat('-'.code) -> x -= parseTerm() // subtraction
                        else -> return x
                    }
                }
            }


            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    when {
                        eat('*'.code) -> x *= parseFactor() // multiplication
                        eat('/'.code) -> x /= parseFactor() // division
                        eat('%'.code) -> x *= parseFactor()/100 // percentage
                        else -> return x
                    }
                }
            }

            // method to parse the factor
            fun parseFactor(): Double {
                //performing unary operations.
                if (eat('+'.code)) return parseFactor() // unary plus
                if (eat('-'.code)) return -parseFactor() // unary minus

                var x: Double

                val startPos = pos
                 if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) {
                    // numbers
                    while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) nextChar()
                    // for getting sub string from expression string using start and pos.
                    x = str.substring(startPos, pos).toDouble()
                }else {
                     // if the condition not satisfy then we are returning the exception
                    x = 0.0
                     invalidExpression = true
                }
                // on below line we are calculating the power of the expression.
                if (eat('^'.code)) x = x.pow(parseFactor()) // exponentiation
                return x
            }
            // at last calling a parse for our expression.
        }.parse()
    }
}