import java.util.ArrayList;
import java.util.Scanner;

public class Liga {
    public static ArrayList<Object> listaPer=new ArrayList<>();
    public static Scanner teclado=new Scanner(System.in);
    public static boolean existe=false;

    public static void main(String[] args) {
        int op;
        do {
            menu();
            System.out.print("Elige una opcion: ");
            op= leerInt(teclado.next());
            switch (op){
                case 1:
                    insertaJugador();
                    break;
                case 2:
                    insertaArbitro();
                    break;
                case 3:
                    mostrarVector();
                    break;
                case 4:
                    ordenaPerVeloRecursivo(0,1);
                    break;
                case 5:
                    mostrarJugadores();
                    break;
                case 6:
                    if (existe) {
                        int posi = buscarPersona();
                        if (posi != -1)
                            System.out.println(listaPer.get(posi));
                        else
                            System.out.println("No se encuentra a la persona");
                    }
                    else
                        System.out.println("No hay personas en el vector");
                    break;
                case 7:
                    if (existe) {
                        System.out.print("Escribe el nombre de la persona: ");
                        String nomb = teclado.next();
                        int posi=buscarPersonaRecursivo(0,nomb);
                        if (posi != -1)
                            System.out.println(listaPer.get(posi));
                        else
                            System.out.println("No se encuentra a la persona");
                    }
                    else
                        System.out.println("No hay personas en el vector");
                    break;
                case 8:
                    jugadorRegate();
                    break;
                case 9:
                    if (existe){
                        int suma=0;
                        suma+=sumaVelocidadesRecursivo(0);
                        System.out.println("La suma es: "+suma);
                    }
                    else
                        System.out.println("No hay personas en el vector");
                    break;
                case 10:
                    System.out.println("FIN DEL PROGRAMA");
                    break;
                default:
                    System.out.println("Elige una opcion entre 1 y 10");
            }
        }while (op!=10);
    }

    public static void menu(){
        System.out.println("1) Inserta jugador\n2) Inserta arbitro\n3) Mostrar todo el vector" +
                "\n4) Ordenar personas por velocidad\n5) Mostrar solo jugadores\n6) Buscar jugador" +
                " o arbitro por nombre (iterativo)\n7) Buscar jugador o arbitro por nombre (recursivo)\n8) Jugador con mas regate\n9) Suma todas las velocidades" +
                "\n10) Salir");
    }
    public static int sumaVelocidadesRecursivo(int i){
        if (i<listaPer.size()){
            if (listaPer.get(i) instanceof Jugador){
                return ((Jugador) listaPer.get(i)).getVelocidad()+sumaVelocidadesRecursivo(i+1);
            }
            else
                return ((Arbitro) listaPer.get(i)).getVelocidad()+sumaVelocidadesRecursivo(i+1);
        }
        return 0;
    }
    public static int buscarPersonaRecursivo(int i, String nomb){
        int nuevaPosi;
        if (i<listaPer.size()){
            if (listaPer.get(i) instanceof Jugador) {
                if (((Jugador) listaPer.get(i)).getNombre().equals(nomb))
                    return i;
            } else {
                if (((Arbitro) listaPer.get(i)).getNombre().equals(nomb))
                    return i;
            }
            i++;
            return buscarPersonaRecursivo(i,nomb);
        }
        return -1;
    }
    public static int buscarPersona(){
        boolean esta=false;
        int i=0;
        Object persona;
        System.out.print("Escribe el nombre de la persona: ");
        String nomb=teclado.next();
        while (i<listaPer.size()) {
            if (listaPer.get(i) instanceof Jugador) {
                if (((Jugador) listaPer.get(i)).getNombre().equals(nomb))
                    return i;
            } else {
                if (((Arbitro) listaPer.get(i)).getNombre().equals(nomb))
                    return i;
            }
            i++;
        }
        return -1;
    }
    public static void ordenaPerVeloRecursivo(int i, int j){
        int veloi, veloj;
        Object aux;
        if (j<listaPer.size()) {
            if (listaPer.get(i) instanceof Jugador)
                veloi = ((Jugador) listaPer.get(i)).getVelocidad();
            else
                veloi = ((Arbitro) listaPer.get(i)).getVelocidad();
            if (listaPer.get(j) instanceof Jugador)
                veloj = ((Jugador) listaPer.get(j)).getVelocidad();
            else
                veloj = ((Arbitro) listaPer.get(j)).getVelocidad();
            if (veloj > veloi) {
                aux = listaPer.get(i);
                listaPer.remove(i);
                listaPer.add(j, aux);
            }
            ordenaPerVeloRecursivo(i + 1, j + 1);
        }
    }
    public static void jugadorRegate(){
        int mayor=0;
        Jugador jug;
        Jugador jugAux=new Jugador(0);
        if (existe) {
            for (int i = 0; i < listaPer.size(); i++) {
                if (listaPer.get(i).getClass().getSimpleName().equalsIgnoreCase("Jugador")) {
                    jug = (Jugador) listaPer.get(i);
                    if (jug.getRegate() > mayor) {
                        mayor = jug.getRegate();
                        jugAux = jug;
                    }
                }
            }
            System.out.println("El jugador con mas regate es: " + jugAux.getNombre());
        }
        else System.out.println("No hay jugadores en el vector");
    }
    public static void mostrarJugadores(){
        if (existe) {
            for (int i = 0; i < listaPer.size(); i++) {
                if (listaPer.get(i).getClass().getSimpleName().equalsIgnoreCase("Jugador")) {
                    System.out.println(listaPer.get(i));
                }
            }
        }
        else
            System.out.println("No hay jugadores en el vector");
    }
    public static void mostrarVector(){
        if (existe) {
            for (int i = 0; i < listaPer.size(); i++) {
                System.out.println(listaPer.get(i));
            }
        }
        else
            System.out.println("No hay personas en el vector");
    }
    public static void insertaArbitro(){
        listaPer.add(new Arbitro());
        existe=true;
    }
    public static void insertaJugador(){
        listaPer.add(new Jugador());
        existe=true;
    }
    public static int leerInt(String n){
        boolean correcto=true;
        String num=n;
        int devolver=0;
        do {
            correcto=true;
            try {
                devolver=Integer.parseInt(num);
            } catch (Exception e) {
                System.err.print("Introduce un numero: ");
                num = teclado.next();
                correcto = false;
            }
        }while (!correcto);
        return devolver;
    }

    public static void mostrarTexto(){
        System.out.println("Te muestro el texto");
    }
}