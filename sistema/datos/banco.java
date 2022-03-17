package sistema.datos;

public class banco{
    int NU=0;
    String pApellido="";
    String sApellido="";
    String nombres="";
    int cantidad=0;
    int clave=0;
    cuenta[] Usuarios = new cuenta[100];
    public void Registrar(){
        NU++;
        pApellido=null;
        sApellido=null;
        nombres=null;
        boolean salir=false;
        boolean salir2=false;
        String temporal="";
        Integer i=0;
        int clave2=0;
        System.out.println("Ingrese su primer apellido");
        pApellido=System.console().readLine();
        System.out.println("Ingrese su segundo apellido(si no existe solo precionar enter)");
        sApellido=System.console().readLine();
        System.out.println("Ingrese su(s) nombre(s)");
        nombres=System.console().readLine();
        if(sApellido!=null){
            nombres=pApellido+" "+sApellido+" "+nombres;
        }else{
            nombres=pApellido+" "+nombres;
        }
        do{
            System.out.println("Ingrese su PIN");
            do{
                try {
                    salir=true;
                    clave=Integer.parseInt(System.console().readLine());
                } catch (Exception e) {
                    System.out.println("ERROR, ingrese un numero");
                    salir=false;
                }
                i=clave;
                temporal=i.toString();
                if(temporal.length()!=4){
                    System.out.println("Favor de ingresar una combinacion de 4 digitos");
                    salir=false;
                }
            }while(salir==false);
            System.out.println("Ingrese su PIN de nuevo");
            salir=false;
            do{
                try {
                    salir=true;
                    clave2=Integer.parseInt(System.console().readLine());
                } catch (Exception e) {
                    System.out.println("ERROR, ingrese un numero");
                    salir=false;
                }
            }while(salir==false);
            if(clave!=clave2){
                System.out.println("Los numeros no coinciden, intentelo de nuevo");
            }else
                salir2=true;
        }while(salir2==false);
        Usuarios[NU].SetUsuario(nombres, clave);
        System.out.println("Registro correcto con numero de usuario "+NU);
    }
    public void Ingreso(){
        int uClave=0;
        int usuario=0;
        int dinero=0;
        boolean salir=false;
        System.out.println("Ingrese su numero de usuario");
        do{
            try {
                usuario=Integer.parseInt(System.console().readLine());
                salir=true;
            } catch (Exception e) {
                System.out.print("Ingrese un numero");
                salir=false;
            }
        }while(salir==false);
        salir=false;
        System.out.println("Ingrese su PIN");
        do{
            try {
                uClave=Integer.parseInt(System.console().readLine());
                salir=true;
            } catch (Exception e) {
                System.out.print("Ingrese un numero");
                salir=false;
            }
        }while(salir==false);
        salir=false;
        if(Usuarios[usuario].validacion(uClave)==true){
            do{
                System.out.println("Bienvenido "+Usuarios[usuario].getNombre()+" que desea hacer?");
                System.out.println("1)Depositar dinero\n2)Retirar dinero\n3)Consultar saldo\n4)Salir");
                try {
                    switch(Integer.parseInt(System.console().readLine())){
                        case 1:
                            System.out.println("Cuanto dinero desea depositar?");
                            try {
                                dinero=Integer.parseInt(System.console().readLine());
                                Usuarios[usuario].setDepositoSaldo(dinero);
                                System.out.print("saldo agregado exitosamente");
                            } catch (Exception e) {
                                System.out.print("Favor de especificar un numero");
                            }
                            break;
                        case 2:
                            System.out.println("Cuanto dinero desea retirar?");
                            try {
                                dinero=Integer.parseInt(System.console().readLine());
                                Usuarios[usuario].setRetiroSaldo(dinero);
                            } catch (Exception e) {
                                System.out.print("Favor de especificar un numero");
                            }
                            break;
                        case 3:
                            System.out.println("Su saldo actual es de "+Usuarios[usuario].getSaldo());
                            break;
                        case 4:
                            salir=true;
                            break;
                        default:
                            System.out.println("Favor de ingresar una opcion correcta");
                            break;
                    }
                } catch (Exception e) {
                    System.out.print("Ingrese un numero");
                    salir=false;
                }
            }while(salir==false);
        }else{
            System.out.println("Usuario o PIN incorrecto, favor de validar sus datos e intentarlo de nuevo");
        }
    }
}

class cuenta{
String nombre="";
int saldo=0;
int PIN=0;
    cuenta(String nombre, int PIN){
        this.nombre=nombre;
        this.saldo=0;
        this.PIN=PIN;
    }
    void SetUsuario(String nombre, int PIN){
        this.nombre=nombre;
        this.saldo=0;
        this.PIN=PIN;
    }
    boolean validacion(int clave){
        boolean resultado=false;
        if(this.PIN==clave){
            resultado=true;
        }else
            resultado=false;
        return resultado;
    }
    String getNombre(){
        return this.nombre;
    }
    int getSaldo(){
        return this.saldo;
    }
    void setDepositoSaldo(int cantidad){
        this.saldo+=cantidad;
    }
    void setRetiroSaldo(int cantidad){
        if(this.saldo>=cantidad){
            this.saldo-=cantidad;
            System.out.println("Dinero retirado exitosamente");
        }else{
            System.out.println("Su saldo actual es de "+this.saldo+", favor de ingresar un numero mas bajo que este");
        }
    }
}
