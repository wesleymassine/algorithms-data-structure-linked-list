package com.list.linked;
/**
 * Obter Localizar e Excluir tudo O (1) 
 * Problema
 * 
 * Você terá que criar uma lista telefônica onde as seguintes operações sejam
 * suportadas. 1. OBTER: Fornecerá um número que não é atribuído a ninguém 2.
 * VERIFICAR: Dado um número, ele dirá se foi atribuído a alguém ou não 3.
 * LIBERAR: Reciclará ou liberará um número Soluções normais Podemos implementar
 * uma matriz de números, então GET terá O (n), porque precisamos encontrar na
 * lista os números disponíveis CHECK terá O (1) RELEASE terá O (1)
 * 
 * Se implementarmos por meio de uma lista vinculada de números disponíveis,
 * então GET terá O (1), pois podemos retornar a cabeça CHECK terá O (n), pois
 * teremos que iterar através da lista vinculada RELEASE terá O (1), pois
 * podemos apenas adicioná-lo no cabeçalho. 
 * 
 * Solução
 * 
 * Podemos ter todas as 3 operações em O (1) por uma combinação de array e lista
 * vinculada. cada número é representado por um nó duplamente vinculado em sua
 * localização de matriz correspondente e uma lista duplamente vinculada
 * percorre os nós na matriz. GET terá O (1), pois podemos remover o cabeçalho
 * da lista vinculada no tempo O (1). CHECK terá O (1), pois podemos ir
 * diretamente para o índice do array, já que todo índice contém o nó do número
 * correspondente. Então, podemos verificar a disponibilidade no nó. RELEASE
 * terá O (1), pois podemos ir para o nó diretamente pelo índice do array e
 * então adicioná-lo à lista duplamente vinculada. Podemos adicionar o nó à
 * cabeça no tempo O (1).
 * 
 * Nesse arranjo, também podemos verificar a disponibilidade de um determinado
 * número e obter esse número específico. Por exemplo, se alguém quiser um
 * número bonito ou da sorte do diretório.
 * 
 * @author skopo
 *
 */
public class TelephoneDirectory {

	public static void main(String[] args) {
		Directory directory = new Directory(5);
		int number1 = directory.getAvailableNumber();
		System.out.println(number1);
		int number2 = directory.getAvailableNumber();
		  System.out.println(number2);
		  System.out.println(directory.isAvailable(3));
		  int number3 = directory.getAvailableNumber();
		  System.out.println(number3);
		  System.out.println(directory.isAvailable(3));
		  int number4 = directory.getAvailableNumber();
		  System.out.println(directory.isAvailable(3));
		  System.out.println(number4);
		  int number5 = directory.getAvailableNumber();
		  System.out.println(number5);
		  int number6 = directory.getAvailableNumber();
		  System.out.println(number6);
		  int number7 = directory.getAvailableNumber();
		  System.out.println(number7);
		  directory.release(3);
		  System.out.println(directory.isAvailable(3));
		  int number8 = directory.getAvailableNumber();
		  System.out.println(number8);
		  System.out.println(directory.isAvailable(3));
	}
}
