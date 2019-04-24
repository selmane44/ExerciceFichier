package com.gecko.jee.community.formation.exercice1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

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
	 * @param fichierDestination C'est le premier argument pour la methode
	 *                           concatFichier
	 * @param cheminSource       C'est le deuxième argument pour la methode
	 *                           concatFichier
	 * @return File Elle retourne le fichier output crée.
	 * @throws TechicalException 
	 */
	public File concatFichier(File fichierDestination, final String cheminSource) throws IOException, TechicalException {
        /* vérifier si le fichier est null*/
		if (fichierDestination == null)
			throw new TechicalException("Le fichier indiqué est null",1);
		
		/* Exsposer le fichier destination pour qu'on puisse le modifier */
		PrintWriter writerDestination = new PrintWriter(fichierDestination);
		
		/* Se pointer sur le chemin source */
		Files.newDirectoryStream(Paths.get(cheminSource), path -> path.toString().endsWith(".txt")).forEach(path -> {
			
			try {
			     	/* Lister tous les fichiers .txt */			
					Files.lines(Paths.get(path.toUri())).forEach(element -> {
					/* Concatiner le contenu dans le fichier destination */
					writerDestination.append(element + "\n");
					
				});
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		});
		/* Cloturer la concaténation dans le fichier destination. */
		writerDestination.close();
		return fichierDestination;

	}

}
