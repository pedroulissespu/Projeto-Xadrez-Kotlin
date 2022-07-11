package com.game.xadrez

import android.view.View
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet

class MostraArena(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private final val cellSide: Float = 130f
    private final val originX = 20f
    private final val originY = 200f

    override fun onDraw(canvas: Canvas?){
        val paint = Paint()
        for(j in 0..3) {
            for (i in 0..3) {
                paint.color = Color.LTGRAY
                canvas?.drawRect(
                    originX + 2 * i * cellSide,
                    originY + 2 * j * cellSide,
                    originX + (2 * i + 1) * cellSide,
                    originY + (2 * j + 1) * cellSide,
                    paint
                )

                canvas?.drawRect(
                    originX + (2 * i + 1) * cellSide,
                    originY + (2 * j + 1) * cellSide,
                    originX + (2 * i + 2) * cellSide,
                    originY + (2 * j + 2) * cellSide,
                    paint
                )

                paint.color = Color.DKGRAY
                canvas?.drawRect(
                    originX + (2 * i + 1) * cellSide,
                    originY + 2 * j * cellSide,
                    originX + (2 * i + 2) * cellSide,
                    originY + (2 * j + 1) * cellSide,
                    paint
                )

                canvas?.drawRect(
                    originX + (2 * i) * cellSide,
                    originY + (2 * j + 1) * cellSide,
                    originX + (2 * i + 1) * cellSide,
                    originY + (2 * j + 2) * cellSide,
                    paint
                )
            }
        }
    }
}