package com.game.xadrez

import android.view.View
import android.content.Context
import android.graphics.*
import android.util.AttributeSet

class MostraArena(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private final val cellSide: Float = 130f
    private final val originX = 20f
    private final val originY = 200f
    private final val imgResIDs = setOf(
        R.drawable.chess_rdt60,
        R.drawable.chess_rlt60,
        R.drawable.chess_qlt60,
        R.drawable.chess_qdt60,
        R.drawable.chess_plt60,
        R.drawable.chess_pdt60,
        R.drawable.chess_nlt60,
        R.drawable.chess_ndt60,
        R.drawable.chess_klt60,
        R.drawable.chess_kdt60,
        R.drawable.chess_blt60,
        R.drawable.chess_bdt60
        )
    private final val bitmaps = mutableMapOf<Int, Bitmap>()
    private final val paint = Paint()

    init{
        carregaBitmaps()
    }

    override fun onDraw(canvas: Canvas?){
        desenhaTabuleiroXadrez(canvas)
        desenhaPecas(canvas)
    }

    private fun desenhaPecas(canvas: Canvas?){
        drawPiecesAt(canvas,0,0,R.drawable.chess_rlt60)
        drawPiecesAt(canvas,0,1,R.drawable.chess_plt60)
    }

    private fun drawPiecesAt(canvas : Canvas? , col: Int , row : Int , resID: Int){
        val bitmap = bitmaps[resID]!!
        canvas?.drawBitmap(bitmap, null, RectF(originX + col * cellSide,originY + (7 - row) * cellSide,originX + (col + 1) * cellSide,originY + ((7 - row) + 1) * cellSide),paint)
    }

    private fun carregaBitmaps(){
        imgResIDs.forEach{
            bitmaps[it] = BitmapFactory.decodeResource(resources,it)
        }
    }

    private fun desenhaTabuleiroXadrez(canvas: Canvas?){
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
    }
}