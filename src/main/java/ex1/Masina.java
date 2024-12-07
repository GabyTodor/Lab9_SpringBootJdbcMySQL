package ex1;

public class Masina {
    String nr_inmatriculare,marca,culoare;
    int an_fabricatie,nr_km;

    public Masina(String nr_inmatriculare, String marca,int an_fabricatie, String culoare,  int nr_km) {
        this.nr_inmatriculare = nr_inmatriculare;
        this.marca = marca;
        this.culoare = culoare;
        this.an_fabricatie = an_fabricatie;
        this.nr_km = nr_km;
    }

    public Masina() {}

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getAn_fabricatie() {
        return an_fabricatie;
    }

    public void setAn_fabricatie(int an_fabricatie) {
        this.an_fabricatie = an_fabricatie;
    }

    public int getNr_km() {
        return nr_km;
    }

    public void setNr_km(int nr_km) {
        this.nr_km = nr_km;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nr_inmatriculare='" + nr_inmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", culoare='" + culoare + '\'' +
                ", an_fabricatie=" + an_fabricatie +
                ", nr_km=" + nr_km +
                '}';
    }
}

