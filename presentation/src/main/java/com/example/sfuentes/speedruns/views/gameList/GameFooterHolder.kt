package com.example.sfuentes.speedruns.views.gameList

import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.sfuentes.speedruns.R
import kotlinx.android.synthetic.main.generic_footer.view.*

class GameFooterHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    fun bindProgressBar() {
        itemView.footerProgressBar.indeterminateDrawable.setColorFilter(ContextCompat.getColor(itemView.context, R.color.white), PorterDuff.Mode.MULTIPLY)
    }

}