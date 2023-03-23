package pack1;

public class OuterMain {

	public static void main(String[] args) {
		Outer outer = new Outer();
		
		// System.out.println(outer.x1); - private
		System.out.println(outer.x2);
		System.out.println();
		
		Outer.Inner inner = outer.new Inner();
		// System.out.println(inner.y1); - private
		System.out.println(inner.y2);
		System.out.println();
		
		inner.viewInner();
	}

}
