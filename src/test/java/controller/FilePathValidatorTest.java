package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePathValidatorTest {

    @Test
    void isValidFilePathCorrectPath() {
        String filePath = "D:\\My Files\\School Documents\\Repository\\TIC3901_TestRepo";
        Boolean actualOutput = FilePathValidator.isValidFilePath(filePath);
        assertEquals(true, actualOutput);
    }

    @Test
    void isValidFilePathNoPath() {
        String filePath = "";
        Boolean actualOutput = FilePathValidator.isValidFilePath(filePath);
        assertEquals(false, actualOutput);
    }

    @Test
    void isValidFilePathIsFileNotPath() {
        String filePath = "D:\\My Files\\School Documents\\Repository\\TIC3901_TestRepo\\fileA.txt";
        Boolean actualOutput = FilePathValidator.isValidFilePath(filePath);
        assertEquals(false, actualOutput);
    }
}