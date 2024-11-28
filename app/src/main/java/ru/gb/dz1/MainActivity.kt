package ru.gb.dz1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.gb.dz1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var counter = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.minusButton.isEnabled = false
        binding.countInCenter.text = counter.toString()

        binding.plusButton.setOnClickListener {
            binding.minusButton.isEnabled = true
            counter++
            binding.textInCenter.text = "${getText(R.string.message_free)}" + " ${50 - counter}"
            binding.countInCenter.text = counter.toString()
            binding.textInCenter.setTextColor(Color.BLUE)
            if (counter >= 50) {
                binding.resetButton.visibility = View.VISIBLE
                binding.textInCenter.setTextColor(Color.RED)
            }
        }

        binding.minusButton.setOnClickListener {
            counter--
            binding.textInCenter.text = "${getText(R.string.message_free)}" + " ${50 - counter}"
            binding.countInCenter.text = counter.toString()
            if (counter < 50) {
                binding.resetButton.visibility = View.INVISIBLE
                binding.textInCenter.setTextColor(Color.BLUE)
            }
            if (counter == 0) {
                binding.minusButton.isEnabled = false
                binding.textInCenter.setTextColor(Color.GREEN)
                binding.textInCenter.text = getText(R.string.message)
            }
        }

        binding.resetButton.setOnClickListener {
            counter = 0
            binding.countInCenter.text = counter.toString()
            binding.resetButton.visibility = View.INVISIBLE
            binding.minusButton.isEnabled = false
            binding.textInCenter.setTextColor(Color.GREEN)
            binding.textInCenter.text = getText(R.string.message)
        }
    }
}

