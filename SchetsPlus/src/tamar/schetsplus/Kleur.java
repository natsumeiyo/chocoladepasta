package tamar.schetsplus;
import java.awt.Color;

class Kleur {
	String naam;
	Color kleur;

	public Kleur(String naam, Color kleur) {
		this.naam = naam;
		this.kleur = kleur;
	}

	public Color getKleur() {
		return kleur;
	}

	public String toString() {
		return naam;
	}
}