package ui;

import java.util.*;
import java.io.IOException;
import model.*;
import ui.Stream;
public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int userSays = 0;
    String[][] matNamesUnit = null;
    int[][] quantityPurpose = null;
    int[][] prices = null;
    int[] totPrices = null;
    int[] buyHere = null;

    do {
      menu();
      userSays = in.nextInt();
      in.nextLine();
      switch (userSays) {
        case 0:
          Operations.clsm();
          break;
        case 1:
          Operations.clsm();
          int where = Operations.location(in);
          Operations.clsm();
          System.out.println("Ingrese la cantidad de materiales distintos solicitados (Para cancelar presione 0 y ENTER):\n");
          int matCount = in.nextInt();
          matNamesUnit = new String[2][matCount];
          quantityPurpose = new int[2][matCount];
          prices = new int[3][matCount];
          for (int i = 0; i < matCount; i++) {
            matNamesUnit = Operations.inputNames(i,in,matCount,matNamesUnit);
            quantityPurpose = Operations.quantityType(i,in,matCount,quantityPurpose);
            prices = Operations.inputPrices(i,in,matNamesUnit[0],prices);
          }
          break;
        case 2:
          totPrices = Operations.calcTotalPrice(in,prices,quantityPurpose);
           Stream.printPrices(in,totPrices,matNamesUnit,quantityPurpose[0],prices);
          break;
        case 3:
          buyHere = Operations.whereBuy(in,prices);
          Stream.printIdealLocation(in,matNamesUnit[0],prices,buyHere);
        default:
          break;
      }
    } while (userSays != 0);

  }
  /**
  *Void method that displays the menu
  *<b>pre: </b> <br>
  *<b>post: The menu is displayed.</b> <br>
  */
  public static void menu() {
    Operations.clsm();
    System.out.println("Bienvenido a la Covid Budget App!");
    System.out.println("Escriba el numero que le corresponda a la opcion que desee seleccionar,posteriormente presione [ENTER]\n");
    System.out.println("************************************************************");
    System.out.println("*Ingresar los materiales\t\t\t\t[1]*");
    System.out.println("*Desplegar cotizacion total por ferreteria\t\t[2]*");
    System.out.println("*Desplegar cotizacion ideal por cada material\t\t[3]*");
    System.out.println("*Desplegar materiales por utilizacion\t\t\t[4]*");
    System.out.println("*\t\t\t\t\t\t\t   *");
    System.out.println("*\t\t\t\t\t\t\t   *");
    System.out.println("*Salir de la aplicacion\t\t\t\t\t[0]*");
    System.out.println("************************************************************");
  }

}
