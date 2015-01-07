/* 
* A primeira seção da especificação vai até o primeiro %%,
* e consiste de código Java que é copiado ao pé da letra
*
*/

package br.ufs.dcomp.lfc.tinypyc.generated;

import br.ufs.dcomp.lfc.tinypyc.Token;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Stack;

%%

/*
* A segunda seção vai até o próximo %%, e são diversos parâmetros
* de configuração, além de código Java copiado para o corpo da
* classe do analisador léxico
*
*/

// nome da classe do analisador
%class Scanner
// classe deve ser pública
%public
// guarde número da linha em yyline
%line
// nome do método que vai fornecer um token
%function token
// Classe usada para tokens. Veja o arquivo Token.java.
%type Token

// O código Java entre %{ e %} é copiado pro corpo da classe
// do analisador léxico.
%{ 
	// Níveis de identação
	Stack<Integer> levels;

	public Scanner() { }

	/**
     * Inicializa a pilha de identação.
     */
	private void initIndentStack(){
	  levels = new Stack<Integer>();
	  levels.push(0);
	}

	public void input(String input) {
      initIndentStack();
      // inicializa entrada pro analisador
	  yyreset(new StringReader(input));
	}
	
	public List<Token> getTokens() throws IOException {
	  List<Token> tokens = new ArrayList<Token>();
	  Token tok = token();
	  while(tok.tipo != Token.EOF) {
	    tokens.add(tok);
	    tok = token();
	  }
	  tokens.add(tok);
	  return tokens;
	}

%}

%init{
  initIndentStack();
%init}

%%

/*
* A última seção contém as regras léxicas, cada regra é um
* par com uma expressão regular e um trecho de código Java
* entre { e }.
*
*/

// Identação, o programa deve começar com um \n extra
// só linhas que não estão em branco são levadas em conta
\n[ ]*.               { 
                        yypushback(1); // volta o primeiro char do prox. token
 						int level = yytext().length()-1;
						// nível corrente
 						int curr = levels.peek();
 						if(level > curr) {
 						  // indenta
 						  levels.push(level);
 						  return new Token(Token.BEGIN, yyline);
 						} else if(level < curr) {
						  levels.pop();
						  // vai rodar o scanner de novo nessa
						  // indentação, para ver se precisa
						  // gerar mais de um }
						  yypushback(level+1);
						  return new Token(Token.END, yyline);
 						} else {
 						  // mesmo nível, não faz nada!
 						}
                      } 

// Exemplo de regra
[bB][oO][oO][lL]      { return new Token(Token.BOOL, yyline); }

// Identificadores e numerais devem ser retornados com
// return new Token(Token.ID, yytext(), yyline)
// e return new Token(Token.NUM, yytext(), yyline)

// Regra para EOF
<<EOF>>      { return new Token(Token.EOF, yyline, yycolumn); }

// Erros léxicos 
.            { throw new RuntimeException("Erro léxico, linha: " +
               (yyline+1) + ", char: " + yytext()); }

