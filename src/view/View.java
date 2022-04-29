package view;

import controller.ControllMasina;
import model.Masina;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

    private ControllMasina controllMasina;

    private Scanner scanner;


    public View() {
        this.controllMasina = new ControllMasina();

        this.scanner = new Scanner(System.in);
    }

    private void meniu() {
        System.out.println("------------------ Meniu -------------------");
        System.out.println("Apsati tasta 1 pentru a afisa masinile");
        System.out.println("Apasati tasta 2 pentru a sorta masinile dupa pret");
        System.out.println("Apasati tasta 3 pentru a alege anul masini");
        System.out.println("Apasati tasta 4 pentru a alege modelul masini si culoarea ei");
        System.out.println("Apasati tasta 5 pentru filtrare");
        System.out.println("Exit");
        System.out.println("------------------------------------------------");


    }


    public void play() {


        boolean running = true;

        int alegere;

        while (running) {

            meniu();
            alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {

                case 1:
                    controllMasina.afisareMasini();
                    break;
                case 2:
                    controllMasina.sortarePret();
                    break;
                case 3:
                    updateAn();
                    break;
                case 4:
                    chooseCar();
                    break;
                case 5:
                    filter2();
                    break;

            }


        }


    }

    public void updateAn() {

        System.out.println("Introducet modelul masini : ");
        String modelul = scanner.nextLine();
        System.out.println("Introduceti noul an ");
        int an = Integer.parseInt(scanner.nextLine());
        controllMasina.updateAn(modelul, an);

    }

    public void chooseCar() {
        System.out.println("Introduceti modelul masini");
        String modelul = scanner.nextLine();
        System.out.println("Introduceti culoarea masini");
        String culoare = scanner.nextLine();
        controllMasina.afisCar(modelul, culoare);

    }

    public void filter() {
        System.out.println("------------------------FILTRARE--------------------");
        System.out.println("Apasati tasta 1 pentru a introduce culoarea");
        System.out.println("Apasati tasta 2 pentru a introduce anul");
        System.out.println("Apasati tasta 3 pentru a introduce pretul");
        System.out.println("----------------------------------------------------");
        int filter = Integer.parseInt(scanner.nextLine());

        switch (filter) {
            case 1:
                intoCuloare();
                break;
            case 2:
                intoAnul();
                break;
            case 3:
                intoPretul();
                break;
        }

    }


    public void filter2() {

        System.out.println("Introduceti  pret,an,culoare pentru a seta  filtrarea");

        String text = scanner.nextLine();
        ArrayList<Masina> culoare=null;
        ArrayList<Masina> pret=null;
        ArrayList<Masina> an=null;
        ArrayList<Masina> all= new ArrayList<>();


        for (int i = 0; i < text.split(",").length; i++) {

            switch (text.split(",")[i]) {
                case "culoare":
                   culoare= intoCuloare();
                    if(all.size()==0){
                        all=controllMasina.intersectieListe(culoare, controllMasina.getMasini());
                    }else{
                        all=controllMasina.intersectieListe(culoare, all);
                    }
                    break;
                case "an":
                    an=intoAnul();
                    if(all.size()==0){
                        all=controllMasina.intersectieListe(an,controllMasina.getMasini());
                    } else {
                        all=controllMasina.intersectieListe(an,all);
                    }
                    break;
                case "pret":
                    pret=intoPretul();


                    if(all.size()==0){
                        all=controllMasina.intersectieListe(pret, controllMasina.getMasini());
                    }else
                    {
                        all= controllMasina.intersectieListe(pret,all);
                    }
                    break;
            }

        }
        for(Masina x:all){
            System.out.println(x.descriere());
        }
    }


    public ArrayList<Masina> intoCuloare() {
        System.out.println("Introduceti culoarea: ");
        String culoare = scanner.nextLine();
        return controllMasina.culoareMasina(culoare);
    }

    public ArrayList<Masina> intoAnul() {
        System.out.println("Introduceti anul minim");
        int anulMinim = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti anul maxim");
        int anulMaxim = Integer.parseInt(scanner.nextLine());
       return controllMasina.anMasina(anulMinim, anulMaxim);
    }

    public ArrayList<Masina> intoPretul() {
        System.out.println("Introduceti pretul minim");
        double pretMinim =Double.parseDouble(scanner.nextLine());
        System.out.println("Introduceti pretul maxim");
        double pretMaxim =Double.parseDouble(scanner.nextLine());
        return controllMasina.pretMasina(pretMinim, pretMaxim);
    }

}
