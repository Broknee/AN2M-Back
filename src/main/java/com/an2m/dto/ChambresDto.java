package com.an2m.dto;

import jakarta.validation.constraints.NotEmpty;

public class ChambresDto {
	
	private int id;
	@NotEmpty
	private int numero_chambre;
	
	public ChambresDto(int id, @NotEmpty int numero_chambre) {
		this.id = id;
		this.numero_chambre = numero_chambre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero_chambre() {
		return numero_chambre;
	}

	public void setNumero_chambre(int numero_chambre) {
		this.numero_chambre = numero_chambre;
	}

	@Override
	public String toString() {
		return "ChambresDto [id=" + id + ", numero_chambre=" + numero_chambre + "]";
	}
	

}
