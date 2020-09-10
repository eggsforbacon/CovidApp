package ui;

import java.util.*;
import java.io.IOException;
import model.*;
public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Wires methNester = new Wires(); //Object's sole purpose is to nest methods within methods. If method needs to be fetched by its self object won't be used.
    int userSays = 0;
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
    } while (userSays != 0);

  }

  public static void inputMaterials(Scanner in, Wires methNester) {

    System.out.println("Ingrese la cantidad de materiales distintos solicitados:\n");
    int matCount = in.nextInt();
    String[] matNames = new String[matCount];
    int[] howMany = new int[matCount];
    int[] matPurpose = new int[matCount];

    for (int i = 0; i < matCount; i++) {
      methNester.clsm();
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
}
