package model.projectFiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import model.commandprompt.CmdPrompt;

public class PathEncoder {

    /**
     * Takes in a local path and parse it
     * into a string where path is recognizable by the code
     * e.g. return String will be " C:\\user1\\folder\\file "
     *
     * @param localPath
     * @return String representing the local path
     */
    @org.jetbrains.annotations.Nullable
    public static String getLocalPathInCode(String localPath) {
        String[] pathParts = localPath.split("\\\\");
        String pathCode = pathParts[0];
        for (int i = 1; i < pathParts.length; i++) {
            pathCode = pathCode + "\\\\" + pathParts[i];
        }
        return pathCode;
    }

    /**
     * Get the Remote Repo URL/Path of the project
     *
     * @param pathCode
     * @return
     */
    @org.jetbrains.annotations.Nullable
    public static String getGitRemoteProjectUrl(String pathCode) {
        try {
            Process process = CmdPrompt.getGitRemoteProjectUrl(pathCode);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String remoteUrl = reader.readLine();

            return remoteUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
