package controller;

import model.Masina;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ControllMasina {

    private ArrayList<Masina> masini;


    public ControllMasina() {

        masini = new ArrayList<>();

        this.load();
    }


    public void load() {

        try {
            File file = new File("C:\\Users\\flore\\Desktop\\mycode\\JavaBasics\\Incapsularea\\parc-auto\\src\\resources\\maini.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String linie = scanner.nextLine();

                Masina m = new Masina(linie);

                this.masini.add(m);

            }


        } catch (Exception e) {


            e.printStackTrace();

        }
    }


    public void afisareMasini() {
        for (Masina x : masini) {
            System.out.println(x.descriere());
        }
    }


    //sortam pret


    public void sortarePret() {
        for (int i = 0; i < masini.size() - 1; i++) {
            if (masini.get(i).getPret() < masini.get(i + 1).getPret()) {
                Masina aux = masini.get(i);
                masini.set(i, masini.get(i + 1));
                masini.set(i + 1, aux);
            }
        }
    }


    //functie ce verifica daca o anumita masina exista  dupa id
    public boolean existMasinaById(int id) {

        for (Masina x : masini) {
            if (x.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //functie
    public boolean existMasinaByColorAndModel(String model, String culoare) {
        for (Masina x : masini) {
            if (x.getCuloare().equals(culoare) && x.getModel().equals(model)) {
                return true;
            }
        }
        return false;
    }


    //functie ce adauga o masiana ce : nu avem voie sa avem 2 masini cu acelasi model si culoare
    public void addCar(Masina masina) {

        if (existMasinaByColorAndModel(masina.getModel(), masina.getCuloare()) == true) {
            System.out.println("Masiana deja exista");
        } else {
            masini.add(masina);
            System.out.println("Masina a fost adaugata cu succes");
        }

    }

    //functie ce updateaza pretul unei masini


    public void updatePriceById(int id, double pretNou) {
        for (int i = 0; i < masini.size() - 1; i++) {
            if (masini.get(i).getId() == id) {
                masini.get(i).setPret(pretNou);
            }
        }
    }
//todo functie ce primeste parametru id si returneaza pozitia masinii cu id

    public int pozMasina(int id) {
        int poz = 0;
        for (Masina x : masini) {
            if (existMasinaById(id) == true && x.getId() == id) {
                poz = masini.indexOf(x);
            }
        }
        return poz;
    }


    public void deleteCarById(int id) {

        masini.remove(pozMasina(id));

    }


    //CRUD CREATE READ UPDATE DELETE


    //todo functie ce primeste ca parametru modelul masinsinii si returneaza  masina cu modelul dat
    public Masina masinaModel(String model) {


        for (Masina x : masini) {
            if (x.getModel().equals(model)) {

                return x;
            }
        }
        return null;
    }

    public void updateAn(String model, int noulAn) {

        Masina m = masinaModel(model);

        if (m != null) {
            m.setAnulFabricatiei(noulAn);
        } else {


            System.out.println("Nu exista masina");
        }


    }

    public Masina modelMasinaculoare(String model, String culoare) {
        for (Masina y : masini) {
            if (y.getModel().equals(model) && y.getCuloare().toLowerCase().equals(culoare.toLowerCase())) {
                return y;
            }
        }
        return null;
    }

    public void afisCar(String model,String culoare){
        Masina x=modelMasinaculoare(model,culoare);
        if (x!=null){
            System.out.println(x.descriere());
        } else {
            System.out.println("Masina nu exista");
        }

    }

    public ArrayList<Masina> anMasina(int anMinim,int anMaxim){
        ArrayList<Masina> dupaAn=new ArrayList<>();
        for (Masina x:masini){
            if(x.getAnulFabricatiei()>=anMinim && x.getAnulFabricatiei()<=anMaxim){
                        dupaAn.add(x);
            }
        }
        return dupaAn;
    }

    public ArrayList<Masina> culoareMasina(String culoare){
        ArrayList<Masina> dupaCuloare=new ArrayList<>();
        for (Masina c:masini){
            if(c.getCuloare().equals(culoare)){
                dupaCuloare.add(c);
            }
        }
        return dupaCuloare;
    }

    public ArrayList<Masina> pretMasina(double pretMinim,double pretMaxim){
        ArrayList<Masina> pretMasina=new ArrayList<>();
        for(Masina p:masini){
            if(p.getPret()>=pretMinim && p.getPret()<=pretMaxim){
                pretMasina.add(p);
            }
        }
        return pretMasina;
    }


    public ArrayList<Masina> intersectieListe(ArrayList<Masina>a,ArrayList<Masina>b){
        ArrayList<Masina> interesectiePretCuloare=new ArrayList<>();
        for (Masina x:a){

             if(b.contains(x)){

                 interesectiePretCuloare.add(x);
             }
        }

        return interesectiePretCuloare;
    }


    public  ArrayList<Masina>getMasini(){

        return  this.masini;
    }



}
