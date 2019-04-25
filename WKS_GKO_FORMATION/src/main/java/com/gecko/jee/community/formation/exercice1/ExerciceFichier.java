package com.gecko.jee.community.formation.exercice1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <h1>Concatiner les fichiers!</h1> C'est un programme qui permet de concatiner
 * le contenu des fichiers .txt dans un autre fichier
 *
 * @author selman fersi
 *
 */

public class ExerciceFichier {
	/**
	 * Cette méthode permet de concatiner le contenu des fichiers .txt qui se
	 * trouvent dans un chemin donné
	 * 
	 * @param fichierDestination C'est le fichier destination où on va concatiner le
	 *                           contenus des fichiers
	 * 
	 * @param cheminSource       C'est le chemin source où on va se pointer pour
	 *                           récuperer la liste des fichiers
	 * @return File Elle retourne le fichier output remplit.
	 * @throws TechicalException
	 */
	public File concatFichier(File fichierDestination, final String cheminSource) throws TechicalException {
		// vérifier si le fichier est null
		if (fichierDestination == null) {
			throw new TechicalException("Le fichier indiqué n'existe pas", 1);
		} else {
			try {
				// Exsposer le fichier destination pour qu'on puisse le modifier
				PrintWriter writerDestination = new PrintWriter(fichierDestination);

				// Se pointer sur le chemin source
				Files.newDirectoryStream(Paths.get(cheminSource), path -> path.toString().endsWith(".txt"))
						.forEach(fichier -> {

							// Lister tous les fichiers .txt

							try {
								ecrireDestination(fichier, writerDestination);
							} catch (TechicalException technicalException) {
								technicalException.printStackTrace();
							}

						});
				// Cloturer la concaténation dans le fichier destination.
				writerDestination.close();
			} catch (IOException e) {
				throw new TechicalException("Poblème d'écriture", 1);
			}
		}
		return fichierDestination;

	}

	/**
	 * Cette méthode permet de ecrire le contenu d'un fichier donné dans un fichier
	 * destination
	 * 
	 * 
	 * @param fichier           C'est le chemin du fichier qui va etre concatiner
	 *                          dans le fichier destination
	 * 
	 * @param writerDestination C'est l'object où on va ecrire
	 * @return PrintWriter Elle retourne l'object output remplit.
	 * @throws TechicalException
	 */
	private PrintWriter ecrireDestination(Path cheminFichier, PrintWriter writerDestination) throws TechicalException {
		try {
			Files.lines(Paths.get(cheminFichier.toUri())).forEach(contenu -> {
				// Concatiner le contenu dans le fichier destination
				writerDestination.append(contenu + "\n");

			});
		} catch (IOException technicalException) {
			throw new TechicalException("Poblème d'itération", 1);

		}
		return writerDestination;
	}
}
