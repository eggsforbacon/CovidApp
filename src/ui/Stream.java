package ui;

import model.*;
import java.util.*;
import java.io.IOException;
public class Stream {

  /**
  Prints the prices in the screen
  <b>pre: </b> <br>
  <b>post: The prices are printed correctly on screen</b> <br>
  @param in Scanner object that allows input to be captured in != null <br>
  @param totPrices Integer array that holds the total <br>
  @param matNamesUnit String 2D array that holds 2 arrays, one with the names and the other with the meassure unit for each material matNamesUnit != null && /forall x in matNamesUnit x != "" <br>
  @param howMany Integer array that holds the quantity howMany != null && /forall x in howMany x != String <br>
  @param prices Integer 2D array that holds 3 arrays, one for each hardware shop, which contain the prices of the materials prices != null && /forall x in prices x != String <br>
  */
  public static void printPrices(Scanner in, int[] totPrices, String[][] matNamesUnit, int[] howMany, int[][] prices) {
    Operations.clsm();
    for (int i = 0; i < Operations.HARDWARE_SHOP.length; i++) {
      System.out.println("Precios en " + Operations.HARDWARE_SHOP[i]);
      for (int j = 0; j < prices[0].length; j++) {
        System.out.println("\tProducto: " + matNamesUnit[0][j] + "\nTotal a Pagar: $" + howMany[j] + "\t\tCantidad: " + matNamesUnit[1][j]);
        System.out.println("\n--------------------------------------------------------------------------------------");
      }
      System.out.println("\nPrecio total en ferreteria: $" + totPrices[i] + "\n**************************************************************************************\n");
    }
    System.out.println("(Presione cualquier tecla y ENTER para volver)");
    in.next();
  }
}
