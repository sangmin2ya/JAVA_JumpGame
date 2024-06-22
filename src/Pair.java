import java.util.Comparator;

public class Pair{
	public String name;
	public Integer score;
	public Pair(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        if (p1.score == p2.score) {
            return p1.name.compareTo(p2.name);
        } else {
            return (p2.score - p1.score);
        }
    }
}