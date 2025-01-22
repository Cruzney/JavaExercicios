import java.util.Random;
import java.util.Scanner;

public class ForcaGame {
    public static void main(String[] args) {
        /*
        Neste desafio, você deverá implementar um jogo da forca simples em Java. O objetivo é criar um programa interativo
        em que o jogador tente adivinhar uma palavra secreta, letra por letra, dentro de um número limitado de tentativas.

        Requisitos do Desafio
        Palavra Secreta

        O programa deve armazenar uma palavra secreta escolhida aleatoriamente a partir de uma lista pré-definida.
                Use uma lista com pelo menos 5 palavras diferentes.
        Interação com o Jogador

        O programa deve exibir o progresso da palavra (letras adivinhadas e traços para letras não adivinhadas).
        Exemplo: Para a palavra secreta "JAVA", se o jogador já adivinhou as letras 'J' e 'A', o progresso exibido deve ser: J A _ A.
        Permitir que o jogador insira uma letra por tentativa.
                Notificar o jogador se a letra adivinhada está ou não na palavra.
                Contagem de Tentativas

        O jogador deve ter um número limitado de tentativas para adivinhar a palavra (por exemplo, 6 tentativas).
                Exibir a quantidade de tentativas restantes após cada jogada.
        Condições de Vitória e Derrota

        O jogador vence se adivinhar todas as letras da palavra antes de esgotar as tentativas.
                O jogador perde se as tentativas chegarem a zero antes de adivinhar toda a palavra.
        Mensagens Finais

        Ao final do jogo, exibir uma mensagem indicando se o jogador venceu ou perdeu.
                Caso o jogador perca, exibir a palavra secreta.
         */

        // definição da palavra secreta aleatoriamento dentro de uma lista (array) e suas caracteristicas

        String[] carros = {"DELREI", "FUSCA", "GOL", "PALIO", "CORSA", "VOYAGE", "SANTANA", "ECOSPORT"};
        Random random = new Random();
        int indiceAleatorio = random.nextInt(carros.length);

        String palavraSecreta = carros[indiceAleatorio];
        int qtdeLetras = palavraSecreta.length();
        //int qtdeTentativas = qtdeLetras * 2;
        int qtdeTentativas = (qtdeLetras * 2); // eu alterei a quantidade de tentativas para o dobro da qtde de letras da palavra secreta
        //System.out.println("palavra secreta: " + palavraSecreta);

        System.out.println("# - VAMOS BRINCAR DE FORÇA - #");
        System.out.println("---------------------------------------");
        System.out.println("Dicas:");
        System.out.println("A Palavra a ser descoberta é uma Carro com " + qtdeLetras + " letras: ");
        System.out.println("Voce tera " + qtdeTentativas + " , tentativas para achar a palavra secreta ");
        System.out.println("---------------------------------------");
        String formLetras = "";
        String[] carroselecionada = new String[qtdeLetras];
        String[] letraAcertada = new String[qtdeLetras];

        for(int i = 0; i < qtdeLetras; i++ ){
            formLetras = formLetras + "_ " +" ";
            carroselecionada[i] = palavraSecreta.substring(i, i + 1);
            letraAcertada[i] = " "; // eu tive que colocar espaço nesse array por causa da passagem de parametro no metodo, que dava erro de null
        }

        int nAcertou = 0;
        forcaDesenho(0);
        System.out.println("Formato da palavra secreta: " + formLetras );

        int tentativas = 1;
        String letra = "";
        int acertou = 0;
        int acertou1 = 0;
        int tentativastotal = 0;

        Scanner sc = new Scanner(System.in);

        while(tentativas < qtdeTentativas) { // esse laço é para sair das tentativas pela qtde ou pelo acerto total da palavra

            System.out.println("---------------------------------------");

            System.out.println("Digite a letra da tentativa " + tentativas + "º, e voce ainda terá " + (qtdeTentativas - tentativas) + " tentativas!");
            letra = sc.nextLine().toUpperCase();

            for (int j = 0; j < qtdeLetras; j++) {

                if (letra.equals(carroselecionada[j])) {
                    letraAcertada[j] = letra;
                    acertou++;
                    acertou1++;
                    tentativas--;
                }

            }
            if(acertou1 > 0){
                System.out.println("voce acertou " + acertou1 + " letra(s)");
            } else{
                System.out.println("Essa letra NÃO existe na palavra secreta");
                nAcertou++;
            }
            acertou1 = 0;

            tentativas++;
            tentativastotal = tentativas;
            if(acertou == qtdeLetras){
                tentativas = qtdeTentativas;}
            else {forcaDesenho(nAcertou);
                if (nAcertou == 7) { tentativas = qtdeTentativas;}
            }
            montaLetras(letraAcertada, qtdeLetras); // metodo para montar a forca, a medida que as letras são digitadas
        }

        System.out.println("---------------------------------------");
        System.out.println("numero de letras acertadas: " + acertou + ", Com " + (tentativastotal - 1) + " tentativas");
        if (acertou == qtdeLetras) {
            System.out.println("Parabéns, voce conseguiu descobrir a palavra secreta: ");
        }  else {
            System.out.println("Voce NÃO conseguiu descobrir a palavra secreta que é: " + palavraSecreta);
        }

    }



    public static void montaLetras(String[] letraAcertada, int qtdeLetras ) {


        String montaLetras = "";

        for(int i =0; i < qtdeLetras; i++) {
            String vazio = " ";

            if(letraAcertada[i].equals(vazio))
                montaLetras = montaLetras + "_" + " ";
            else{
                montaLetras = montaLetras + letraAcertada[i] + " ";
            }

        }
        System.out.println("Forca preenchida: " + montaLetras);

    }

    public static void forcaDesenho(int nAcertou){

        System.out.println(" ________");
        System.out.println( "/       |" );

        if(nAcertou == 0){
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "|" );
        }

        if(nAcertou == 1  ){
            System.out.println( "|       0" );
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "|" );
        }


        if(nAcertou == 2  ){
            System.out.println( "|       0" );
            System.out.println( "|       |" );
            System.out.println( "|" );
            System.out.println( "|" );
        }


        if(nAcertou == 3  ){
            System.out.println( "|       0" );
            System.out.println( "|      /|" );
            System.out.println( "|" );
            System.out.println( "|" );
        }


        if(nAcertou == 4  ){
            System.out.println( "|       0" );
            System.out.println( "|      /|\\" );
            System.out.println( "|" );
            System.out.println( "|" );
        }


        if(nAcertou == 5  ){
            System.out.println( "|       0" );
            System.out.println( "|      /|\\" );
            System.out.println( "|       |" );
            System.out.println( "|" );
        }


        if(nAcertou == 6  ){
            System.out.println( "|       0" );
            System.out.println( "|      /|\\" );
            System.out.println( "|       |" );
            System.out.println( "|      /" );
        }


        if (nAcertou == 7) {
            System.out.println("|       0");
            System.out.println("|      /|\\");
            System.out.println("|       |");
            System.out.println("|      / \\");
        }
    }
}
