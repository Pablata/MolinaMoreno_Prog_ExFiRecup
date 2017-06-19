package main;

import gui.Pokedex;
import models.Pokemon;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pokemon p1 = new Pokemon("pikachu", 27, 1, "Kanto", "Electrico", "");

		Pokemon p2 = new Pokemon("Bulbasaur", 1, 1, "Kanto", "Planta", "");

		Pokemon p3 = new Pokemon("Mew", 151, 1, "Desconocido", "Psiquico", "");

		container.Contenedor.ml.add(p1);
		container.Contenedor.ml.add(p2);
		container.Contenedor.ml.add(p3);

		Pokedex t = new Pokedex();
		t.main(null);

	}

}
