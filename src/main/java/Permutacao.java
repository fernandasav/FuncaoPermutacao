// #DESAFIO: Escrever uma função que retorne e/ou exiba todas as permutações simples
// Observações: Número de permutações simples é igual ao fatorial da quantidade de itens do array.
// Entradas: Array = [1,2,3]; Array = [11,22,33,44]

import java.util.*;

public class Permutacao {

    public static void main(String[] args) {

        // Lista de números totais e sem repetição
        // Altere os números de numbersForPermutation para testar
        List<Integer> numbersForPermutation = Arrays.asList(1,2,3);
        Set<List<Integer>> permutationWithoutRepetion = new HashSet<>();

        System.out.println("-------------------------------------------------------------");
        System.out.println("Bem-vindo(a), a calculadora de permutações simples da B3!!!");
        System.out.println("-------------------------------------------------------------");

        System.out.println("Vamos agora validar se os números inseridos são válidos para esta operação: ");
        System.out.println(" ");

        // Validando se os números do array estão entre 0 <= array [i] <= 100
        boolean invalidNumbersFound = false;
        for (Integer numbers : numbersForPermutation) {
            if (numbers >= 0 && numbers <= 100) {
                continue;
            } else if (numbers >= 101) {
                invalidNumbersFound = true;
            }
        }

        if (invalidNumbersFound) {
            System.err.println("Infelizmente encontramos um erro: Tente digitar apenas números entre 0 e 100 em sua lista.");
            return;
        }

        // Validando se a quantidade de indices é maior que 10
        if (numbersForPermutation.size() > 10) {
            System.err.println("Infelizmente encontramos um erro: A lista deve ter no máximo 10 elementos.");
            return;
        }

        System.out.println("Parabéns! Os números que você escolheu e a quantidade estão corretas.");
        System.out.println(" ");
        System.out.println("Vamos agora conferir o resultado da sua permutação: ");
        System.out.println(" ");

        //Calculando o valor de permutações simples
        int f = 1;
        int c = numbersForPermutation.size();
        while (c >= 1) {
            f *= c;
            c--;
        }

        // Realizando as permutações
        //Permutações com index maior que 6 demoram mais para executar
        for (int i = 0; i < f * numbersForPermutation.size() * 2; i++) {
            Collections.shuffle(numbersForPermutation);
            permutationWithoutRepetion.add(new ArrayList<Integer>(numbersForPermutation));
        }

        //Imprimindo as permutações
        System.out.println(permutationWithoutRepetion.toString());
        System.out.println(" ");


        // Impressão extra para verificar se as permutações impressas são iguais a f
        if (permutationWithoutRepetion.size() - f == 0) {
            System.out.println("As " + f + " permutações possíveis da sua lista foram exibidas com sucesso! ");
        } else {
            System.out.println("Infelizmente o programa não exibiu todas as combinações possíveis. Tente novamente ou contate nosso suporte. ");
        }

        System.out.println(" ");
        System.out.println("Obrigado por escolher a calculadora de permutações simples da B3!");
    }
}


