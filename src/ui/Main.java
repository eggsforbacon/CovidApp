package ui;

import java.util.*;
import java.io.IOException;
import model.*;
import ui.Validations;
public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Wires methNester = new Wires(); //Object's sole purpose is to nest methods within methods. If method needs to be fetched by its self object won't be used.
    int userSays = 0;
    String[][] matNamesUnit = null;
    int[][] quantityPurpose = null;
    do {
      Wires.clsm();
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
      userSays = in.nextInt();
      in.nextLine();

      switch (userSays) {
        case 0:
          methNester.clsm();
          break;
        case 1:
          methNester.clsm();
          System.out.println("Ingrese la cantidad de materiales distintos solicitados:\n");
          int matCount = in.nextInt();
          for (int i = 0; i < matCount; i++) {
            matNamesUnit = Validations.inputNames(i,in,methNester,matCount,matNamesUnit);
            quantityPurpose = Validations.quantityType(i,in,methNester,matCount,quantityPurpose);
          }
          break;
        default:
          break;
      }
    } while (userSays != 0);

  }

  //Here

}
