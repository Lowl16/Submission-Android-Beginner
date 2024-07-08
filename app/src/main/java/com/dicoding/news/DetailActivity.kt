package com.dicoding.news

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.news.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "News Detail"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val selectedNews = intent.getParcelableExtra<News>("selected_news")

        if (selectedNews != null) {
            binding.tvNewsTitle.text = selectedNews.title
            binding.tvNewsDescription.text = selectedNews.description
            binding.tvNewsCategory.text = selectedNews.category
            binding.tvNewsTime.text = selectedNews.time
            binding.tvNewsWriter.text = selectedNews.writer
            Glide.with(this)
                .load(selectedNews.photo)
                .into(binding.imgNewsPhoto)
        }

        binding.actionShare.setOnClickListener {
            shareNews(selectedNews)
        }
    }

    private fun shareNews(news: News?) {
        val shareText = "Baca berita terbaru ini: ${news?.link}"

        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}