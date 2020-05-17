package pao.audit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Auditor {
    private final String fileName;

    public Auditor(String fileName) {
        this.fileName = fileName;
    }

    public void logAction(String actionName) {
        // we check if log file is exists, if not, we create one
        try {
            File file = new File(this.fileName);
            if (!file.exists()) {
                boolean flag = file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, true));
                writer.write("Action,Thread,Timestamp\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName, true));
            writer.write(actionName + "," + Thread.currentThread().getName() + "," + this.generateTimeStamp() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateTimeStamp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
