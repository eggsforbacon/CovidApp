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
          System.out.println("Ingrese la cantidad de materiales distintos solicitados:\n");
          int matCount = in.nextInt();
          for (int i = 0; i < matCount; i++) {
            matNamesUnit = Operations.inputNames(i,in,matCount,matNamesUnit);
            quantityPurpose = Operations.quantityType(i,in,matCount,quantityPurpose);
            prices = Operations.inputPrices(i,in,matNamesUnit[0]);
          }
          break;
        case 2:
          try {
            totPrices = Operations.calcTotalPrice(in,prices,quantityPurpose[1]);
            Stream.printPrices(in,totPrices,matNamesUnit,quantityPurpose[0],prices);
          } catch (NullPointerException e) {
            for (int secs = 3; secs > 0; secs--) {
              Operations.clsm();
              menu();
              System.out.println("\nNo hay materiales que cotizar\nReintentando en " + secs + "...");
              Operations.pause(1000);
            }
          }
          break;
        default:
          break;
      }
    } while (userSays != 0);
  }

  public static void menu() {
    Operations.clsm();
    System.out.println("Bienvenido a la Covid Budget App!");
    System.out.println("Escriba el numero que le corresponda a la opcion que desee seleccionar,posteriormente presione [ENTER]\n(Por favor no ingrese a opciones mayores si no ha ingresado a las anteriores previamente.\nNo seguir esta recomendacion hara que la aplicacion falle)\n");
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
