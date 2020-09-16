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
  *Clears the console. <br>
  *<b>pre: </b> The user is using a Windows device.<br>
  *<b>post: </b> The console is cleared.<br>
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
  *Method to recieve te location of the construction. <br>
  *<b>pre: </b> <br>
  *<b>post: The location is returned.</b> <br>
  */
  public static int location(Scanner in) {
    System.out.println("Ingrese el lugar del inmueble [1 = Norte; 2 = Centro; 3 = Sur]\n");
    int where = in.nextInt() - 1;
    boolean valid = (where <= 2 && where >= 0);
    while (valid == false) {
      System.out.println("Valor invalido. Reintentar:\n");
      where = in.nextInt() - 1;
      valid = (where <= 2 && where >= 0);
    }
    return where;
  }

  /**
  *Method to input the names of the materials. <br>
  *<b>pre: </b> <br>
  *<b>post: </b> The names are succesfully input into the program. <br>
  *@param in Scanner object that allows input to be captured. in != null.<br>
  *@param matCount Integer that holds the ammount of materials to be inputed. matCount != String. <br>
  *@param matNamesUnit String 2D array that holds 2 arrays, one with the names and the other with the meassure unit for each material. matNamesUnit != null && &forall; x in matNamesUnit x != "".<br>
  */
  public static String[][] inputNames(int i,Scanner in, int matCount, String[][] matNamesUnit) {
    clsm();
    System.out.println("************************************************");
    System.out.println("Ingrese el NOMBRE del siguiente material seguido de su UNIDAD DE MEDIDA\n");
    matNamesUnit[0][i] = in.next();
    in.nextLine();
    matNamesUnit[0][i] = matNamesUnit[0][i];
    System.out.println("************************************************");
    matNamesUnit[1][i] = in.nextLine();
    matNamesUnit[1][i] = matNamesUnit[1][i];
    clsm();
    return matNamesUnit;
  }

  /**
  *Method to input the quantities and types of each material. <br>
  *<b>pre: </b> <br>
  *<b>post: </b> The quantities and the types of each material are succesfully input into the program. <br>
  *@param in Scanner object that allows input to be captured. in != null.<br>
  *@param matCount Integer that holds the ammount of materials to be inputed. matCount != String. <br>
  *@param quantityPurpose Integer 2D array that holds 2 arrays, one with the quantity and the other with the purpose of each material. quantityPurpose != null && &forall; x in quantityPurpose x != String. <br>
  */
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

  /**
  *Gets the Prices per shop into the program.<br>
  *<b>pre: </b> <br>
  *<b>post: </b> The prices are now stored in the program.<br>
  *@param in Scanner object that allows input to be captured. in != null.<br>
  *@param matNames String array that holds the names of the materials. matNames != null and &forall;x in matNames x!= "".<br>
  *@param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials. prices != null and &forall; x in prices x!= String.<br>
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
  *Calculates the total prices per hardware shop.<br>
  *<b>pre: </b> The array prices should be properly initialized.<br>
  *<b>post: </b> The method will return the array containing the total pricing for each hardware shop.<br>
  *@param in Scanner object that allows input to be captured. in != null<br>
  *@param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials. prices != null && &forall; x in prices x != String<br>
  *@param quantityPurpose Integer 2D array that holds 2 arrays, one with the quantity and the other with the purpose of each material. quantityPurpose != null && &forall; x in quantityPurpose x != String<br>
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
  /**
  *Method that returns an array with the best places to buy each material. <br>
  *<b>pre: </b> <br>
  *<b>post: </b> The array is returned and stored . <br>
  *@param in Scanner object that allows input to be captured. in != null<br>
  *@param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials. prices != null && &forall; x in prices x != String<br>
  */
  public static int[] whereBuy(Scanner in, int[][] prices) {
    int[] buyHere = new int[prices[0].length];
    for (int n = 0; n < buyHere.length; n++) {
      if (prices[0][n] < prices[1][n]) {
        if (prices[0][n] < prices[2][n]) {
          buyHere[n] = 0;
        }
        else {
          buyHere[n] = 2;
        }
      }
      else if (prices[1][n] < prices[2][n]) {
        buyHere[n] = 1;
      }
      else {
        buyHere[n] = 2;
      }
    }
    return buyHere;
  }

  /**
  *Method that calculates the delivery prices. <br>
  *<b>pre: </b> <br>
  *<b>post: </b> The delivery price is returned.<br>
  *@param where Holds the location of the construction. 0 <= where <= 2 <br>
  *@param totPrices Holds the total prices for each hardware shop. <br>
  */
  public static int[] deliveryReturned(int where, int[] totPrices) {
    int[] finalDelivery = new int[3];
    for (int q = 0; q < totPrices.length; q++) {
      if (totPrices[q] < 80000) {
        finalDelivery[q] = DELIVERY[where][0];
      }
      else if (totPrices[q] < 300000) {
        finalDelivery[q] = DELIVERY[where][1];
      }
      else {
        finalDelivery[q] = DELIVERY[where][2];
      }
    }

    return finalDelivery;
  }
}
