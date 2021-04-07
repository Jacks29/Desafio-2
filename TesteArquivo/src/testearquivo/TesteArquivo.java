/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testearquivo;

import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;


/**
 *
 * @author alves
 */
public class TesteArquivo {

    /**
     * @param args the command line arguments
     */
        //private static final char abre_parentese = '(';
        public static Scanner arq;
        public static void main(String[] args) throws IOException {
            ArrayList <String> teste= new ArrayList();
            try {
              arq=new Scanner(new FileReader("prog.txt"));
              
              while (arq.hasNextLine()){
                teste.add(arq.nextLine());
              }
            } catch (IOException e) {
                System.err.printf("Erro na abertura do arquivo: %s.\n",
                  e.getMessage());
            }
            FileWriter arquivo = new FileWriter("prog-check.txt");
            PrintWriter gravaArq = new PrintWriter(arquivo);
            int tamanho= teste.size();
            Stack<Character> listaDeChars = new Stack<Character>();
            for(int u=0;u<tamanho;u++){
                //listaDeChars.clear();
                boolean invalido=false;
                String teste2 =teste.get(u).toString();                              
                System.out.println(teste2);
                char abre_cha = '{';
                char fecha_cha = '}';
                char abre_col = '[';
                char fecha_col = ']';
                char abre_par = '(';
                char fecha_par = ')';
                
                for (int d = 0; d < teste2.length(); d++){
                if (teste2.charAt(d) == abre_col) {
                    listaDeChars.push(abre_col);
                } else if (teste2.charAt(d) == abre_cha){
                    listaDeChars.push(abre_cha);
                }else if (teste2.charAt(d) == abre_par){
                    listaDeChars.push(abre_par);
                } else if (teste2.charAt(d) == fecha_col){
                    if (listaDeChars.isEmpty()){
                        invalido = true;
                        break;
                    }
                    if (listaDeChars.pop() != abre_col){
                        invalido = true;
                        break;
                    }
                }else if (teste2.charAt(d) == fecha_cha){
                    if (listaDeChars.isEmpty()){
                        invalido = true;
                        break;
                    }
                    if (listaDeChars.pop() != abre_cha){
                        invalido = true;
                        break;
                    }              
                } else if (teste2.charAt(d) == fecha_par){
                    if (listaDeChars.isEmpty()){
                        invalido = true;
                        break;
                    }
                    if (listaDeChars.pop() != abre_par){
                        invalido = true;
                        break;
                    }
                }    
            }           
            listaDeChars.clear();
            if (invalido == true){
                teste2 = teste2 + " - Inválido";
            }
            else{
                 teste2 = teste2 + " - OK";
            }
            try{
                gravaArq.println(teste2);
                //System.out.println(teste2);
            }
            catch(Exception e){
                System.err.printf("Erro no salvamento do arquivo: %s.\n",
                  e.getMessage());
            }

        }
        arquivo.close();
    }

}