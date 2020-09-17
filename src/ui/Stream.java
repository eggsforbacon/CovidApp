package ui;

import model.*;
import java.util.*;
import java.io.IOException;
public class Stream {

  /**
  *Prints the prices in the screen. <br>
  *<b>pre: </b> <br>
  *<b>post: The prices are printed correctly on screen</b> <br>
  *@param in Scanner object that allows input to be captured in != null<br>
  *@param totPrices Integer array that holds the total.<br>
  *@param matNamesUnit String 2D array that holds 2 arrays, one with the names and the other with the meassure unit for each material. matNamesUnit != null && &forall; x in matNamesUnit x != ""<br>
  *@param howMany Integer array that holds the quantity. howMany != null && &forall; x in howMany x != String<br>
  *@param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials. prices != null && &forall; x in prices x != String<br>
  */
  public static void printPrices(Scanner in, int[] totPrices, String[][] matNamesUnit, int[] howMany, int[][] prices) {
    Operations.clsm();
    for (int i = 0; i < Operations.HARDWARE_SHOP.length; i++) {
      System.out.println("Precios en " + Operations.HARDWARE_SHOP[i]);
      for (int j = 0; j < prices[0].length; j++) {
        System.out.println("Producto: " + matNamesUnit[0][j] + "\t\nTotal a Pagar: $" + prices[i][j] + "\t\nCantidad: " + howMany[j] + matNamesUnit[1][j]);
        System.out.println("--------------------------------------------------------------------------------------");
      }
      System.out.println("\nPrecio total en ferreteria: $" + totPrices[i] + "\n**************************************************************************************\n");
    }
    System.out.println("(Presione cualquier tecla y ENTER para volver)");
    in.next();
  }

  /**
  *Prints the ideal location to buy each product. <br>
  *<b>pre: </b> <br>
  *<b>post: The ideal locations are printed correctly on screen</b> <br>
  *@param in Scanner object that allows input to be captured in != null<br>
  *@param matNames String array that holds the names for each material. matNames != null && &forall; x in matNames x != "".<br>
  *@param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials. prices != null && &forall; x in prices x != String.<br>
  *@param buyHere Integer array that holds the place where the material should be bought. buyHere != null && &forall; x in buyHere x != String.<br>
  */
  public static void printIdealLocation(Scanner in, String[] matNames, int[][] prices, int[] buyHere, int where, int[] totPrices) {
    Operations.clsm();
    int transIndex;
    int idealFullPrice = 0;
    System.out.println("Donde comprar:\n");
    System.out.println("--------------------------------------------------------------------------------------");
    for (int i = 0; i < matNames.length; i++) {
      transIndex = buyHere[i];
      idealFullPrice += prices[transIndex][i];
      System.out.println(matNames[i] + "            " + Operations.HARDWARE_SHOP[transIndex] + " ($" + prices[transIndex][i] + ")\n");
    }
    int localDelivery = Operations.idealDelivery(where, idealFullPrice, localDelivery);
    System.out.println("Cotizacion ideal: $" + idealFullPrice);
    System.out.println("Domicilio: $" + localDelivery);
    System.out.println("\n**************************************************************************************\n");
    System.out.println("(Presione cualquier tecla y ENTER para volver)");
    in.next();
  }
}
