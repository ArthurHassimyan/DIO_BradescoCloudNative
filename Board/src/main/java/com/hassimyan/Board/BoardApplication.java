package com.hassimyan.Board;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hassimyan.Board.service.Services;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

@SpringBootApplication
public class BoardApplication implements CommandLineRunner {

	@Autowired
	private Services service;

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("--- Menu Principal ---");
			System.out.println("1 - Criar novo board");
			System.out.println("2 - Selecionar board");
			System.out.println("3 - Excluir boards");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
				case 1 -> service.createBoard(scanner);
				case 2 -> service.selectBoard(scanner);
				case 3 -> service.deleteBoards();
				case 4 -> {
					System.out.println("Encerrando...");
					return;
				}
				default -> System.out.println("Opção inválida.");
			}
		}
	}

}
