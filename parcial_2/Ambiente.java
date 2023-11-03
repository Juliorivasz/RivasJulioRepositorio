class Ambiente {
    private String tipoAmbiente;
    private double metrosCuadrados;

    public Ambiente(String tipoAmbiente, double metrosCuadrados) {
        this.tipoAmbiente = tipoAmbiente;
        this.metrosCuadrados = metrosCuadrados;
    }

    public String getTipoAmbiente() {
        return tipoAmbiente;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }
}
