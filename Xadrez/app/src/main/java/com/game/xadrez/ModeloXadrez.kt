package com.game.xadrez

class ModeloXadrez {
    var espacopeca = mutableSetOf<PecaXadrez>()

    init{
        espacopeca.add(PecaXadrez(0,0,Player.WHITE, Rank.TORRE))
        espacopeca.add(PecaXadrez(0,7,Player.BLACK, Rank.TORRE))
    }

    private fun pieceAt(col: Int , row : Int) : PecaXadrez?{
        for(piece in espacopeca){
            if(col == piece.col && row == piece.row){
                return piece
            }
        }
        return null
    }

    override fun toString(): String{
        var descricao = " \n"
        for(row in 7 downTo 0){
            val r = 7-row
            descricao += "$r"
            for(col in 0..7){
                val piece = pieceAt(col,row)
                if(piece == null) {
                    descricao += " ."
                } else{
                    val white = piece.player == Player.WHITE
                    descricao += ""
                    descricao += when(piece.rank) {
                        Rank.REI -> {
                            if(white) "k" else "K"
                        }
                        Rank.RAINHA -> {
                            if(white) "q" else "Q"
                        }
                        Rank.BISPO -> {
                            if(white) "b" else "B"
                        }
                        Rank.TORRE -> {
                            if(white) "t" else "T"
                        }
                        Rank.CAVALO -> {
                            if(white) "c" else "C"
                        }
                        Rank.PEÃO -> {
                            if(white) "p" else "P"
                        }
                    }
                }
            }
            descricao+= "\n"
        }
        descricao += " 0 1 2 3 4 5 6 7"
        return descricao
    }
}