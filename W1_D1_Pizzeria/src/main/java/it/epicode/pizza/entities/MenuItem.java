package it.epicode.pizza.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// crea tutti i getter per tutti gli attributi
@Getter
// crea tutti i setter per tutti gli attributi
// possiamo anche specificare la "visibilità"
@Setter(value = AccessLevel.PROTECTED)
// crea un costruttore che accetta in input tutti i parametri 
// che corrispondono agli attributi della classe (nel loro ordine)
@AllArgsConstructor
// aggiunge il costruttore senza parametri
@NoArgsConstructor
// crea l'override del metodo toString()
@ToString
public class MenuItem {
	private String name;
	private double price;
	private int calories;
}
