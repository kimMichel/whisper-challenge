package br.com.homegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.homegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lastWord: String = wordList.random()

        binding.gameText.text = lastWord

        binding.gameNextButton.setOnClickListener {
            binding.gameText.text = wordList.random()
        }
    }

    val wordList: List<String> = listOf(
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
}