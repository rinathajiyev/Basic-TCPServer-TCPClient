package fileutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtility {
    public static void writeBytes(String fileName, byte[] data) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        fileOutputStream.write(data);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public static byte[] readBytes(String fileName) throws IOException {
        File file = new File(fileName);

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] bytesArray = new byte[(int) file.length()];
            fileInputStream.read(bytesArray);
            return bytesArray;
        }
    }
}
