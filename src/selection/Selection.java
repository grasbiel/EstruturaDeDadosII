package selection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import manipulacao.ManipuladorDeDados;

public class Selection {
	
	private List <Integer> conteudo = new ArrayList <Integer> ();
	private Integer [] conjuntoElementos;
	
	public Selection (int quantidade, String nomeArquivo) throws IOException {	
		
		ManipuladorDeDados.gerarNumerosAleatorios(quantidade, nomeArquivo); //Criando os numeros aleatorios 
		//e colocando em um arquivo TXT
		conteudo = ManipuladorDeDados.leitorDeDados(nomeArquivo); // Faz a leitura dos números gerados
		conjuntoElementos = conteudo.toArray(new Integer [conteudo.size()]); //transforma a Lista em ARray
		
	}	
	
	public int getTamanho () {
		return this.conjuntoElementos.length;
	}
	
	public void exibe () {
		System.out.println ("Conteudo:");
		for (int ele : conjuntoElementos) {
			System.out.println (ele);
		}
	}
	
	public Integer [] ordenacaoSelection () throws IOException {
				
			for (int indice=0; indice < conjuntoElementos.length; ++indice) {
				int indMenor = indice;
				
				for (int indSeg = indice+1; indSeg < conjuntoElementos.length; ++indSeg) {
					if (conjuntoElementos[indSeg] < conjuntoElementos[indMenor]) { //Compara se o elemento Seguinte 
						// é menor que o VALOR TIDO COMO MENOR
						indMenor = indSeg;
					} 	// fim do if
				}	//fim do for interior
				
				int auxiliar = conjuntoElementos[indice];
				conjuntoElementos[indice] = conjuntoElementos[indMenor];
				conjuntoElementos[indMenor] = auxiliar;
			}		
		return conjuntoElementos;
			
	} //FIM SELECTION SORT	
}
