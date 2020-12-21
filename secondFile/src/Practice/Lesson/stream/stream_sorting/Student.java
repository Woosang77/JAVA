package Practice.Lesson.stream.stream_sorting;

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.score = score;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	
	@Override
	public int compareTo(Student o) {
		return Integer.compare(score, o.score);
	}
}
