import java.util.ArrayList;

public class DataEx01 {

	public static void main(String[] args) {
		Student s1 = new Student("1", "홍길동", "010-111-1111", "20", "서울시");
		Student s2 = new Student("2", "박문수", "010-222-2222", "22", "경기도");
		Student s3 = new Student("3", "임꺽정", "010-333-3333", "25", "강원도");
		
		ArrayList<Student> datas = new ArrayList<>();
		datas.add(s1);
		datas.add(s2);
		datas.add(s3);
		
		for(Student s : datas) {
			System.out.println(s.getSeq());
			System.out.println(s.getName());
			System.out.println(s.getPhone());
			System.out.println(s.getAge());
			System.out.println(s.getRegion());
			System.out.println();
		}
	}

}
