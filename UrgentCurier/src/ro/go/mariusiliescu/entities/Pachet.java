package ro.go.mariusiliescu.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ro.go.mariusiliescu.entities.persoane.Destinatar;

@Entity
@Table(name = "PACHET")
public class Pachet {
	@Id
    @GeneratedValue
    @Column(name="COD_PACHET")
	private long codPachet;
	
	@Column(name="GREUTATE")
	private float greutate;
	
	@Embedded
	private Dimensiune dimensiune;
	
	@Enumerated(EnumType.STRING)
	@Column(name="CONDITII_SPECIALE")
	private SpecialConditions conditiiSpeciale;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STARE_PACHET")
	private StarePachet starePachet;
	
	@ManyToOne
    @JoinColumn(name="ID_DESTINATAR")
	private Destinatar destinatar;

	@ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name="COD_COMANDA")
	private Comanda comanda;
	
	
	public Pachet(float greutate, Dimensiune dimensiune, SpecialConditions conditiiSpeciale,
			StarePachet starePachet, Destinatar destinatar) {
		super();
		this.greutate = greutate;
		this.dimensiune = dimensiune;
		this.conditiiSpeciale = conditiiSpeciale;
		this.starePachet = starePachet;
		this.destinatar = destinatar;
	}
	
	public Pachet(Pachet p) {
		super();
		this.greutate = p.greutate;
		this.dimensiune = p.dimensiune;
		this.conditiiSpeciale = p.conditiiSpeciale;
		this.starePachet = p.starePachet;
		this.destinatar = p.destinatar;
	}
	
	public long getCodPachet() {
		return codPachet;
	}

	public void setCodPachet(long codPachet) {
		this.codPachet = codPachet;
	}

	public float getGreutate() {
		return greutate;
	}

	public void setGreutate(float greutate) {
		this.greutate = greutate;
	}

	public Dimensiune getDimensiune() {
		return dimensiune;
	}

	public void setDimensiune(Dimensiune dimensiune) {
		this.dimensiune = dimensiune;
	}

	public SpecialConditions getConditiiSpeciale() {
		return conditiiSpeciale;
	}

	public void setConditiiSpeciale(SpecialConditions conditiiSpeciale) {
		this.conditiiSpeciale = conditiiSpeciale;
	}

	public StarePachet getStarePachet() {
		return starePachet;
	}

	public void setStarePachet(StarePachet starePachet) {
		this.starePachet = starePachet;
	}

	public Destinatar getDestinatar() {
		return destinatar;
	}

	public void setDestinatar(Destinatar destinatar) {
		this.destinatar = destinatar;
	}

	@Override
	public String toString() {
		return "Destinatar : "+destinatar.getNume()+" "+destinatar.getPrenume()+" Pachet: "+"cod "+getCodPachet()+" , "+getConditiiSpeciale().name();
	}	
}
