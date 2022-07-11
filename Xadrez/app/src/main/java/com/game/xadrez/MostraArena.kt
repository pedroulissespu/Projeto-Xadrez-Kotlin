package com.game.xadrez

import android.view.View
import android.content.Context
import android.graphics.*
import android.util.AttributeSet

class MostraArena(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private final val cellSide: Float = 130f
    private final val originX = 20f
    private final val originY = 200f

    override fun onDraw(canvas: Canvas?){
        val paint = Paint()
        for(i in 0..7) {
            for (j in 0..7) {
                paint.color = if((i + j) % 2 == 1) Color.DKGRAY else Color.LTGRAY
                canvas?.drawRect(
                    originX + i * cellSide,
                    originY + j * cellSide,
                    originX + (i + 1) * cellSide,
                    originY + (j + 1) * cellSide,
                    paint
                )
            }
        }

        val rainhaBrancaBitmap = BitmapFactory.decodeResource(resources,R.drawable.chess_qlt60)
        canvas?.drawBitmap(rainhaBrancaBitmap, null, Rect(0,0,600,600),paint)
    }
}