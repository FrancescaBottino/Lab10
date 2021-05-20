package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Informazione {
	
	private LocalDate prima;
	private LocalDate ultima;
	private int totale;
	private double media;
	
	public Informazione(LocalDate prima, LocalDate ultima, int totale, double media) {
		super();
		this.prima = prima;
		this.ultima = ultima;
		this.totale = totale;
		this.media = media;
	}

	public LocalDate getPrima() {
		return prima;
	}

	public void setPrima(LocalDate prima) {
		this.prima = prima;
	}

	public LocalDate getUltima() {
		return ultima;
	}

	public void setUltima(LocalDate ultima) {
		this.ultima = ultima;
	}

	public int getTotale() {
		return totale;
	}

	public void setTotale(int totale) {
		this.totale = totale;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "Informazione [prima=" + prima + ", ultima=" + ultima + ", totale=" + totale + ", media=" + media + "]";
	}
	
	

}
