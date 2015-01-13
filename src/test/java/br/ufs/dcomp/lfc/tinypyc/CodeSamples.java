package br.ufs.dcomp.lfc.tinypyc;

import java.util.*;

import br.ufs.dcomp.lfc.tinypyc.Token.TokenType;

/**
 * Created by Gabriel Araujo on 13/01/2015.
 */
public class CodeSamples {

    public static final String DATA_01 = "\n"
            + "if x   :\n"
            + "    pass";

    public static final List<Token> TOKENS_01;

    static {
        List<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token(TokenType.IF));
        tokens.add(new Token(TokenType.ID, "x"));
        tokens.add(new Token(TokenType.COLON));
        tokens.add(new Token(TokenType.BEGIN));
        tokens.add(new Token(TokenType.PASS));
        tokens.add(new Token(TokenType.EOF));
        TOKENS_01 = Collections.unmodifiableList(tokens);
    }

    public static final String DATA_02 = "\n"
            + "if      test:\n"
            + "    pass\n"
            + "else:\n"
            + "    fail\n"
            + "   ";

    public static final List<Token> TOKENS_02;

    static {
        List<Token> tokens = new ArrayList<Token>();
        tokens.add(new Token(TokenType.IF));
        tokens.add(new Token(TokenType.ID, "test"));
        tokens.add(new Token(TokenType.COLON));
        tokens.add(new Token(TokenType.BEGIN));
        tokens.add(new Token(TokenType.PASS));
        tokens.add(new Token(TokenType.END));
        tokens.add(new Token(TokenType.ELSE));
        tokens.add(new Token(TokenType.COLON));
        tokens.add(new Token(TokenType.BEGIN));
        tokens.add(new Token(TokenType.ID, "fail"));
        tokens.add(new Token(TokenType.EOF));
        TOKENS_02 = Collections.unmodifiableList(tokens);
    }
}
