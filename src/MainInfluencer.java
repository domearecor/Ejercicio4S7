public class MainInfluencer {
    public static void main(String[] args) {
        // Crear 5 influencers de forma independiente
        Influencer inf1 = new Influencer("@valeria.tech", 120000, 600.0);
        Influencer inf2 = new Influencer("@diego.fitness", 80000, 320.0);
        Influencer inf3 = new Influencer("@sofia.gourmet", 250000, 1500.0);
        Influencer inf4 = new Influencer("@lucas.viaja", 50000, 350.0);
        Influencer inf5 = new Influencer("@majo.estilo", 150000, 525.0);

        // Agregar selectivamente a la campaña
        Campania campania = new Campania("Lanzamiento Otoño");
        campania.agregarInfluencer(inf1);
        campania.agregarInfluencer(inf2);
        campania.agregarInfluencer(inf3);
        campania.agregarInfluencer(inf5);

        System.out.println("--- Pruebas mínimas ND-L3 ---");
        System.out.println("Alcance total: " + campania.calcularAlcanceTotal());
        System.out.println("Costo total: $" + campania.calcularCostoTotal());

        Influencer buscado = campania.buscarInfluencer("@diego.fitness");
        System.out.println("Buscar @diego.fitness: " + (buscado != null ? buscado.mostrarInformacion() : "No encontrado"));

        Influencer mejorCosto = campania.obtenerMenorCostoPorMil();
        System.out.println("\n--- Desafío: Menor costo por cada 1000 seguidores ---");
        if (mejorCosto != null) {
            System.out.println(mejorCosto.mostrarInformacion()
                    + " | CPM: $" + mejorCosto.calcularCostoPorMilSeguidores());
        }

        System.out.println("\n--- Eliminar @sofia.gourmet ---");
        System.out.println("Eliminado: " + campania.eliminarInfluencer("@sofia.gourmet"));

        System.out.println("\n--- Resumen de campaña ---");
        System.out.println(campania.mostrarResumen());
    }
}
