package game;

import materials.CoinState;

import java.util.List;

public class Rules {

  static Rules singleton = null;

  public static Rules getInstance() {
    if(singleton == null)
      singleton = new Rules();
    return singleton;
  }

  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    // TODO: Votre code ici - DONE
    int headsCounter = 0;

    for (CoinState coinState: states) {
      if(coinState == CoinState.HEADS)
        headsCounter++;
      else
        headsCounter = 0;
    }

    return headsCounter >= 3 ? true : false;
  }
}
