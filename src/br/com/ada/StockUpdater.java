package br.com.ada;

import br.com.ada.exibicao.Estoque;
import br.com.ada.vo.Produto;

import java.util.Scanner;

    /*
        Você foi contratado para desenvolver um sistema simples para gerenciar o inventário de uma loja. O sistema deve permitir ao usuário controlar
         a quantidade de um determinado produto em estoque.

        Funcionalidades
        Menu de opções
        Crie um menu que permita ao utilizador realizar as operações abaixo repetidamente até que ele escolha encerrar o programa.

        1 - Atualizar o estoque de um produto - Ok
        2 - Permitir aumentar ou diminuir a quantidade disponível de um produto.
        3 - Calcular o valor total em estoque
        4 - Dado o preço de um produto, calcular o valor total em estoque.
     */

public class StockUpdater {

    String[] descProds;
    Integer[] quantProds;
    Double[] precoProds;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Estoque estoque = new Estoque();

        System.out.println("Digite a quantidade de produtos que deseja cadastrar: ");
        int qtdProdutos = entrada.nextInt();

        estoque.atualizaEstoque(qtdProdutos);
        estoque.consultaEstoque ();
        estoque.calculaValorEstoque();

        System.out.println ( "Deseja atualizar preços dos Produtos? 1 /p Sim - 2 p/ Não " );
        int atauPreco = entrada.nextInt();

        if (atauPreco == 1) {
            estoque.atualizaPreco();
            estoque.consultaEstoque ();
            estoque.calculaValorEstoque();
        }

        while (true) {

            System.out.println("Deseja continuar ajustando o Estoque ? 1 = Sim / 2 = Não ");
            int simNao = entrada.nextInt();

            estoque.consultaEstoque();
            estoque.calculaValorEstoque();
            if (simNao == 1) {
                estoque.atualizaEstoque(qtdProdutos);
            }
            else {
                break;
            }


        }
    }
    // Codigo antigo (Antes de ser refatorado em aula)
/*
    public static void main2(String[] args) {
        StockUpdater updater = new StockUpdater (); // instancia da classe por não ter declarado static
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a quantidade de produtos que deseja cadastrar: ");
        int qtdp = entrada.nextInt();
        // Call functions
        updater.atualizaEstoque(qtdp);
        updater.consultaEstoque();
        updater.calculaValorEstoque();

        System.out.println ( "Deseja atualizar preços dos Produtos? 1 /p Sim - 2 p/ Não " );
        int atauPreco = entrada.nextInt();
        if (atauPreco == 1) {
            updater.atualizaPreco();
        }


        for (int i = 0; i < updater.descProds.length; i++) {
            System.out.println("Produto: " + updater.descProds[i] + "Quantidade =  " + updater.quantProds[i]);
        }

        while (true) {

            System.out.println("Deseja continuar ajustando o Estoque ? 1 = Sim / 2 = Não ");
            int simNao = entrada.nextInt();
            updater.consultaEstoque();
            updater.calculaValorEstoque();

            if (simNao == 1) {
//                updater.consultaEstoque();
//                updater.calculaValorEstoque();
                updater.atualizaEstoque(qtdp);
            } else {
                break;
            }


        }
    }
*/
    public void atualizaEstoque(int qtdp) {
        descProds = new String[qtdp]; // Quantidade ou tamanho do array
        quantProds = new Integer[qtdp];
        precoProds = new Double[qtdp];

        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < descProds.length; i++) {
            entrada.nextLine();
            System.out.printf("Digite a Descrição do %d° Produto: \n", i + 1);
            descProds[i] = entrada.nextLine();
        }
        for (int i = 0; i < quantProds.length; i++) {
            System.out.printf("Digite a Quantidade do produto: %s: \n", descProds[i]);
            quantProds[i] = entrada.nextInt();
        }
        for (int i = 0; i < precoProds.length; i++) {
            System.out.printf("Digite o Preço do produto: %s: \n", descProds[i]);
            precoProds[i] = entrada.nextDouble();
        }
    }

    public void consultaEstoque() {
        System.out.println("Consulta de Estoque:");
        for (int i = 0; i < descProds.length; i++) {
            System.out.println(descProds[i] + " - Quantidade: " + quantProds[i] + " - Preço: " + precoProds[i]);
        }
    }

    public void calculaValorEstoque() {
        double valorTotal = 0;
        for (int i = 0; i < descProds.length; i++) {
            valorTotal += quantProds[i] * precoProds[i];
        }
        System.out.println("Valor total em estoque: " + valorTotal);
    }

    public void atualizaPreco() {
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < descProds.length; i++) {
            System.out.printf("Digite o novo preço do produto %s: \n", descProds[i]);
            precoProds[i] = entrada.nextDouble();
        }
    }


// Codigo novo refatorado em aula
    /*  --- todo o código abaixo foi refatorado em aula --- transformando em classes e métodos --- */
    /*
    static class Estoque {
        Scanner entrada = new Scanner(System.in);
        Produto[] produtos;

        public void atualizaEstoque(int qtdProdutos ) {

            if (qtdProdutos == 0) {
                System.out.println("Digite a quantidade de produtos que deseja cadastrar: ");
                 qtdProdutos = entrada.nextInt();
            }
            produtos = new Produto[qtdProdutos];

            for (int i = 0; i < produtos.length; i++) {
                Produto p = new Produto();
               // entrada.nextLine(); // Limpar o buffer
                System.out.printf("Digite a Descrição do %d° Produto: \n", i + 1);
                p.descricao = entrada.nextLine();

                System.out.printf("Digite a Quantidade do produto: %s: \n", p.descricao);
                p.quantidade = entrada.nextInt();

                System.out.printf("Digite o Preço do produto: %s: \n", p.descricao);
                p.preco = entrada.nextDouble();
                entrada.nextLine ();
                produtos[i] = p;
            }

        }

        public void consultaEstoque() {
            System.out.println("Consulta de Estoque:");

            for (int i = 0; i < produtos.length; i++) {
                Produto p = produtos[i];
                System.out.println(p.descricao + " - Quantidade: " + p.quantidade + " - Preço: " + p.preco);
            }
        }

        public void calculaValorEstoque() {
            double valorTotal = 0;
            for (int i = 0; i < produtos.length; i++) {
                Produto p = produtos[i];
                valorTotal += p.quantidade * p.preco;
            }
            System.out.println("Valor total em estoque: " + valorTotal);
        }

        public void atualizaPreco() {
            for (int i = 0; i < produtos.length; i++) {
                Produto p = produtos[i];
                System.out.printf("Digite o novo preço do produto %s: \n", p.descricao);
                p.preco = entrada.nextDouble();
            }
        }
    }

    static class Produto {
        String descricao;
        int quantidade;
        double preco;
    }
*/
}