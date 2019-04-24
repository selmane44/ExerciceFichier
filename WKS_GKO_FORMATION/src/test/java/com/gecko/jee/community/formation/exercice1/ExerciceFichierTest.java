package com.gecko.jee.community.formation.exercice1;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExerciceFichierTest {

	@Test
	void concatTestFiles() {
		/* Création d'une instance de la class ExerciceFichier. */
		ExerciceFichier exerciceFichier = new ExerciceFichier();
		try {
			/* Créer un fichier destination en précisant son chemin. */
			File fichierDestination = new File("C:/Users/GMI/Desktop/Selmane_Docs/all.txt");

			/*
			 * Concatiner les fichies qui se trouvent dans le chemin indiqué dans
			 * l'argument.
			 */
			File fichierOutput = exerciceFichier.concatFichier(fichierDestination, "C:/Users/GMI/Desktop/Selmane_Docs");
			Assert.assertNotNull(fichierOutput);
			
			/* lever l'exception Technical exception*/
			exerciceFichier.concatFichier(null, "C:/Users/GMI/Desktop/Selmane_Docs");

		    Assertions.assertThrows(TechicalException.class, () -> {
		     System.out.println("L'exception est levée correctement");		      
		    });
		    
		} catch (IOException | TechicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
