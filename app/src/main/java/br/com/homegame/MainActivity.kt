package br.com.homegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.homegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val wordList: List<String> = listOf(
        "Abacate",
        "Girassol",
        "Chocolate",
        "Elefante",
        "Avião",
        "Gelo",
        "Violão",
        "Computador",
        "Montanha",
        "Palmeira"
    )
    private val lastWord: String = wordList.random()
    private var initialPoint: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gameText.text = lastWord

        binding.gameNextButton.setOnClickListener {
            binding.gameText.text = showNextWord(wordList, lastWord)
        }
        binding.gameCorrectButton.setOnClickListener {
            initialPoint += 1
            binding.gamePointValue.text = initialPoint.toString()
            binding.gameText.text = showNextWord(wordList, lastWord)
        }
        binding.gameResetButton.setOnClickListener {
            initialPoint = 0
            binding.gamePointValue.text = initialPoint.toString()
            binding.gameText.text = showNextWord(wordList, lastWord)
        }
    }

    private fun showNextWord(wordList: List<String>, lastWord: String): String {
        var word: String
        do {
            word = wordList.random()
        } while (word == lastWord)
        return word
    }
}