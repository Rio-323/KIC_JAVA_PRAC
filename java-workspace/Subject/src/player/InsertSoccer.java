package player;

public class InsertSoccer {

	public static void main(String[] args) {
		SoccerDAO dao = new SoccerDAO();
		dao.insertPlayer();
		System.out.println("선수 저장이 완료되었습니다.");
	}

}
