package materials;

import java.util.Random;

public class Coin {

  private CoinState coinState;
  private static Coin singleton;

  public static Coin getInstance() {
    if (singleton == null)
      singleton = new Coin();
    return singleton;
  }
  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    // TODO : Votre code ici - DONE
    Random random = new Random();
    if(random.nextBoolean())
      coinState = CoinState.HEADS;
    else
      coinState = CoinState.TAILS;
  }

  public CoinState getState() {
    return coinState;
  }


}
