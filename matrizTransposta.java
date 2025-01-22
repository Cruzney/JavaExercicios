public class matrizTransposta {
/*
    Construa a matriz transposta de uma matriz 3x3. A transposta é obtida ao trocar as linhas pelas colunas.
    Exemplo 1
    Entrada:
            1 2 3
            4 5 6
            7 8 9
    Saida:
            1 4 7
            2 5 8
            3 6 9
    */
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        int[][] matrizTransposta = new int[3][3];
        int i, j;

        // Preenchendo a matriz
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[0][2] = 3;
        matriz[1][0] = 4;
        matriz[1][1] = 5;
        matriz[1][2] = 6;
        matriz[2][0] = 7;
        matriz[2][1] = 8;
        matriz[2][2] = 9;

        // Calculando a matriz transposta
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                matrizTransposta[i][j] = matriz[j][i];
            }
        }

        // Exibindo a matriz transposta
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(matrizTransposta[i][j] + " ");
            }
            System.out.println();
        }
    }

}
