package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ViewUiTest {

    ViewUi viewUi = new ViewUi();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void showListOfCommitsAndAuthor() {
        ArrayList<String> commitList = new ArrayList<>(Arrays.asList("111","222","333"));
        ArrayList<String> authorList = new ArrayList<>(Arrays.asList("a1","a2","a3"));
        viewUi.showListOfCommitsAndAuthor(commitList, authorList);
        String actualOutput = "";
        //assertEquals(actualOutput,outputStreamCaptor.toString().trim());
    }
}