package ec.edu.poo;

public class GestorActivos {

    public final int MAX_ACTIVOS = 10;

    private ActivoDigital[] activos;
    private int contador;

    public GestorActivos() {
        this.activos = new ActivoDigital[MAX_ACTIVOS];
        this.contador = 0;
    }

    public void reiniciar() {
        this.activos = new ActivoDigital[MAX_ACTIVOS];
        this.contador = 0;
    }

    public boolean registrarActivo(ActivoDigital activo) {
        // Validar que no se exceda el límite
        if (this.contador >= MAX_ACTIVOS) {
            return false;
        }

        // Validar que no exista un activo con el mismo código
        if (buscarPorCodigo(activo.getCodigo()) != null) {
            return false;
        }

        // Registrar activo
        this.activos[this.contador] = activo;
        this.contador++;
        return true;
    }

    public ActivoDigital buscarPorCodigo(String codigo) {
        for (int i = 0; i < this.contador; i++) {
            if (this.activos[i].getCodigo().equals(codigo)) {
                return this.activos[i];
            }
        }
        return null;
    }

    public int contarActivosCriticos() {
        int criticos = 0;
        for (int i = 0; i < this.contador; i++) {
            if (this.activos[i].getNivelRiesgo() >= 8) {
                criticos++;
            }
        }
        return criticos;
    }

    public double calcularPromedioRiesgo() {
        if (this.contador == 0) {
            return 0.0;
        }

        double sumaRiesgos = 0;
        for (int i = 0; i < this.contador; i++) {
            sumaRiesgos += this.activos[i].getNivelRiesgo();
        }

        return sumaRiesgos / this.contador;
    }

    public boolean aplicarParcheActivo(String codigo) {
        ActivoDigital activo = buscarPorCodigo(codigo);

        if (activo != null) {
            activo.setParcheAplicado(true);
            return true;
        }

        return false;
    }

    public int obtenerCantidadActivos() {
        return this.contador;
    }

    public ActivoDigital[] obtenerActivos() {
        return this.activos;
    }
}