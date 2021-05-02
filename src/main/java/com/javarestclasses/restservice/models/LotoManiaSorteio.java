package com.javarestclasses.restservice.models;

import java.util.ArrayList;
import java.util.List;

public class LotoManiaSorteio {
	
	private Integer sorteio;
	private List<Integer> ordemSorteio;
	
	public LotoManiaSorteio(Integer sorteio) {
		super();
		this.sorteio = sorteio;
		this.ordemSorteio = new ArrayList<>();
	}

	public Integer getSorteio() {
		return sorteio;
	}

	public void setSorteio(Integer sorteio) {
		this.sorteio = sorteio;
	}

	public List<Integer> getOrdemSorteio() {
		return ordemSorteio;
	}

	public void setOrdemSorteio(List<Integer> ordemSorteio) {
		this.ordemSorteio = ordemSorteio;
	}
}
