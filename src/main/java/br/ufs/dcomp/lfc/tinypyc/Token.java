package br.ufs.dcomp.lfc.tinypyc;

public class Token {

    public TokenType tipo;
    public String texto;
    public int lin;

    public Token(TokenType tipo, String texto, int lin, int col) {
        this.tipo = tipo;
        this.texto = texto;
        this.lin = lin + 1;
    }

    public Token(TokenType tipo, String texto) {
        this(tipo, texto, -1, -1);
    }

    public Token(TokenType tipo, int lin) {
        this(tipo, lin, -1);
    }

    public Token(TokenType tipo) {
        this(tipo, -1, -1);
    }

    public Token(TokenType tipo, int lin, int col) {
        this.tipo = tipo;
        this.texto = tipo.toString();
        this.lin = lin + 1;
    }

    @Override
    public boolean equals(Object other) {
        Token tok = (Token) other;
        if (tok.tipo == TokenType.ID)
            return tipo == tok.tipo && texto.equals(tok.texto);
        else
            return tipo == tok.tipo;
    }

    @Override
    public int hashCode() {
        return tipo.hashCode();
    }

    @Override
    public String toString() {
        String prefix = !texto.equals(tipo.toString()) ? String.format("%s, ", tipo.toString()) : "";
        return String.format("( %s%s, %d)", prefix, texto, lin);
    }

    public enum TokenType {
        EOF("<<EOF>>"),

        // Identificadores e numerais
        ID("id"),
        NUM("num"),

        // Palavras reservadas
        WRITE("write"),
        READ("read"),
        IF("if"),
        ELSE("else"),
        ELIF("elif"),
        BEGIN("begin"),
        END("end"),
        WHILE("while"),
        INT("int"),
        BOOL("bool"),
        VOID("void"),
        AND("and"),
        OR("or"),
        NOT("not"),
        PASS("pass"),
        TRUE("true"),
        FALSE("false"),

        // Operadores
        ATRIB(":="),

        // Delimitadores
        COLON(":");

        private String value;

        TokenType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return this.getValue();
        }
    }
}
