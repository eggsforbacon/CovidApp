package ui;

import model.*;
import java.util.*;
import java.io.IOException;
public class Stream {

  /**
  *Prints the prices in the screen. <br>
  *<b>pre: </b> <br>
  *<b>post: </b> The prices are printed correctly on screen.<br>
  *@param in Scanner object that allows input to be captured in != null.<br>
  *@param totPrices Integer array that holds the total.<br>
  *@param matNamesUnit String 2D array that holds 2 arrays, one with the names and the other with the meassure unit for each material. matNamesUnit != null && &forall;x in matNamesUnit x != "".<br>
  *@param howMany Integer array that holds the quantity. howMany != null && &forall;x in howMany x != String.<br>
  *@param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials. prices != null && &forall;x in prices x != String.<br>
  *@param where Integer that represents the location of the construction site. where != null.<br>
  */
  public static void printPrices(Scanner in, int[] totPrices, String[][] matNamesUnit, int[] howMany, int[][] prices, int where, int[][] quantityPurpose) {
    Operations.clsm();
    for (int i = 0; i < Operations.HARDWARE_SHOP.length; i++) {
      int[] totalDelivery = Operations.deliveryForEach(where,totPrices);
      totPrices = Operations.calcTotalPrice(in,prices,quantityPurpose);
      System.out.println("Precios en " + Operations.HARDWARE_SHOP[i]);
      for (int j = 0; j < prices[0].length; j++) {
        System.out.println("Producto: " + matNamesUnit[0][j] + "\t\nTotal a Pagar: $" + (prices[i][j]*howMany[j]) + "\t\nCantidad: " + howMany[j] + " " + matNamesUnit[1][j]);
        System.out.println("--------------------------------------------------------------------------------------");
      }
      System.out.println("\nPrecio en ferreteria (con mano de obra): $" + totPrices[i] + "\nDomicilio: $" + totalDelivery[i] + "\n**************************************************************************************\n");
    }
    System.out.println("(Presione cualquier tecla y ENTER para volver)");
    in.next();
  }

  /**
  *Prints the ideal location to buy each product. <br>
  *<b>pre: </b> <br>
  *<b>post: </b> The ideal locations are printed correctly on screen.<br>
  *@param in Scanner object that allows input to be captured in != null.<br>
  *@param matNames String array that holds the names for each material. matNames != null && &forall;x in matNames x != "".<br>
  *@param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials. prices != null && &forall;x in prices x != String.<br>
  *@param buyHere Integer array that holds the place where the material should be bought. buyHere != null && &forall;x in buyHere x != String.<br>
  *@param where Integer that represents the location of the cons site. where != null.<br>
  *@param quantity Integer array that holds
  */
  public static void printIdealLocation(Scanner in, String[] matNames, int[][] prices, int[] buyHere, int where, int[] quantity) {
    Operations.clsm();
    int transIndex;
    int idealFullPrice = 0;
    System.out.println("Donde comprar:\n");
    System.out.println("--------------------------------------------------------------------------------------");
    for (int i = 0; i < matNames.length; i++) {
      transIndex = buyHere[i];
      idealFullPrice += (quantity[i]*prices[transIndex][i]);
      System.out.println(matNames[i] + ": " + Operations.HARDWARE_SHOP[transIndex] + " ($" + (quantity[i]*prices[transIndex][i]) + ")\n");
    }
    int localDelivery = 0;
    localDelivery = Operations.idealDelivery(where, idealFullPrice, localDelivery);
    System.out.println("Cotizacion ideal: $" + idealFullPrice);
    System.out.println("Domicilio: $" + localDelivery);
    System.out.println("\n**************************************************************************************\n");
    System.out.println("(Presione cualquier tecla y ENTER para volver)");
    in.next();
  }
  /**
  *Prints the ideal location to buy each product. <br>
  *<b>pre: </b> <br>
  *<b>post: </b> The ideal locations are printed correctly on screen.<br>
  *@param in Scanner object that allows input to be captured in != null.<br>
  *@param matNames String array that holds the names for each material. matNames != null && &forall;x in matNames x != "".<br>
  *@param purpose Integer arrqy that hold the purpose of each material. purpose != null && &forall;x in matNames x != "". <br>
  */
  public static void printPurpose(Scanner in, String[] matNames, int[] purpose) {
    Operations.clsm();
    String[][] thisOrThatArr = new String[3][0];
    for (int k = 0; k < purpose.length; k++) {
      switch (purpose[k]) {
        case 1:
          thisOrThatArr[0] = Arrays.copyOf(thisOrThatArr[0], thisOrThatArr[0].length + 1);
          thisOrThatArr[0][thisOrThatArr[0].length - 1] = matNames[k];
          break;
        case 2:
          thisOrThatArr[1] = Arrays.copyOf(thisOrThatArr[1], thisOrThatArr[1].length + 1);
          thisOrThatArr[1][thisOrThatArr[1].length - 1] = matNames[k];
          break;
        case 3:
          thisOrThatArr[2] = Arrays.copyOf(thisOrThatArr[2], thisOrThatArr[2].length + 1);
          thisOrThatArr[2][thisOrThatArr[2].length - 1] = matNames[k];
          break;
        default:
          break;
      }
    }
     for (int l = 0; l < thisOrThatArr.length; l++) {
       String[] title = {"Obra Negra", "Obra Blanca", "Pintura"};
       System.out.println("Materiales de " + title[l] + ":\n");
       for (int m = 0; m < thisOrThatArr[l].length; m++) {
         System.out.println(thisOrThatArr[l][m]);
       }
       System.out.println("--------------------------------------------------------------------------------------\n");
     }
     System.out.println("(Presione cualquier tecla y ENTER para volver)");
     in.next();
  }
}
