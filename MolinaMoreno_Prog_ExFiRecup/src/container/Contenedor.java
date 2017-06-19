package container;

import models.Pokemon;

import models.MiLista;

public class Contenedor {
//  Orden ascendente por nombre. Lo estandar seria ordenarlos por numero, pero desde la segunda/tercera 
//	edicion de pokemon se puede ordenar por nombre tipos etc.
	public static MiLista<Pokemon> ml = new MiLista<>(
			(Pokemon a, Pokemon b) -> a.getNombre().compareTo(b.getNombre()));
	

	

}
