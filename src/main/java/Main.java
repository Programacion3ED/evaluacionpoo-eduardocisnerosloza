package ec.edu.poo;

public class Main {

    public static void main(String[] args) {
        GestorActivos gestor = new GestorActivos();

        System.out.println("--- 1. CREACIÓN Y REGISTRO DE ACTIVOS ---");
        Servidor s1 = new Servidor("SRV-001", "Servidor Base de Datos", 9, false, "Linux CentOS");
        Servidor s2 = new Servidor("SRV-002", "Servidor Web", 5, true, "Windows Server");
        Firewall f1 = new Firewall("FW-001", "Firewall Perimetral", 8, false, 150);
        Firewall f2 = new Firewall("FW-002", "Firewall Interno", 4, true, 50);

        System.out.println("Registrar SRV-001: " + gestor.registrarActivo(s1));
        System.out.println("Registrar SRV-002: " + gestor.registrarActivo(s2));
        System.out.println("Registrar FW-001: " + gestor.registrarActivo(f1));
        System.out.println("Registrar FW-002: " + gestor.registrarActivo(f2));

        System.out.println("\n--- 2. PRUEBA DE REGLAS DE NEGOCIO ---");
        Servidor sDuplicado = new Servidor("SRV-001", "Servidor Pirata", 10, false, "Kali Linux");
        System.out.println("Registrar código duplicado (SRV-001): " + gestor.registrarActivo(sDuplicado));

        System.out.println("\n--- 3. BÚSQUEDA ---");
        ActivoDigital encontrado = gestor.buscarPorCodigo("FW-001");
        if (encontrado != null) {
            System.out.println("Activo encontrado: " + encontrado.getNombre() + " - Riesgo: " + encontrado.getNivelRiesgo());
        } else {
            System.out.println("Activo no encontrado.");
        }

        System.out.println("\n--- 4. CÁLCULOS ESTADÍSTICOS ---");
        System.out.println("Cantidad de activos críticos (Riesgo >= 8): " + gestor.contarActivosCriticos());
        System.out.println("Promedio de riesgo total: " + gestor.calcularPromedioRiesgo());

        System.out.println("\n--- 5. APLICACIÓN DE PARCHES ---");
        System.out.println("Estado de parche FW-001 ANTES: " + f1.isParcheAplicado());
        System.out.println("Aplicando parche a FW-001... " + gestor.aplicarParcheActivo("FW-001"));
        System.out.println("Estado de parche FW-001 DESPUÉS: " + f1.isParcheAplicado());

        System.out.println("Aplicar parche a código fantasma (XXX-999): " + gestor.aplicarParcheActivo("XXX-999"));
    }
}