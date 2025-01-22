public class Matriz_Imp_Diagonais {

    public static void main(String[] args) {

        int[][] matriz = new int[3][3];

        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[0][2] = 3;
        matriz[1][0] = 4;
        matriz[1][1] = 5;
        matriz[1][2] = 6;
        matriz[2][0] = 7;
        matriz[2][1] = 8;
        matriz[2][2] = 9;

        System.out.println("Elemento [0] [0] " + matriz[0][0]);
// Exiba apenas os elementos da diagonal principal de uma matriz quadrada.
        for (int linha = 0; linha < matriz.length; linha++) {
            System.out.println ( "Linha : " + linha + "  = "  );
            System.out.println(matriz[linha][linha] + " , Valor da Diagonal Principal");
        }
        System.out.println (  ); // Pular linha
        // Exiba apenas os elementos da diagonal secundária de uma matriz quadrada.
        for (int linha = 0; linha < matriz.length; linha++) {
            System.out.println ( "Linha : " + linha + "  = "  );
            System.out.println(matriz[linha][matriz.length - 1 - linha] + " , Valor da Diagonal Secundária");
        }

        System.out.println (  ); // Pular linha

        // Exibir segundo elemento das linha
        for (int linha = 0; linha < matriz.length; linha++) {
            System.out.println ( "Linha : " + linha + "  = "  );
            System.out.println(matriz[linha][1] + " , Valor da Segunda Coluna");
        }

        for (int linha = 0; linha < matriz.length; linha++) {
            System.out.println();
            System.out.println("Vou percorrer a linha: " + linha);
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.print(matriz[linha][coluna]);
            }
        }

    }

}