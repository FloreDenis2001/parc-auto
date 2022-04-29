import controller.ControllMasina;
import model.Masina;
import view.View;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
//
//        ControllMasina controllMasina = new ControllMasina();
//
////        controllMasina.sortarePret();
////
////        controllMasina.afisareMasini();
////
////        if(controllMasina.existMasina(17)==false){
////            System.out.println("Masina nu exista");
////        }else if(controllMasina.existMasina(17)==true){
////            System.out.println("Masina exista");
////        }
////
//////        Masina x = new Masina("Dacia","Alba",2010,14,5150);
////        Masina x = new Masina("BMW","verde",2010,14,5150);
////        controllMasina.addCar(x);
////        controllMasina.afisareMasini();
////        controllMasina.updatePriceById(13,156115);
////        Masina x = new Masina("Mercedes","rosu",2021,13,156115);
//
//        controllMasina.deleteCarById(62);
//        controllMasina.afisareMasini();
//        System.out.println("After");
//        controllMasina.deleteCarById(13);
//        controllMasina.afisareMasini();
        ControllMasina controllMasina = new ControllMasina();
//         ArrayList<Masina> listaMasini= controllMasina.anMasina(2011, 2020);
//         for(Masina x:listaMasini){
//             System.out.println(x.descriere());
//         }


//         ArrayList<Masina> listaMasiniculoare= controllMasina.culoareMasina("rosu");
//         for(Masina x:listaMasiniculoare){
//             System.out.println(x.descriere());
//         }
//
//         ArrayList<Masina> listaMasinipret= controllMasina.pretMasina(5132.51,80551.51);
//         for(Masina x:listaMasinipret){
//             System.out.println(x.descriere());
//         }
//        controllMasina.afisareMasini();
//        controllMasina.culoareMasina("rosu");
//        controllMasina.pretMasina(5000, 80000);

        View view = new View();

        view.play();
//       ArrayList<Masina> pret= view.intoPretul();
//     for (Masina x:pret){
//         System.out.println(x.descriere());
//     }
//     ArrayList<Masina> culoare= view.intoCuloare();
//     for (Masina x:culoare){
//         System.out.println(x.descriere());
//     }
//     ArrayList<Masina> an= view.intoAnul();
//     for (Masina x:an){
//         System.out.println(x.descriere());
//     }


    }
}
