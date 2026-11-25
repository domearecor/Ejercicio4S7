public class Influencer {
    private String nombre;
    private int seguidores;
    private double costo;

    public Influencer(String nombre, int seguidores, double costo) {
        this.nombre = nombre;
        this.seguidores = seguidores;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public double getCosto() {
        return costo;
    }

    public double calcularCostoPorMilSeguidores() {
        if (seguidores <= 0) {
            return Double.MAX_VALUE;
        }
        return (costo / seguidores) * 1000.0;
    }

    public String mostrarInformacion() {
        return nombre + " | Seguidores: " + seguidores + " | Costo: $" + costo;
    }
}