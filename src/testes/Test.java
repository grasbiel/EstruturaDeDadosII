package testes;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import manipulacao.ManipuladorDeDados;
import selection.Selection;

public class Test {
	
	public static void main (String[] args) throws IOException {
		int TOTALREPETICOES = 3;
		int TOTALAMOSTRAS = 3;
		
		long [][] armazenarDados = new long [TOTALREPETICOES][TOTALAMOSTRAS];	
		
		String resultado = "Amostras.txt";
		File pasta = new File (resultado); 
		pasta.createNewFile();
		PrintWriter pw = new PrintWriter (resultado);
		
		for (int repeticoes=0; repeticoes<TOTALREPETICOES; repeticoes++) { //INICIO PRIMEIRO FOR
			
			int quantidadeElementos = 10000; //QUANTIDADE DE ELEMENTOS QUE O ARQUIVO TERÁ INICIALMENTE
				
			for (int amostras=0;  amostras<TOTALAMOSTRAS; amostras++) { //INICIO SEGUNDO FOR
				
				String nomeArquivo = "Dados" + amostras + ".txt"; //Nome do Arquivo que será armazenado os dados
					
				Selection conjunto = new Selection (quantidadeElementos,nomeArquivo);
					
				long tempoInicial =  System.currentTimeMillis();// PEGA O TEMPO INICIAL
								
				Integer [] vetorOrdenado = conjunto.ordenacaoSelection(); //OBTENDO O VALOR ORDENADO
					
				long tempoFinal =  (System.currentTimeMillis() - tempoInicial); //PEGA O TEMPO FINAL
							
				
				armazenarDados[repeticoes][amostras] = tempoFinal;
				pw.println (quantidadeElementos+";" + tempoFinal);
				
				String nomeArqOrdenado = "Resultado" + amostras + ".txt"; // CRIAÇÃO DO RESULTADO
					
				ManipuladorDeDados.escreverResultadoEmArquivo(vetorOrdenado.length, 
						nomeArqOrdenado, vetorOrdenado); // ESCREVENDO O RESULTADO DA ORDENAÇÃO NO ARQUIVO
					
				quantidadeElementos += 10000; 
			} // FIM FOR 2			
		} // FIM FOR 1	
			
			{
				int teste =10000;
				for (int i =0; i<TOTALAMOSTRAS; i++) {
					System.out.print(teste + "\t");
					teste +=10000;
				}
			}
			
			System.out.println ("");
			
			for (int i =0; i<TOTALREPETICOES; i++) {
				for (int j=0; j<TOTALAMOSTRAS; j++) {
					System.out.print (armazenarDados[i][j] + " \t");
				}
				System.out.println("");
			}
			
			pw.close();
	} // FIM MAIN
		
} // FIM classe TESTE

