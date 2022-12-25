package com.iparcoc.practicaivanpardal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iparcoc.practicaivanpardal.databinding.ActivityMainBinding
import com.iparcoc.practivaivanpardal.QuestionAndAnswerApp
import com.iparcoc.practivaivanpardal.database.entities.AnswerEntity
import com.iparcoc.practivaivanpardal.database.entities.QuestionEntity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var questions: MutableList<QuestionEntity>
    lateinit var currentQuestion: QuestionEntity
    var nQuestion: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Ejecutar esto para la primera vez y rellenar las tablas
        //initDB()

        // las siguientes veces comentar lo anterior y descomentar este
        getQuestions()

    }

    fun getQuestions() {
        doAsync {
            questions = QuestionAndAnswerApp.database.QuestionDao().getAllQuestions()
            uiThread {
                initTest()
            }
        }
    }

    fun initDB() {
        doAsync {
            initTables()
        }
    }

    fun initTest() {
        currentQuestion = questions[nQuestion]
        binding.tvPregunta.text = nQuestion.toString()
        binding.tvEnunciadoPregunta.text = currentQuestion.pregunta
        // write the answers in buttons

    }

    fun nextQuestion() {
        nQuestion = nQuestion + 1
        currentQuestion = questions[nQuestion]
        binding.tvPregunta.text = nQuestion.toString()
        binding.tvEnunciadoPregunta.text = currentQuestion.pregunta
    }

    fun initTables() {
        QuestionAndAnswerApp.database.QuestionDao()
            .addQuestion(QuestionEntity(1, "¿Capital de Alemania?", "img_alemania.jpg"))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(1, "Munich", "1", false))
        QuestionAndAnswerApp.database.AnswerDao()
            .addAnswer(AnswerEntity(2, "Auschwitz", "1", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(3, "Winden", "1", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(4, "Berlin", "1", true))

        QuestionAndAnswerApp.database.QuestionDao()
            .addQuestion(QuestionEntity(2, "¿Capital de Austria?", "img_austria.jpg"))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(5, "Viena", "2", true))
        QuestionAndAnswerApp.database.AnswerDao()
            .addAnswer(AnswerEntity(6, "Salzburgo", "2", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(7, "Innsburg", "2", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(8, "Graz", "2", false))

        QuestionAndAnswerApp.database.QuestionDao()
            .addQuestion(QuestionEntity(3, "¿Capital de Belgica?", "img_belgica.jpg"))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(9, "Amberes", "3", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(10, "Gante", "3", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(11, "Brujas", "3", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(12, "Bruselas", "3", true))

        QuestionAndAnswerApp.database.QuestionDao()
            .addQuestion(QuestionEntity(4, "¿Capital de Bulgaria?", "img_bulgaria.jpg"))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(13, "Plovdiv", "4", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(14, "Sofía", "4", true))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(15, "Varna", "4", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(16, "Burgas", "4", false))

        QuestionAndAnswerApp.database.QuestionDao()
            .addQuestion(QuestionEntity(5, "¿Capital de Chipre?", "img_chipre.jpg"))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(17, "Nicosia", "5", true))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(18, "Pafos", "5", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(19, "Lárnaca", "5", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(20, "Limasol", "5", false))

        QuestionAndAnswerApp.database.QuestionDao()
            .addQuestion(QuestionEntity(6, "¿Capital de Croacia?", "img_croacia.jpg"))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(21, "Zadar", "6", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(22, "Split", "6", false))
        QuestionAndAnswerApp.database.AnswerDao()
            .addAnswer(AnswerEntity(23, "Dubrovnik", "6", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(24, "Zagreb", "6", true))

        QuestionAndAnswerApp.database.QuestionDao()
            .addQuestion(QuestionEntity(7, "¿Capital de Dinamarca?", "img_dinamarca.jpg"))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(25, "Aarhus", "7", false))
        QuestionAndAnswerApp.database.AnswerDao().addAnswer(AnswerEntity(26, "Odense", "7", false))
        QuestionAndAnswerApp.database.AnswerDao()
            .addAnswer(AnswerEntity(27, "Copenhague", "7", false))
        QuestionAndAnswerApp.database.AnswerDao()
            .addAnswer(AnswerEntity(28, "Frederiksberg", "7", false))

    }
}