package poly4;

public class MainEx01 {

	public static void main(String[] args) {
		Vehicle v = new DieselSUV();
		v.addFuel();
		
		v = new ElectricCar();
		v.addFuel();

	}

}
