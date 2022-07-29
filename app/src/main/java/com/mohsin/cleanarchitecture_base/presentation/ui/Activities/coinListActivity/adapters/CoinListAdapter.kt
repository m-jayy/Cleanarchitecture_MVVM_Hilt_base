package com.mohsin.cleanarchitecture_base.presentation.ui.Activities.coinListActivity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohsin.cleanarchitecture_base.R
import com.mohsin.cleanarchitecture_base.presentation.ui.customComponents.TextView_N
import com.mohsin.cryptocurrencyappyt.domain.model.Coin


class CoinListAdapter(private val response: ArrayList<Coin?>) : RecyclerView.Adapter<CoinListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.coin_list_row, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        response[position]?.let { responseData ->


            holder.tvName.text = responseData.name
            holder.tvAmountTitle.text = responseData.symbol
            if (responseData.isActive) holder.tvStatus.text = "Active"
            else holder.tvStatus.text = "Not Active"

        }
    }

    override fun getItemCount(): Int {
        return response.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById(R.id.tvName) as TextView_N
        val tvStatus = itemView.findViewById(R.id.tvStatus) as TextView_N
        val tvAmountTitle = itemView.findViewById(R.id.tvAmountTitle) as TextView_N

    }
}