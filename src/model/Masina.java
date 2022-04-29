package model;

public class Masina {
    private int id;
    private String model;
    private String culoare;
    private int anulFabricatiei;
    private double pret;

    public Masina(String model, String culoare, int anulFabricatiei, int id, double pret) {
        this.model = model;
        this.culoare = culoare;
        this.anulFabricatiei = anulFabricatiei;
        this.id = id;
        this.pret = pret;
    }

    public Masina(String name) {
        String[] propr = name.split(",");
        this.model = propr[0];
        this.culoare = propr[1];
        this.anulFabricatiei = Integer.parseInt(propr[2]);
        this.id = Integer.parseInt(propr[3]);
        this.pret = Double.parseDouble(propr[4]);
    }

    public double getPret() {
        return this.pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public String getCuloare() {
        return this.culoare;
    }

    public int getAnulFabricatiei() {
        return this.anulFabricatiei;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public void setAnulFabricatiei(int anulFabricatiei) {
        this.anulFabricatiei = anulFabricatiei;
    }


    public String descriere() {
        String text = "Modelul masini : " + this.model + "\n";
        text += "Culoarea masini : " + this.culoare + "\n";
        text += "Anul fabricatiei : " + this.anulFabricatiei + "\n";
        text += "Id-ul masini este: " + this.id + "\n";
        text += "Pretul masini este : " + this.pret + "\n";
        return text;
    }
}
