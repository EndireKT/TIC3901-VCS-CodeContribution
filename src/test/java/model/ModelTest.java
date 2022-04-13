package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    Model model = Model.getInstance();

    @Test
    void isValidCommitAndAuthorListValidOutput() {
        model.setPathCodeAndRemoteGitUrl("D:\\My Files\\School Documents\\Repository\\TIC3901_TestRepo");
        Boolean actualOutput = model.isValidCommitAndAuthorList();
        assertEquals(true, actualOutput);
    }
}