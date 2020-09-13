package ui;

import model.*;
import java.util.*;
import java.io.IOException;
public class Stream {

  public static void printPrices(Scanner in, int[] totPrices, String[][] matNamesUnit, int[] howMany, int[][] prices) {
    Operations.clsm();
    for (int i = 0; i < Operations.HARDWARE_SHOP.length; i++) {
      System.out.println("Precios en " + Operations.HARDWARE_SHOP[i]);
      for (int j = 0; j < prices[0].length; j++) {
        System.out.println("\t\t\tProducto\t\t" + "Total a Pagar\t\t" + "Cantidad");
        System.out.println("\t\t\t" + matNamesUnit[0][j] + "\t\t$" + prices[i][j] + "\t\t" + howMany[j] + " " + matNamesUnit[1][j]);
      }
      System.out.println("Precio total en ferreteria: $" + totPrices[i] + "\n******************************************************\n");
    }
    System.out.println("(Presione cualquier tecla y ENTER para volver)");
    in.next();
  }
}
