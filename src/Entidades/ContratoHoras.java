package Entidades;

import java.util.Date;

public class ContratoHoras {
	
	private Date date;
	private Double valorproHora;
	private Integer horas;
	public ContratoHoras() {
	}
	
	public ContratoHoras(Date date, Double valorproHora, Integer horas) {
		this.date = date;
		this.valorproHora = valorproHora;
		this.horas = horas;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getValorproHora() {
		return valorproHora;
	}
	public void setValorproHora(Double valorproHora) {
		this.valorproHora = valorproHora;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public double valorTotal() {     //operação calcular valor total do contrato
		return valorproHora * horas;
	}

}
