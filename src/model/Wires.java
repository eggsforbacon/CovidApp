package model;

import java.util.*;
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

  public static void inputMaterials(Scanner in) {

    System.out.println("Ingrese la cantidad de materiales distintos solicitados:\n");
    int matCount = in.nextInt();
    String[] matNames = new String[matCount];
    int[] howMany = new int[matCount];
    int[] matPurpose = new int[matCount];

    for (int i = 0; i < matCount; i++) {
      System.out.println("************************************************");
      System.out.println("Ingrese el NOMBRE del siguiente material\n");
      matNames[i] = in.nextLine();
      matNames[i] = matNames[i].toLowerCase();
      in.nextLine();
      System.out.println("Ingrese la CANTIDAD del material solicitado\n");
      howMany[i] = in.nextInt();
      System.out.println("Ingrese el PROPOSITO [1 = Obra Negra; 2 = Obra Blanca; 3 = Pintura] del material solicitado\n");
      matPurpose[i] = in.nextInt();
      System.out.println("Material registrado con exito!");
    }
  }

  public static int[][] inputPrices(Scanner in, String[] matNames) {
    int[][] prices = new int[3][matNames.length];
    for (int j = 0; j < 3; j++) {
      for (int k = 0; k < matNames.length; k++) {
        System.out.println("Ingrese el valor de \"" + matNames[k] + "\" en la ferreteria \"" + HARDWARE_SHOP[j] + "\"");
        prices[j][k] = in.nextInt();
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

  public static int[] whereBuy(Scanner in, int[][] prices, String[] matNames) {
    System.out.println("Ingrese el lugar del inmueble [1 = Norte; 2 = Centro; 3 = Sur]\n");
    int where = in.nextInt() - 1;
    int[] buyHere = new int[matNames.length];
    boolean valid = (where <= 3 && where >= 1);
    while (valid == false) {
      System.out.println("Valor invalido. Reintentar:\n");
      where = in.nextInt();
      valid = (where <= 3 && where >= 1);
    }
    return buyHere;
  }
}
