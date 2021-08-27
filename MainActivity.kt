package com.example.s160419103_spongebobquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var currentQuestion = 0;
    //Question banks
    val questions = arrayOf(
        Question("Krusty Krab is the favorite burger in Bikini Bottom", false),
        Question("Spongebob lives in a pineapple under the sea", true),
        Question("Karen is Plankton's wife", true),
        Question("Mermaid Man was once a superhero of Bikini Bottom", true),
        Question("Squidward has four hands", false)
    )
    val randomQuestion = questions.random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textQuestion.text = randomQuestion.question

        //Listener button true
        buttonTrue.setOnClickListener {
            if(questions[currentQuestion].answer){
                Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Incorrect",Toast.LENGTH_SHORT).show()
            }
            currentQuestion++ // postfix unary operators ++
            textQuestion.text = questions[currentQuestion].question
        }

        //Listener button false
        buttonFalse.setOnClickListener {
            Toast.makeText(this,
                if(questions[currentQuestion].answer)"Incorrect" else  "Correct",
                Toast.LENGTH_SHORT
                ).show()

            // prefix unary operator ++
            textQuestion.text = questions[++currentQuestion].question
        }
    }
}