package model;

import java.util.*;
import java.io.IOException;
public class Wires {

  static final int UNDER_CONSTRUCTION = 1300000;
  static final int WHITE_WORK = 2600000;
  static final int PAINTJOB = 980000;
  static final String[] HARDWARE_SHOP = {"HomeCenter","Ferreteria del Centro","Ferreteria del Barrio"};
  static final int[][] DELIVERY = {
    {120000,28000,0},
    {50000,0,0},
    {120000,55000,0}
  };

  public static void clsm() {
    try {
      new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  public static int[][] inputPrices(Scanner in, String[] matNames, Wires methNester) {
    int[][] prices = new int[3][matNames.length];
    for (int j = 0; j < 3; j++) {
      for (int k = 0; k < matNames.length; k++) {
        System.out.println("Ingrese el valor de \"" + matNames[k] + "\" en la ferreteria \"" + HARDWARE_SHOP[j] + "\"");
        prices[j][k] = in.nextInt();
        methNester.clsm();
      }
    }
    return prices;
  }

  public static int[] calcTotalPrice(Scanner in, int[][] prices, int[] matPurpose) {
    int[] totPrices = new int[HARDWARE_SHOP.length];
    for (int l = 0; l < HARDWARE_SHOP.length; l++) {
      for (int m = 0; m < matPurpose.length; m++) {
        switch (matPurpose[m]) {
          case 1:
            prices[l][m] *= UNDER_CONSTRUCTION;
            totPrices[l] += prices[l][m];
            break;
          case 2:
            prices[l][m] *= WHITE_WORK;
            totPrices[l] += prices[l][m];
            break;
          case 3:
            prices[l][m] *= PAINTJOB;
            totPrices[l] += prices[l][m];
            break;
          default:
            break;
        }
      }
    }
    return totPrices;
  }

  public static int[][] whereBuy(Scanner in, int[][] prices, String[] matNames) {
    System.out.println("Ingrese el lugar del inmueble [1 = Norte; 2 = Centro; 3 = Sur]\n");
    int where = in.nextInt() - 1;
    int[][] buyHere = new int[3][matNames.length];
    boolean valid = (where <= 3 && where >= 1);
    while (valid == false) {
      System.out.println("Valor invalido. Reintentar:\n");
      where = in.nextInt();
      valid = (where <= 3 && where >= 1);
    }
    for (int n = 0; n < HARDWARE_SHOP.length; n++) {
      for (int o = 0; o < buyHere[0].length; o++) {

      }
    }
    return buyHere;
  }
}
