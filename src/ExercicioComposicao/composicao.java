package ExercicioComposicao;


import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.ContratoHoras;
import Entidades.Departamento;
import Entidades.Trabalhador;
import Entidades.enums.Level;

public class composicao {

	public static void main(String[] args) throws ParseException {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
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

		System.out.print("Quantos contratos o trabalhador vai ter? ");
		int n = scanner.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("inserir dados do contratro #" + i + ": ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContratos = sdf.parse(scanner.next());
			//adicionar um simpleDataFormat para conseguir usar formato de data, e .parse(scanner.next() para pegar o q for digitado
			System.out.print("Valor por hora: ");
			double valorH = scanner.nextDouble();
			System.out.print("Duração contrato: ");
			int duracao = scanner.nextInt();
			//Agora instanciar contrato
			ContratoHoras contratoH = new ContratoHoras(dataContratos, valorH, duracao);
			//associar método contratoH com o trabalhador. 
			/*Toda vez que for chamado addContratos passando um contrato de argumento, esse contrato
			 será adicionado na list(que iniciou vazia) a partir do método addContratos que está na classe Trabalahdor*/
			trabalhador.addContratos(contratoH);
		}
		//esse for será repetido várias vezes até associar todos os contratos com o trabalhador
		System.out.println();
		System.out.print("Entre com mês e ano para calcular salário (MM/YYYY): ");
		String mesAno = scanner.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2)); //para cortar string e gerar um de 2 digitos da posição 0 até 2
		//Integer.parseInt para converter para inteiro
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome()); //para acessar objeto departamento e seu nome
		System.out.printf("Renda " + mesAno + ":" + String.format("%.2f",trabalhador.renda(ano, mes)));
		// String.format("%.2f", para ser com 2 casas decimais
		
		
		scanner.close();
	}

	

}
