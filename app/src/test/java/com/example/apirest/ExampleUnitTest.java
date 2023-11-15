package com.example.apirest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testChoisirRecetteEnFonctionDesConditions() {

        Recettes instance = new Recettes();

        assertEquals("Soupe réconfortante", instance.choisirRecetteEnFonctionDesConditions("Pluvieux").getNom());
        assertEquals("Salade fraîche", instance.choisirRecetteEnFonctionDesConditions("Ensoleillé").getNom());
        assertEquals("Chocolat chaud", instance.choisirRecetteEnFonctionDesConditions("Enneigé").getNom());
        assertEquals("Ragoût hivernal", instance.choisirRecetteEnFonctionDesConditions("Très froid").getNom());
        assertEquals("Tourte au poulet", instance.choisirRecetteEnFonctionDesConditions("Venteux").getNom());
        assertEquals("Pâtes aux champignons", instance.choisirRecetteEnFonctionDesConditions("Nuageux").getNom());
        assertEquals("Casserole de poulet et légumes", instance.choisirRecetteEnFonctionDesConditions("Couvert").getNom());
        assertEquals("Recette par défaut", instance.choisirRecetteEnFonctionDesConditions("ConditionInconnue").getNom());
    }
}
