package fr.pizzeria.console;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;

/**
 * @author Thomas
 * 
 * 
 */
public class PizzeriaAdminConsoleApp {

	static Pizza[] listePizza = new Pizza[50];

	static Scanner questionUser = new Scanner(System.in).useLocale(Locale.US);

	/**
	 * Affichage du menu principal et gestion du tableau des pizzas
	 */
	public static void main(String args[]) {

		initPizzas();
		int choixMenu = 0;

		do {

			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");

			choixMenu = questionUser.nextInt();

			switch (choixMenu) {

			case 1:
				
				System.out.println("1. Liste des pizzas");
				listeDesPizzas();

				break;

			case 2:

				ajoutPizza();

				break;

			case 3:

				upDatePizza();

				break;

			case 4:

				supprimerPizza();

				break;

			case 99:
				System.out.println("Aurevoir");
				break;

			default:
				System.out.println("Veuillez saisir un numero de menu valide");
			}
		} while (choixMenu != 99);
	}

	/**
	 * Initialisation du tableau des pizzas
	 */
	private static void initPizzas() {

		listePizza[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		listePizza[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		listePizza[2] = new Pizza(2, "REI", "La Reine", 11.50);
		listePizza[3] = new Pizza(3, "FRO", "La 4 fromage", 12.00);
		listePizza[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		listePizza[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		listePizza[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		listePizza[7] = new Pizza(7, "IND", "L'indienne", 14.00);

	}

	/**
	 * Affichage de la liste des Pizzas
	 */
	private static void listeDesPizzas() {

		for (int i = 0; i < listePizza.length; i++) {

			if (listePizza[i] != null) {

				System.out.print(listePizza[i].getCode() + " -> " + listePizza[i].getNom() + " ("
						+ listePizza[i].getPrix() + ")");

				System.out.println(" ");
			}
		}

		System.out.println(" ");
	}

	/**
	 * Ajout d'une nouvelle pizza dans le tableau
	 */
	private static void ajoutPizza() {

		System.out.println("2. Ajout d'une nouvelle pizza");

		System.out.println("veuillez saisir le code");
		String code = questionUser.next();

		System.out.println("veuillez saisir le nom (sans espace)");
		String nom = questionUser.next();

		System.out.println("veuillez saisir le prix");
		double prix = questionUser.nextDouble();

		for (int i = 0; i < listePizza.length; i++) {

			if (listePizza[i] == null) {

				listePizza[i] = new Pizza(i, code, nom, prix);
				System.out.println("Pizza ajoutée");
				System.out.println("");
				break;

			}
		}
	}

	/**
	 * Mise à jour d'une pizza dans le tableau
	 */
	private static void upDatePizza() {

		System.out.println("3. Mettre à jour une pizza");

		listeDesPizzas();

		System.out.println("veuillez saisir le code");
		String codeUpDate = questionUser.next();

		System.out.println("veuillez saisir le code");
		String code = questionUser.next();

		System.out.println("veuillez saisir le nom (sans espace)");
		String nom = questionUser.next();

		System.out.println("veuillez saisir le prix");
		double prix = questionUser.nextDouble();
		
		if (!code.equals("99")) {
			for (int i = 0; i < listePizza.length; i++) {

				if (listePizza[i] != null) {

					listePizza[i].setCode(code);
					listePizza[i].setNom(nom);
					listePizza[i].setPrix(prix);

				}
			}

			System.out.println("Pizza mise à jour");
			System.out.println("");
		}
	}

	/**
	 * Suppression d'une pizza dans le tableau
	 */
	private static void supprimerPizza() {

		System.out.println("4. Suppréssion d'une pizza");

		listeDesPizzas();

		System.out.println("veuillez saisir le code");
		String code = questionUser.next();
		if (!code.equals("99")) {
			
			for (int i = 0; i < listePizza.length; i++) {
				
				if (code.equals(listePizza[i].getCode())) {
					
					listePizza[i] = null;
					break;
				}
			}

			System.out.println("Pizza supprimée");
			System.out.println("");

		}
	}
}