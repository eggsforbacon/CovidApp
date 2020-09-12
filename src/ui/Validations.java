package ui;

import model.*;
import java.util.*;
import java.io.IOException;
public class Validations {

  public static String[][] inputNames(int i,Scanner in, int matCount, String[][] matNamesUnit) {
    matNamesUnit = new String[2][matCount];
    Wires.clsm();
    System.out.println("************************************************");
    System.out.println("Ingrese el NOMBRE del siguiente material seguido de su UNIDAD DE MEDIDA\n");
    matNamesUnit[0][i] = in.next();
    in.nextLine();
    matNamesUnit[0][i] = matNamesUnit[0][i].toLowerCase();
    System.out.println("************************************************");
    matNamesUnit[1][i] = in.nextLine();
    matNamesUnit[1][i] = matNamesUnit[1][i].toLowerCase();
    Wires.clsm();
    return matNamesUnit;
  }

  public static int[][] quantityType(int i, Scanner in, int matCount, int[][] quantityPurpose) {
    quantityPurpose = new int[2][matCount];
    Wires.clsm();
    System.out.println("************************************************");
    System.out.println("Ingrese la CANTIDAD del material solicitado\n");
    quantityPurpose[0][i] = in.nextInt();
    Wires.clsm();
    System.out.println("Ingrese el PROPOSITO [1 = Obra Negra; 2 = Obra Blanca; 3 = Pintura] del material solicitado\n");
    quantityPurpose[1][i] = in.nextInt();
    return quantityPurpose;
  }

  public static String displayedMessage(int switcher, int userSays) {
    String theReturn = "";
    switch (switcher) {
      case 0:
        break;
      case 1:
        theReturn = "Materiales ingresados con exito!";
        break;
      case 2:
        switch (userSays) {

        }
      default:
        break;
    }
    return theReturn;
  }
}
