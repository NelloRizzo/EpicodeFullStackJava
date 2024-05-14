package it.epicode.pizzas.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
//implementazione del pattern Builder (maggiori info su https://refactoring.guru/design-patterns/builder)
//crea un metodo statico chiamato builder() nella classe Table, attraverso il quale
//costruire un table. Il metodo restituisce un oggetto con tanti metodi withXXXX (setterPrefix)
//(nel nostro caso withName() e withMaxPlaces() attraverso i quali impostare i valori
//per i parametri del table. Una volta configurato il builder, è possibile richiamare
//il metodo build() per ottenere il Table vero e proprio (l'uso di un builder è 
//presentato nella classe OrderRunner).
//La comodità del builder è legata al fatto che, spesso, risulta difficile ricordare
//tutti i parametri di un costruttore, così, attraverso il builder io posso impostare 
//uno a uno i parametri secondo l'ordine che mi piace di più, tanto poi sarà il metodo 
//build() a costruire automaticamente l'oggetto richiamando il costruttore con tutti i 
//parametri nell'ordine giusto.
@Builder(setterPrefix = "with")
public class Order {
	@ToString.Include
	private final List<OrderItem> items = new ArrayList<>();
	private double placeAmount;
	private int totalPlaces;
	private String number;
	private LocalDateTime dateTime;
	private Table table;

	@ToString.Include(name = "totalPrice")
	public double getTotalPrice() {
		return placeAmount * totalPlaces + items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
	}
}
