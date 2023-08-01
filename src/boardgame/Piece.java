package boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    //  Testar se uma peça pode mover para uma dada posição
//  método concreto que utiliza um método abstrato(hook method). retorna o método
//  possibleMoves, nas linhas e colunas da classe Position
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    //  método que verifica se existe pelomenos um movimento possível para
//  determinada peça. Útil para ver se a peça está travada, sem movimento.
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
