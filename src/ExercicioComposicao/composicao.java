package ExercicioComposicao;

import java.util.Scanner;

import Entidades.Departamento;
import Entidades.Trabalhador;
import Entidades.enums.Level;

public class composicao {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Departamento: ");
		String departamentoNome = scanner.nextLine();
		
		System.out.println("Dados trabalhador: ");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Level: ");
		String levels = scanner.nextLine();
		System.out.print("Salário base: ");
		double salarioBase = scanner.nextDouble();

		//Level é o tipo enumerado, usamos .valueOf() conversão de String para enum.
		//Departamento é um outro objeto. Sendo necessário instanciar para criar a associação com trabalhador
		Trabalhador trabalhador = new Trabalhador(nome, Level.valueOf(levels), salarioBase, new Departamento(departamentoNome));
		//assim, irá instanciar 2 objetos = trabalhador e Departamento, que estaram associados entre si

		
		
		
		
		scanner.close();
	}

}
