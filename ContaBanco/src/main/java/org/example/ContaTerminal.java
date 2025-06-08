package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        String agencia = null;
        String nomeCliente = null;
        double saldo = 0;

        System.out.println("Seja bem-vindo(a) ao terminal bancário DIO:");

        while (numero <= 0) {
            try {
                System.out.print("Digite o número da conta: ");
                numero = sc.nextInt();
                sc.nextLine();
                if (numero <= 0) {
                    System.out.println("O número deve ser um valor inteiro positivo!");
                }
            } catch (InputMismatchException e) {
                System.out.println("O número deve ser um valor numérico!");
                sc.nextLine();
            }
        }

        while (agencia == null || agencia.trim().isEmpty()) {
            System.out.print("Digite o número da agência: ");
            agencia = sc.nextLine();
            if (agencia.trim().isEmpty()) {
                System.out.println("A agência não pode ser vazia!");
            }
        }

        while (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            System.out.print("Digite o nome do cliente: ");
            nomeCliente = sc.nextLine();
            if (nomeCliente.trim().isEmpty()) {
                System.out.println("O nome do cliente não pode ser vazio!");
            }
        }

        while (saldo <= 0) {
            try {
                System.out.print("Digite o saldo inicial da conta: ");
                saldo = sc.nextDouble();
                if (saldo <= 0) {
                    System.out.println("O saldo deve ser maior que zero!");
                }
            } catch (InputMismatchException e) {
                System.out.println("O saldo deve ser um valor numérico!");
                sc.nextLine();
            }
        }

        System.out.println("\nOlá " + nomeCliente +
                ", obrigado por criar uma conta em nosso banco. Sua agência é " + agencia +
                ", conta " + numero + " e seu saldo R$" + saldo + " já está disponível para saque.");

        sc.close();
    }
}