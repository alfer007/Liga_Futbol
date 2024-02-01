public class Arbitro {
    private String nombre;
    private String colegio;
    private int velocidad=(int) Math.floor(Math.random()*(100-0+1)+0);
    private int acierto=(int) Math.floor(Math.random()*(100-0+1)+0);
    private boolean activo;

    public Arbitro(){
        System.out.print("Introduce el nombre: ");
        this.nombre=Liga.teclado.next();
        System.out.print("Introduce el colegio del arbitro: ");
        this.colegio=Liga.teclado.next();
        System.out.print("Indica si el arbitro esta activo (Si o No): ");
        String lesio=Liga.teclado.next();
        if (lesio.equalsIgnoreCase("Si"))
            this.activo=true;
        else
            this.activo=false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public String toString() {
        return "Arbitro{" +
                "nombre='" + nombre + '\'' +
                ", colegio='" + colegio + '\'' +
                ", velocidad=" + velocidad +"/100"+
                ", acierto=" + acierto +"/100"+
                ", activo=" + activo +
                '}';
    }
}
