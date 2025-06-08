package com.hassimyan.Board.service;

import com.hassimyan.Board.Model.Board;
import com.hassimyan.Board.Model.ColumnBoard;
import com.hassimyan.Board.Model.TypeColumn;
import com.hassimyan.Board.repository.ColumnBoardRepository;
import com.hassimyan.Board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Services {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private ColumnBoardRepository columnRepository;

    private ColumnBoard createColumn(Scanner scanner, TypeColumn type, int order) {
        System.out.print("Nome da coluna (" + type + "): ");
        String name = scanner.nextLine();
        ColumnBoard col = new ColumnBoard();
        col.setName(name);
        col.setColumnOrder(order);
        col.setType(type);
        return col;
    }

    public void createBoard(Scanner scanner) {
        System.out.print("Digite o nome do board: ");
        String name = scanner.nextLine();
        Board board = new Board();
        board.setName(name);

        List<ColumnBoard> columns = new ArrayList<>();
        columns.add(createColumn(scanner, TypeColumn.INITIAL, 0));

        int order = 1;
        while (true) {
            System.out.print("Deseja adicionar uma coluna pendente? (s/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("s")) break;
            columns.add(createColumn(scanner, TypeColumn.PENDING, order++));
        }

        columns.add(createColumn(scanner, TypeColumn.FINAL, order++));
        columns.add(createColumn(scanner, TypeColumn.CANCELLED, order));

        for (ColumnBoard col : columns) {
            col.setBoard(board);
        }

        board.setColumns(columns);
        boardRepository.save(board);
        System.out.println("Board criado com sucesso!");
    }

    public void selectBoard(Scanner scanner) {
        List<Board> boards = boardRepository.findAll();
        if (boards.isEmpty()) {
            System.out.println("Nenhum board cadastrado.");
            return;
        }
        for (int i = 0; i < boards.size(); i++) {
            System.out.println((i + 1) + " - " + boards.get(i).getName());
        }
        System.out.print("Escolha o número do board: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > boards.size()) {
            System.out.println("Board inválido.");
            return;
        }

        Board selected = boards.get(index - 1);
        System.out.println("Board selecionado: " + selected.getName());
        // Aqui você pode invocar um submenu para gerenciar o board
    }

    public void deleteBoards() {
        boardRepository.deleteAll();
        System.out.println("Todos os boards foram excluídos.");
    }
}
