import java.util.ArrayList;

class Vivienda {
    private String calle;
    private int nroCalle;
    private String provincia;
    private ArrayList<Ambiente> ambientes;

    public Vivienda(String calle, int nroCalle, String provincia) {
        this.calle = calle;
        this.nroCalle = nroCalle;
        this.provincia = provincia;
        this.ambientes = new ArrayList<>();
    }

    public void agregarAmbiente(Ambiente ambiente) {
        ambientes.add(ambiente);
    }

    public double totalMetrosCuadradosVivienda() {
        double totalMetros = 0;
        for (Ambiente ambiente : ambientes) {
            totalMetros += ambiente.getMetrosCuadrados();
        }
        return totalMetros;
    }

    public String getCalle() {
        return calle;
    }

    public int getNroCalle() {
        return nroCalle;
    }

    public String getProvincia() {
        return provincia;
    }

    public ArrayList<Ambiente> getAmbientes() {
        return ambientes;
    }
}
