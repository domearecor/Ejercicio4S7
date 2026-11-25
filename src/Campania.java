import java.util.ArrayList;

public class Campania {
    private String titulo;
    private ArrayList<Influencer> influencers;

    public Campania(String titulo) {
        this.titulo = titulo;
        influencers = new ArrayList<>();
    }

    public void agregarInfluencer(Influencer influencer) {
        if (influencer != null) {
            influencers.add(influencer);
        }
    }

    public Influencer buscarInfluencer(String nombre) {
        if (nombre == null) {
            return null;
        }
        for (Influencer inf : influencers) {
            if (inf.getNombre().equalsIgnoreCase(nombre)) {
                return inf;
            }
        }
        return null;
    }

    public boolean eliminarInfluencer(String nombre) {
        Influencer encontrado = buscarInfluencer(nombre);
        if (encontrado != null) {
            return influencers.remove(encontrado);
        }
        return false;
    }

    public int calcularAlcanceTotal() {
        int alcance = 0;
        for (Influencer inf : influencers) {
            alcance += inf.getSeguidores();
        }
        return alcance;
    }

    public double calcularCostoTotal() {
        double total = 0.0;
        for (Influencer inf : influencers) {
            total += inf.getCosto();
        }
        return total;
    }

    public String mostrarResumen() {
        if (influencers.isEmpty()) {
            return "Campaña '" + titulo + "' sin influencers asignados.";
        }
        String resumen = "=== CAMPAÑA: " + titulo + " ===\n";
        for (int i = 0; i < influencers.size(); i++) {
            resumen += (i + 1) + ". " + influencers.get(i).mostrarInformacion() + "\n";
        }
        resumen += "Alcance total: " + calcularAlcanceTotal() + " seguidores\n";
        resumen += "Costo total: $" + calcularCostoTotal();
        return resumen;
    }

    // Desafío: retorna el influencer con menor costo por cada 1000 seguidores
    public Influencer obtenerMenorCostoPorMil() {
        if (influencers.isEmpty()) {
            return null;
        }
        Influencer mejor = null;
        for (Influencer inf : influencers) {
            if (inf.getSeguidores() > 0) {
                if (mejor == null || inf.calcularCostoPorMilSeguidores() < mejor.calcularCostoPorMilSeguidores()) {
                    mejor = inf;
                }
            }
        }
        return mejor;
    }
}