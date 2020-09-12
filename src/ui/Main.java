package ui;

import java.util.*;
import java.io.IOException;
import model.*;
import ui.Validations;
public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int userSays = 0;
    String[][] matNamesUnit = null;
    int[][] quantityPurpose = null;
    int switcher = 0;
    boolean theyAreIn = false;
    String topMessage = "";
    do {
      Wires.clsm();
      System.out.println(topMessage);
      switcher = 0;
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
          Wires.clsm();
          break;
        case 1:
          switcher = 1;
          theyAreIn = true;
          Wires.clsm();
          System.out.println("Ingrese la cantidad de materiales distintos solicitados:\n");
          int matCount = in.nextInt();
          for (int i = 0; i < matCount; i++) {
            matNamesUnit = Validations.inputNames(i,in,matCount,matNamesUnit);
            quantityPurpose = Validations.quantityType(i,in,matCount,quantityPurpose);
          }
          topMessage = "Materiales ingresados con exito!";
          break;
        case 2:
          System.out.println("Pito");
          break;
        default:
          break;
      }

      String bottomMessage = Validations.displayedMessage(switcher,userSays);
    } while (userSays != 0);
  }
}
