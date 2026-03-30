package domain.players;

import domain.piece.Side;
import domain.player.Player;
import domain.position.Move;

public class Players {
    private final Player choPlayer;
    private final Player hanPlayer;
    private Side currentTurn;

    public Players(Player choPlayer, Player hanPlayer) {
        this.choPlayer = choPlayer;
        this.hanPlayer = hanPlayer;
        this.currentTurn = Side.CHO;
    }

    public void initPlacementBySide(Side side, int placementCode) {
        // if side placement 받아서 side가 한이면
        if (side == Side.HAN) {
            hanPlayer.initBoard(placementCode);
        }
        if (side == Side.CHO) {
            choPlayer.initBoard(placementCode);
        }
    }

    public BoardResponseDto findBoardState() {
        return hanPlayer.findBoardState();
    }

    public void playTurn(Board board, Move move) {
        Player currentPlayer = getCurrentPlayer();
        currentPlayer.play(board, move);
        currentTurn = currentTurn.next();
    }

    private Player getCurrentPlayer() {
        if (currentTurn == Side.CHO) return choPlayer;
        return hanPlayer;
    }
}
