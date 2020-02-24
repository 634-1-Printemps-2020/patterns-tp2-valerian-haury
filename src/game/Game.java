package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Map<Player, List<CoinState>> history;

    public Game() {
        history = new HashMap<>();
        this.coin = Coin.getInstance();
        this.rules = Rules.getInstance();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
      // TODO: Votre code ici - DONE
        history.put(player, new ArrayList<>());
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
      // TODO: Votre code ici
        List<CoinState> currentCointState;
        for (Player player: history.keySet()) {
            currentCointState = new ArrayList<>();
            while(!rules.checkWin(currentCointState)) {
                coin.throwCoin();
                currentCointState.add(coin.getState());
            }
            history.put(player,currentCointState);
        }
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
      // TODO: Votre code ici

        // Le nombre le plus petit de lancers pour avoir gagné une partie
        int fewerMovesToWin = history.get(history.keySet().toArray()[0]).size();

        for (Player player: history.keySet()) {
            int currentFewerMovesToWin = history.get(player).size();
            if(currentFewerMovesToWin < fewerMovesToWin)
                fewerMovesToWin = currentFewerMovesToWin;
        }

        // Le nombre le plus grand de lancers pour avoir gagné une partie
        int mostMovesToWin = history.get(history.keySet().toArray()[0]).size();;

        for (Player player: history.keySet()) {
            int currentMostMoveToWin = history.get(player).size();
            if(currentMostMoveToWin > mostMovesToWin)
                mostMovesToWin = currentMostMoveToWin;
        }

        // Nombre total de lancers pour tous les joueurs
        int totalNumberMoves = 0;
        for (Player player: history.keySet()) {
            totalNumberMoves += history.get(player).size();
        }

        // Le nombre moyen de lancers pour gagner une partie
        float averageToWin = totalNumberMoves / (float)history.keySet().size();

      return new Statistics(averageToWin, fewerMovesToWin, mostMovesToWin, totalNumberMoves);
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      // TODO: Votre code ici- DONE
      return this.history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      // TODO: Votre code ici- DONE
      return this.history.get(player);
    }

}
