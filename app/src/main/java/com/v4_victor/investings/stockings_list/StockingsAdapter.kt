package com.v4_victor.investings.stockings_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.v4_victor.investings.R
import com.v4_victor.investings.Stock
import com.v4_victor.investings.databinding.ListItemBinding

class StockingsAdapter(
    private val onClickListener: OnClickListener
) : ListAdapter<Stock, RecyclerView.ViewHolder>(REPO_COMPARATOR) {
    class ViewHolder private constructor(private val binding: ListItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Stock) {
            val url = "https://finnhub.io/api/logo?symbol=${item.title}"
            Glide.with(context)
                .load(url)
                .error(R.drawable.ic_broken)
                .into(binding.imageView)
            binding.symbol.text = item.title
            binding.currentPrice.text = item.currentPrice
            binding.fullName.text = item.fullTitle
            binding.openPrice.text = item.openPrice
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    ListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding, parent.context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(repoItem)
        }
        if (repoItem != null) {
            (holder as ViewHolder).bind(repoItem)
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Stock>() {
            override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean =
                 oldItem.currentPrice == newItem.currentPrice
        }
    }

    class OnClickListener(val clickListener: (stock: Stock) -> Unit) {
        fun onClick(stock: Stock) = clickListener(stock)
    }

}