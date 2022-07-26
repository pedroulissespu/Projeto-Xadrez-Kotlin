package com.game.xadrez

class ModeloXadrez {
    var espacopeca = mutableSetOf<PecaXadrez>()

    init{
        reset()
    }

    fun reset(){
        espacopeca.removeAll(espacopeca)
        for(i in 0..1) {
            espacopeca.add(PecaXadrez(0+i*7, 0, Player.WHITE, Rank.TORRE,R.drawable.chess_rlt60))
            espacopeca.add(PecaXadrez(0+i*7, 7, Player.BLACK, Rank.TORRE,R.drawable.chess_rdt60))

            espacopeca.add(PecaXadrez(1+i*5, 0, Player.WHITE, Rank.CAVALO,R.drawable.chess_nlt60))
            espacopeca.add(PecaXadrez(1+i*5, 7, Player.BLACK, Rank.CAVALO,R.drawable.chess_ndt60))

            espacopeca.add(PecaXadrez(2+i*3, 0, Player.WHITE, Rank.BISPO,R.drawable.chess_blt60))
            espacopeca.add(PecaXadrez(2+i*3, 7, Player.BLACK, Rank.BISPO,R.drawable.chess_bdt60))
        }

        for(i in 0..7){
            espacopeca.add(PecaXadrez(i, 1, Player.WHITE, Rank.PEÃO,R.drawable.chess_plt60))
            espacopeca.add(PecaXadrez(i, 6, Player.BLACK, Rank.PEÃO,R.drawable.chess_pdt60))
        }

        espacopeca.add(PecaXadrez(3, 0, Player.WHITE, Rank.RAINHA,R.drawable.chess_qlt60))
        espacopeca.add(PecaXadrez(3, 7, Player.BLACK, Rank.RAINHA,R.drawable.chess_qdt60))

        espacopeca.add(PecaXadrez(4, 0, Player.WHITE, Rank.REI,R.drawable.chess_klt60))
        espacopeca.add(PecaXadrez(4, 7, Player.BLACK, Rank.REI,R.drawable.chess_kdt60))
    }

    fun pieceAt(col: Int , row : Int) : PecaXadrez?{
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
                    descricao += " "
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