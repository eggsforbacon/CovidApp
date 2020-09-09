import java.util.Scanner;
import java.util.*;
public class Main {

  static final int UNDER_CONSTRUCTION = 1300000;
  static final int WHITE_WORK = 2600000;
  static final int PAINTJOB = 980000;
  static final String[] HARDWARE_SHOP = {"HomeCenter","Ferreteria del Centro","Ferreteria del Barrio"};
  static final int[][] DELIVERY = {
    {120000,28000,0},
    {50000,0,0},
    {120000,55000,0}
  };

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
  }

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

  public static String whereBuy(Scanner in, int[][] prices, String[] matNames) {
    System.out.println("Ingrese el lugar del inmueble [1 = Norte; 2 = Centro; 3 = Sur]\n");
    int where = in.nextInt() - 1;
    String buyHere = "";
    boolean valid = (where <= 3 && where >= 1);
    while (valid == false) {
      System.out.println("Valor invalido. Reintentar:\n");
      where = in.nextInt();
      valid = (where <= 3 && where >= 1);
    }
    int theDeliveryGuyHasToEat = 0;
    int found = 0;
    int indexOf = -1;
    System.out.println("Que material desea consultar?\n");
    String whatMat = in.nextLine();
    whatMat = whatMat.toLowerCase();
    for (int n = 0; n < matNames.length && found == 0; n++) {
      if (matNames[n].equals(whatMat)) {
        found = 1;
        int here = 0;
        int compare0, compare1, compare3;
        if (prices[0][n] < prices[1][n]) { //Is the product cheaper at 0?
          if (prices[0][n] < prices[2][n]) { //Y: Is it still cheaper at 0?
            if (prices[0][n] < 80000) {
              compare0 = prices[0][n] + DELIVERY[where][0];
            } //Y: Is it less than 80.000?
            else if (prices [0][n] < 300000) {
              compare0 = prices[0][n] + DELIVERY[where][1];
            } //N: Then is it less than 300.000 but greater than 80.000?
            else {
              compare0 = prices[0][n] + DELIVERY[where][2];
            } //N: Then it has to be greater than 300.000
          }
          else { //N: Then it has to be cheaper at 2
            if (prices[2][n] < 80000) {
              compare0 = prices[2][n] + DELIVERY[where][0];
            } //Is it less than 80.000?
            else if (prices [2][n] < 300000) {
              compare0 = prices[2][n] + DELIVERY[where][1];
            } //N: Then is it less than 300.000...?
            else {
              compare0 = prices[2][n] + DELIVERY[where][2];
            } //Then it has to be greater than 300.000
          }
        }
        else {
          if (prices[1][n] < prices[2][n]) {
            if (prices[1][n] < 80000) {
              compare0 = prices[0][n] + DELIVERY[where][0];
            }
            else if (prices [1][n] < 300000) {
              compare0 = prices[1][n] + DELIVERY[where][1];
            }
            else {
              compare0 = prices[1][n] + DELIVERY[where][2];
            }
          }
          else {
            if (prices[2][n] < 80000) {
              compare0 = prices[2][n] + DELIVERY[where][0];
            }
            else if (prices [2][n] < 300000) {
              compare0 = prices[2][n] + DELIVERY[where][1];
            }
            else {
              compare0 = prices[2][n] + DELIVERY[where][2];
            }
          }
        }
      }
    }
    if (found == 0) {
      return "El material no fue solicitado. Por favor solicitarlo antes de hacer este proceso.";
    }
    return "";
  }
}
