package pack2;



public class MainEx01 {

	public static void main(String[] args) {
		Go g = new Go();
		Come c = new Come();
		
		// thread 아님
		// g.run();
		// c.run();
		
		// thread 실행
		g.start();
		c.start();
		
		

	}

}
