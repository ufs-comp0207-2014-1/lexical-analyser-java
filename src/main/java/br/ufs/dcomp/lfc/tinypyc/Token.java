package br.ufs.dcomp.lfc.tinypyc;

public class Token {

    

    public final static int EOF = 0;
    // Palavras reservadas
    public static final int WRITE = 3;
    public static final int READ = 4;
    public static final int IF = 5;
    public static final int ELSE = 6;
    public static final int ELIF = 7;
    public static final int BEGIN = 8;
    public static final int END = 9;
    public static final int WHILE = 10;
    public static final int INT = 11;
    public static final int BOOL = 12;
    public static final int VOID = 13;
    public final static int AND = 14;
    public final static int OR = 15;
    public static final int NOT = 16;
    public static final int PASS = 17;
    public static final int TRUE = 18;
    public static final int FALSE = 19;
    // Operadores
    public static final int ATRIB = 20;
    // Delimitadores
    public static final int COLON = 21;
    // Identificadores e numerais
    public final static int ID = 1;
    public final static int NUM = 2;
    public final static String[] nomes = new String[]{
            "<<EOF>>", "id", "num", "write", "read", "if", "else",
            "elif", "begin", "end", "while", "int", "bool", "void",
            "and", "or", "not", "pass", "true", "false", ":=", ":"
    };
    public int tipo;
    public String texto;
    public int lin;

    public Token(int tipo, String texto, int lin, int col) {
        this.tipo = tipo;
        this.texto = texto;
        this.lin = lin + 1;
    }

    public Token(int tipo, String texto) {
        this(tipo, texto, -1, -1);
    }

    public Token(int tipo, int lin) {
        this(tipo, lin, -1);
    }

    public Token(int tipo) {
        this(tipo, -1, -1);
    }

    public Token(int tipo, int lin, int col) {
        this.tipo = tipo;
        this.texto = tipo < nomes.length ? nomes[tipo] :
                Character.toString((char) tipo);
        this.lin = lin + 1;
    }

    @Override
    public boolean equals(Object other) {
        Token tok = (Token) other;
        if (tok.tipo == Token.ID)
            return tipo == tok.tipo && texto.equals(tok.texto);
        else
            return tipo == tok.tipo;
    }

    @Override
    public int hashCode() {
        return tipo;
    }

    @Override
    public String toString() {
        String tok = "," + lin + ")";
        if (tipo < nomes.length && !texto.equals(nomes[tipo]))
            return "(" + nomes[tipo] + "," + texto + tok;
        else
            return "(" + texto + tok;
    }
}
