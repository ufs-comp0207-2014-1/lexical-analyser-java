package br.ufs.dcomp.lfc.tinypyc;

/**
 * Created by Gabriel Araujo on 12/01/2015.
 */

import br.ufs.dcomp.lfc.tinypyc.generated.Scanner;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ScannerTest {

    private Scanner scanner = new Scanner();

    @Test
    public void testSimples() {

        List<Token> tokensList;

        try {
            scanner.input(CodeSamples.DATA_01);
            tokensList = scanner.getTokens();
            Assert.assertEquals(CodeSamples.TOKENS_01, tokensList);

            scanner.input(CodeSamples.DATA_02);
            tokensList = scanner.getTokens();
            Assert.assertEquals(CodeSamples.TOKENS_02, tokensList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
