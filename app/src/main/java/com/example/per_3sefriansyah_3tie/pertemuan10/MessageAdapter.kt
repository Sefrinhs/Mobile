package com.example.per_3sefriansyah_3tie.pertemuan10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.per_3sefriansyah_3tie.R
import com.example.per_3sefriansyah_3tie.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>,
    private val onItemClick: ((MessageModel) -> Unit)? = null
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = if (convertView == null) {
            ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemMessageBinding.bind(convertView)
        }
        val view = binding.root

        val data = messages[position]

        Glide.with(context)
            .load(data.avatarUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText

        view.setOnClickListener {
            if (onItemClick != null) {
                onItemClick.invoke(data)
            } else {
                Toast.makeText(
                    context,
                    "Pesan dari ${data.senderName}: ${data.messageText}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return view
    }
}
