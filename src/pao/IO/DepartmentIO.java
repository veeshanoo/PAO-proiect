package pao.IO;

import pao.entities.Department;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class DepartmentIO {
    static private final DepartmentIO instance = new DepartmentIO();

    private DepartmentIO() {
    }

    public static DepartmentIO getInstance() {
        return instance;
    }

    public TreeMap<Integer, Department> loadData(String fileName) throws IOException {
        TreeMap<Integer, Department> departments = new TreeMap<>();

        BufferedReader reader;
        reader = new BufferedReader(new FileReader(fileName));

        String line = reader.readLine();
        while (line != null) {
            if (line.equals("")) {
                line = reader.readLine();
                continue;
            }

            String[] splitData = line.split(",");
            Department department = new Department(
                    Integer.parseInt(splitData[0]),
                    splitData[1]
            );
            departments.put(department.getDepartmentId(), department);
            line = reader.readLine();
        }

        return departments;
    }

    public void updateData(String fileName, TreeMap<Integer, Department> departments) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        for (Map.Entry<Integer, Department> entry : departments.entrySet()) {
            writer.write(formatted(entry.getValue()));
        }
        writer.close();
    }

    private String formatted(Department department) {
        return department.getDepartmentId() + "," +
                department.getName() + "\n";
    }
}
