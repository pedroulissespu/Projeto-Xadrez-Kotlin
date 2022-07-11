package com.game.xadrez

class ModeloXadrez {
    var espacopeca = mutableSetOf<PecaXadrez>()

    init{
        espacopeca.add(PecaXadrez(0,0,Player.WHITE, Rank.TORRE))
    }

    override fun toString(): String{
        var descricao = " \n"
        for(row in 7 downTo 0){
            val r = 7-row
            descricao += "$r"
            for(col in 0..7){
                descricao += " ."
            }
            descricao+= "\n"
        }
        descricao += " 0 1 2 3 4 5 6 7"
        return descricao
    }
}