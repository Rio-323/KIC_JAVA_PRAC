package pack1;

public class MainEx01 {

	public static void main(String[] args) {
		Go g = new Go();
		Come c = new Come();
		
		// 순차 처리
		g.run();
		c.run();
	}

}
