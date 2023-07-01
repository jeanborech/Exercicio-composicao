package Entidades;

import java.util.ArrayList;
import java.util.List;

import Entidades.enums.Level;

public class Contratos {

	private String nome;
	private Level level;
	private Double salarioBase;

	private Departamento departamento;
	private List<ContratoHoras> contratos = new ArrayList<>(); // tipo list já tem que ser instanciada/iniciar vazia,
																// não vai list no construtor
															 

	public Contratos() {
	}

	public Contratos(String nome, Level level, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHoras> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoHoras> contratos) {
		this.contratos = contratos;
	}

}
