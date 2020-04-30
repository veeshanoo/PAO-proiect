package pao.IO;

import pao.entities.IdGenerator;

import java.io.*;

public class IdGeneratorIO {
    static private final IdGeneratorIO instance = new IdGeneratorIO();

    private IdGeneratorIO() {
    }

    public static IdGeneratorIO getInstance() {
        return instance;
    }

    public IdGenerator loadData(String fileName) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();

        return new IdGenerator(Integer.parseInt(line));
    }

    public void updateData(String fileName, IdGenerator idGenerator) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        writer.write(formatted(idGenerator));
        writer.close();
    }

    private String formatted(IdGenerator idGenerator) {
        return idGenerator.getId() + "\n";
    }
}
