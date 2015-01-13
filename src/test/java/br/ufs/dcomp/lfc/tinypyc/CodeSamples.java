package br.ufs.dcomp.lfc.tinypyc;

import java.util.*;

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
        tokens.add(new Token(Token.IF));
        tokens.add(new Token(Token.ID, "x"));
        tokens.add(new Token(Token.COLON));
        tokens.add(new Token(Token.BEGIN));
        tokens.add(new Token(Token.PASS));
        tokens.add(new Token(Token.EOF));
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
        tokens.add(new Token(Token.IF));
        tokens.add(new Token(Token.ID, "test"));
        tokens.add(new Token(Token.COLON));
        tokens.add(new Token(Token.BEGIN));
        tokens.add(new Token(Token.PASS));
        tokens.add(new Token(Token.END));
        tokens.add(new Token(Token.ELSE));
        tokens.add(new Token(Token.COLON));
        tokens.add(new Token(Token.BEGIN));
        tokens.add(new Token(Token.ID, "fail"));
        tokens.add(new Token(Token.EOF));
        TOKENS_02 = Collections.unmodifiableList(tokens);
    }
}
