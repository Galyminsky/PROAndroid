package com.example.proandroid.ui

import android.annotation.SuppressLint
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.model.MeaningsEntity
import com.example.proandroid.R
import com.example.proandroid.utils.concatWithRoundBrackets
import com.example.proandroid.utils.toUrl
import com.example.proandroid.utils.viewById

class DetailAdapter(private var onListItemClick: (String) -> Unit) :
    RecyclerView.Adapter<DetailViewHolder>() {
    private var list: List<MeaningsEntity> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<MeaningsEntity>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DetailViewHolder(parent)
    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) =
        holder.bind(list[position], onListItemClick)

    override fun getItemCount() = list.size
}

class DetailViewHolder(private val parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_detail_meaning, parent, false)
) {
    private val itemDetailTranslationTextView by viewById<TextView>(R.id.item_detail_translation_text_view)
    private val itemDetailTranscriptionTextView by viewById<TextView>(R.id.item_detail_transcription_text_view)
    private val itemDetailImageView by viewById<AppCompatImageView>(R.id.item_detail_image_view)
    private val itemDetailSoundButton by viewById<AppCompatImageView>(R.id.item_detail_sound_button)

    fun bind(meaning: MeaningsEntity, onListItemClick: (String) -> Unit) {
        itemDetailTranslationTextView.text =
            meaning.translation.text.concatWithRoundBrackets(meaning.translation.note)
        itemDetailTranscriptionTextView.text = meaning.transcription

        loadImage(meaning.imageUrl.toUrl())
        itemDetailImageView.setOnClickListener { onListItemClick(meaning.imageUrl.toUrl()) }
        setupSoundButton(meaning.soundUrl.toUrl())
    }

    private fun loadImage(url: String) {
        ImageLoader(parent.context).enqueue(
            ImageRequest.Builder(parent.context)
                .data(url)
                .target(
                    onStart = {},
                    onSuccess = { result ->
                        itemDetailImageView.setImageDrawable(result)
                    },
                    onError = {
                        itemDetailImageView.setImageResource(R.drawable.ic_image_not_supported)
                    }
                )
                .build()
        )
    }

    private fun setupSoundButton(url: String) {
        val mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepare()
        }
        itemDetailSoundButton.setOnClickListener { mediaPlayer.start() }
    }
}
