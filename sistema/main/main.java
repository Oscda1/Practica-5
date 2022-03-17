package sistema.main;
import sistema.datos.banco;

class practica5{
    public static void main(String args[])
    {
        banco sistemas = new banco();
        boolean salir=false;
        do{
            try {
                System.out.print("Que desea hacer?\n1)Registrar un nuevo usuario\n2)Iniciar sesion\n3)Salir\n");
            switch(Integer.parseInt(System.console().readLine())){
                case 1:
                    sistemas.Registrar();
                    break;
                case 2:
                    sistemas.Ingreso();
                    break;
                case 3:
                    salir=true;
                    break;
                default:
                    System.out.print("Ingrese una opcion valida\n");
            }
            } catch (Exception e) {
                System.out.print("Ingrese un numero\n");
            }
        }while(salir==false);
    }
}