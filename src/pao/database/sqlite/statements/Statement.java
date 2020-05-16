package pao.database.sqlite.statements;

public interface Statement<T> {
    String readAllStatement();
    String readStatement(T filter);
    String insertStatement(T element);
    String updateStatement(T filter, T update);
    String deleteStatement(T filter);
}
