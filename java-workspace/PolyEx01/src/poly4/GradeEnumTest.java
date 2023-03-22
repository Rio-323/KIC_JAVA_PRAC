package poly4;
enum Grade {
	SALES, PART_TIME_JOB, NORMAL
}

public class GradeEnumTest {

	public static void main(String[] args) {
		Grade grade = Grade.SALES;
		System.out.println(grade);
		System.out.println(grade instanceof Enum);
		System.out.println(grade instanceof Object);
	}

}
