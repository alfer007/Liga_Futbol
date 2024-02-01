public class Jugador {
    private String nombre;
    private int posicion;
    private int velocidad=(int) Math.floor(Math.random()*(100-0+1)+0);
    private int regate=(int) Math.floor(Math.random()*(100-0+1)+0);
    private boolean lesionado;

    public Jugador(){
        System.out.print("Introduce el nombre: ");
        this.nombre=Liga.teclado.next();
        System.out.print("Introduce la posicion del jugador: ");
        this.posicion=Liga.leerInt(Liga.teclado.next());
        System.out.print("Indica si el jugador esta lesionado (Si o No): ");
        String lesio=Liga.teclado.next();
        if (lesio.equalsIgnoreCase("Si"))
            this.lesionado=true;
        else
            this.lesionado=false;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public Jugador(int n){

    }
    public int getRegate() {
        return regate;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", posicion=" + posicion +
                ", velocidad=" + velocidad +"/100"+
                ", regate=" + regate +"/100"+
                ", lesionado=" + lesionado +
                '}';
    }
}
