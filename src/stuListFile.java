
public class stuListFile {

    private final int id;
    private final String name;
    private final int kScore;
    private final int eScore;
    private final int mScore;

    public stuListFile(int id, String name, int kScore, int eScore, int mScore) {
        this.id = id;
        this.name = name;
        this.kScore = kScore;
        this.eScore = eScore;
        this.mScore = mScore;
    }
    public int get_id() {
        return this.id;
    }
    public String get_name() {
        return this.name;
    }
    public int get_kScore() {
        return this.kScore;
    }
    public int get_eScore() {
        return this.eScore;
    }
    public int get_mScore() {
        return this.mScore;
    }
}
