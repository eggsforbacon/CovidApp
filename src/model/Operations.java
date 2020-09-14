package model;

import java.util.*;
import java.io.IOException;
public class Operations {

  public static final int UNDER_CONSTRUCTION = 1300000;
  public static final int WHITE_WORK = 2600000;
  public static final int PAINTJOB = 980000;
  public static final String[] HARDWARE_SHOP = {"HomeCenter","Ferreteria del Centro","Ferreteria del Barrio"};
  public static final int[][] DELIVERY = {
    {120000,28000,0},
    {50000,0,0},
    {120000,55000,0}
  };
  /**
  Clears the console. <br>
  <b>pre: </b> The user is using a Windows. <br>
  <b>post: </b> The console is clear.
  */
  public static void clsm() {
    try {
      new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
  Gets the Prices per shop into the program. <br>
  <b>pre: </b> <br>
  <b>post: </b> The prices are now stored in the program. <br>
  @param in Scanner object that allows input to be captured in != null <br>
  @param matNames String array that holds the names of the materials matNames != null && /forall x in matNames x!= "" <br>
  @param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials prices != null && /forall x in prices x!= String <br>
  */
  public static int[][] inputPrices(int i, Scanner in, String[] matNames, int[][] prices) {
    clsm();
    for (int j = 0; j < HARDWARE_SHOP.length; j++) {
        System.out.println("Ingrese el valor POR UNIDAD de \"" + matNames[i] + "\" en la ferreteria \"" + HARDWARE_SHOP[j] + "\"");
        prices[j][i] = in.nextInt();
        clsm();
      }
    return prices;
  }

  /**
  Calculates the total prices per hardware shop <br>
  <b>pre: </b> The array prices should be properly initialized. <br>
  <b>post: </b> The method will return the array containing the total pricing for each hardware shop. <br>
  @param in Scanner object that allows input to be captured in != null <br>
  @param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials prices != null && /forall x in prices x != String <br>
  @param quantityPurpose Integer 2D array that holds 2 arrays, one with the quantity and the other with the purpose of each material quantityPurpose !null && /forall x in quantityPurpose x != String <br>
  */
  public static int[] calcTotalPrice(Scanner in, int[][] prices, int[][] quantityPurpose) {
    int[] totPrices = new int[HARDWARE_SHOP.length];
    for (int l = 0; l < HARDWARE_SHOP.length; l++) {
      boolean uc = false;
      boolean ww = false;
      boolean pj = false;
      for (int m = 0; m < quantityPurpose[0].length; m++) {
        totPrices[l] += prices[l][m] * quantityPurpose[0][m];
        if (quantityPurpose[1][m] == 1 && uc == false) {
          totPrices[l] += UNDER_CONSTRUCTION;
          uc = true;
        }
        else if (quantityPurpose[1][m] == 2 && ww == false) {
          totPrices[l] += WHITE_WORK;
          ww = true;
        }
        else if (quantityPurpose[1][m] == 3 && pj == false) {
          totPrices[l] += PAINTJOB;
          pj = true;
        }
      }
    }
    return totPrices;
  }

  public static int[][] whereBuy(Scanner in, int[][] prices, String[] matNamesUnit) {
    System.out.println("Ingrese el lugar del inmueble [1 = Norte; 2 = Centro; 3 = Sur]\n");
    int where = in.nextInt() - 1;
    int[][] buyHere = new int[3][matNamesUnit.length];
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

  public static String[][] inputNames(int i,Scanner in, int matCount, String[][] matNamesUnit) {
    clsm();
    System.out.println("************************************************");
    System.out.println("Ingrese el NOMBRE del siguiente material seguido de su UNIDAD DE MEDIDA\n");
    matNamesUnit[0][i] = in.next();
    in.nextLine();
    matNamesUnit[0][i] = matNamesUnit[0][i].toLowerCase();
    System.out.println("************************************************");
    matNamesUnit[1][i] = in.nextLine();
    matNamesUnit[1][i] = matNamesUnit[1][i].toLowerCase();
    clsm();
    return matNamesUnit;
  }

  public static int[][] quantityType(int i, Scanner in, int matCount, int[][] quantityPurpose) {
    clsm();
    System.out.println("************************************************");
    System.out.println("Ingrese la CANTIDAD del material solicitado\n");
    quantityPurpose[0][i] = in.nextInt();
    clsm();
    System.out.println("Ingrese el PROPOSITO [1 = Obra Negra; 2 = Obra Blanca; 3 = Pintura] del material solicitado\n");
    quantityPurpose[1][i] = in.nextInt();
    return quantityPurpose;
  }
}
