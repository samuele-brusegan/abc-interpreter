package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("resource")
public class FileManage {
    public static int getFileLength(String file_name) throws Exception {
        BufferedReader br = initFile(file_name);

        int numberOfRows = 0;
        while (br.readLine() != null) {
            numberOfRows++;
        }
        return numberOfRows;
    }
    public static BufferedReader initFile(String file_name) throws Exception {

        Path path = Paths.get("src/"+file_name);
        Path absolutePath = path.toAbsolutePath();

        File file = new File(String.valueOf(absolutePath));

        return new BufferedReader(new FileReader(file));
    }
}
