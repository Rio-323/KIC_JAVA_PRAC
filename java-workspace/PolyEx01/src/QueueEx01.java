import java.util.LinkedList;
import java.util.Queue;

public class QueueEx01 {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("박문수");
		queue.offer("임꺽정");
		
		System.out.println(queue);
		
		System.out.println(queue.poll());
		System.out.println(queue);
		
		System.out.println(queue.poll());
		System.out.println(queue);
	}

}
