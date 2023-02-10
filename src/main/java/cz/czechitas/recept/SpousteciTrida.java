package cz.czechitas.recept;

import cz.czechitas.recept.naradi.*;
import cz.czechitas.recept.suroviny.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        Miska cervenaMiska;
        Miska zlutaMiska;
        Mixer mixer;
        Vaha kuchynskaVaha;
        PlechNaPeceni plech;
        ElektrickaTrouba trouba;
        Vajicka vajicka;

        Ovoce ovoce;
        Maslo maslo125g;
        Mouka pytlikMouky;
        Cukr pytlikCukru;
        PrasekDoPeciva prasekDoPeciva;

        cervenaMiska = new Miska("cervenaMiska");
        zlutaMiska = new Miska("zlutaMiska");
        mixer = new Mixer("mixer");
        kuchynskaVaha = new Vaha("vaha");
        plech = new PlechNaPeceni("plech");
        trouba = new ElektrickaTrouba("trouba");

        vajicka = new Vajicka("vajicka");
        ovoce = new Ovoce("ovoce");
        maslo125g = new Maslo("maslo125g");
        pytlikMouky = new Mouka("pytlikMouky");
        pytlikCukru = new Cukr("pytlikCukru");
        prasekDoPeciva = new PrasekDoPeciva("prasekDoPeciva");

        //---------------------------------------------------------------------

        // TODO: Sem napiste recept na bublaninu
        // Pouzivejte napovidani v editoru.
        // Vyskakuje samo nebo pomoci Ctrl+Mezernik

        //Miska si 4x vloží vajíčko
        for (int i = 0; i < 4; i++) {
            cervenaMiska.nalozSiJedenKus(vajicka);
        }
        //Miska si přidá cukr
        cervenaMiska.nalozSiCelyObsah(pytlikCukru);

        //Mixér to zamíchá
        mixer.zamichej(cervenaMiska);

        //Miska si přidá máslo + Mixér to znovu zamíchá
        cervenaMiska.nalozSiCelyObsah(maslo125g);
        mixer.zamichej(cervenaMiska);

        //PDruhá miska si odváží 250g mouky To není tak jednoduché, máme jen 1kg pytlík. Budeme potřebovat vynulovanou váhu s prázdnou miskou. Miska si může vzít trochu mouky, zvážit se, a pokud je to víc než 250 g, zase trochu mouky ubrat. Pokud méně, znovu přidat. A tak pořád dokola, dokud nebude mít správné množství.

        kuchynskaVaha.vynulujSeS(zlutaMiska);
        //zlutaMiska.nalozSiTrochu(pytlikMouky);
        //kuchynskaVaha.zjistiHmotnost(zlutaMiska);

        while (kuchynskaVaha.zjistiHmotnost(zlutaMiska) != 250) {


            if (kuchynskaVaha.zjistiHmotnost(zlutaMiska) < 250) {

                zlutaMiska.nalozSiTrochu(pytlikMouky);
            } else {
                zlutaMiska.vylozSiTrochu();
            }}

            //První miska si mouku přebere
            cervenaMiska.nalozSiObsahJineMisky(zlutaMiska);

            //První miska si vezme prášek do pečiva + Mixér to zamíchá
            cervenaMiska.nalozSiCelyObsah(prasekDoPeciva);
            mixer.zamichej(cervenaMiska);

            //Plech si přebere těsto z misky
            plech.preberSiObsah(cervenaMiska);

            // Plech se 50x opakovaně posype kousky ovoce
            for (int i = 0; i < 50; i++) {
                plech.posypSeKusem(ovoce);
            }

            //Trouba se zapne a třeba 5 minut bude péct naprázdno
            trouba.zapniSe(180);
            trouba.nechejPect(5);

            //Trouba si vloží plech
            trouba.vlozSiDovnitr(plech);

            //Trouba ho bude péct 25 minut
            trouba.nechejPect(25);

            //Trouba se zastaví
            trouba.vypniSe();


            //Trouba vyndá obsah ven a je hotovo :-)
            trouba.vyndejObsahVen();


        }

    }
