package com.gecko.jee.community.formation.exercice1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author selman fersi
 *
 */
class ExerciceFichierTest {

	@Test
	void concatTestFiles() {
		// Création d'une instance de la class ExerciceFichier.
		ExerciceFichier exerciceFichier = new ExerciceFichier();

		// Créer un fichier destination en précisant son chemin.
		File fichierDestination = new File("C:/Users/GMI/Desktop/Selmane_Docs/all.txt");

		// Concatiner les fichies qui se trouvent dans le chemin indiqué dans
		// l'argument.

		try {
			File fichierOutput = exerciceFichier.concatFichier(fichierDestination, "C:/Users/GMI/Desktop/Selmane_Docs");
			Assert.assertNotNull(fichierOutput);
		} catch (TechicalException exception) {
			exception.printStackTrace();
		}

		// lever l'exception Technical exception
		try {
			exerciceFichier.concatFichier(null, "C:/Users/GMI/Desktop/Selmane_Docs");
			Assert.fail();
		} catch (TechicalException exc) {
			// Ok
		}

		// tester le nombre de ligne de la destination
		Assert.assertEquals(3, nombreLigne(fichierDestination));
	}

	/**
	 * Cette méthode permet de calculer le nombre de ligne d'un fichier donné
	 * 
	 * 
	 * @param fichier C'est le fichier là où on va calculer le nombre de ses lignes
	 * 
	 * @return int Elle retourne le nombre de ligne d'un fichier
	 */
	private int nombreLigne(File fichier) {
		int nbLigne = 0;
		try {

			String ligne = null;
			BufferedReader reader = new BufferedReader(new FileReader(fichier));
			// si on arrive ici le reader est instancié donc il faudra fermer les flux
			try {
				// tant qu'il il a au moins une ligne à lire
				while ((ligne = reader.readLine()) != null) {
					// on incrémente le compteur
					nbLigne++;
				}
			} finally {
				reader.close();
			}

		} catch (IOException ex) {
			// erreur d'entrée/sortie ou fichier non trouvé
			ex.printStackTrace();
		}
		return nbLigne;

	}

}
