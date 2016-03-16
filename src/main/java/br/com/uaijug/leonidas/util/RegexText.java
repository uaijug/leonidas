package br.com.uaijug.leonidas.util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexText {
	public static void main(String[] args) throws IOException {

		String extract = "2627405427991000000031MGANICE GOMES ELIAS                            7538837566830690100000034181001154043";

		Pattern pattern = Pattern
				.compile("^([0-9]{5})([0-9]{7})([0-9]{7})([0-9]{3})([a-zA-Z]{2})([a-zA-Z\\s]{45}+)([0-9]{11})([0-9]{5})([0-9]{1})([0-9]{11})([0-9]{9})"); // ^([0-9]{11})([a-zA-Z]+)

		// Executo o matcher
		Matcher matcher = pattern.matcher(extract);

		// Se encontrar algo
		while (matcher.find()) {
			// Posso pegar o conteudo do grupo 1 que esta em parenteses
			System.out.println("Orgao: " + matcher.group(1));
			System.out.println("Matricula: " + matcher.group(2));
			System.out.println("descarte: " + matcher.group(3));
			System.out.println("descarte ddd: " + matcher.group(4));
			System.out.println("UF: " + matcher.group(5));
			System.out.println("nome: " + matcher.group(6));
			System.out.println("CPF: " + matcher.group(7));
			System.out.println("Rubrica: " + matcher.group(8));
			System.out.println("digito descarte: " + matcher.group(9));
			System.out.println("valor: " + matcher.group(10));
			System.out.println("DEscarte vvalor: " + matcher.group(11));
		}
		System.out.println("========");
	}
}
