package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.BiConsumer;

import Entidades.enums.Level;

public class Trabalhador {

	private String nome;
	private Level level;
	private Double salarioBase;

	private Departamento departamento;
    private List<ContratoHoras> contratos = new ArrayList<>(); // tipo list já tem que ser instanciada/iniciar vazia, não vai list no construtor
	//apenas get e não set, pois set permite trocar a lista. mas só vamos remover ou adicionar a lista a partir dos métodos
															 

	public Trabalhador() {
	}

	public Trabalhador(String nome, Level level, Double salarioBase, Departamento departamento) {
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

  //método vai pegar a lista contratos e adicionar ao contracts aqui que veio como argumento
  //dois métodos para adicionar ou remover a associação do trabalhador com contratos
	public void addContratos(ContratoHoras contract) {
		contratos.add(contract); //adicionado a lista o contrato
	}
	
	public void removerContrato(ContratoHoras contract) {
		contratos.remove(contract);
	}
	//renda vai ser a soma do sálario base mais contratos no mês
	public double renda(int ano, int mes) {
		Calendar calendario = Calendar.getInstance();
		double soma = salarioBase;
		for (ContratoHoras c : contratos) { // testar se contrato c é do ano e do mês, caso ele seja acrescenta na soma
			calendario.setTime(c.getDate()); //pega data contrato c.getDate() e definiu a data como sendo do calendário
			int c_ano = calendario.get(Calendar.YEAR);
			int c_mes = 1 + calendario.get(Calendar.MONTH);//+1 pq o mês do calendar começa em 0
			
			if (ano == c_ano && mes == c_mes) {    // se esse if for verdadeiro o contrato c será deste mês e ano ai entra na soma
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
	
}
