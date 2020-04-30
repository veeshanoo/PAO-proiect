package pao.entities;

public final class IdGenerator {
    private Integer id;

    public IdGenerator(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer genId() {
        Integer cpy = this.id;
        this.id++;
        return cpy;
    }
}
