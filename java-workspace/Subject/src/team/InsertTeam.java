package team;

public class InsertTeam {

	public static void main(String[] args) {
		TeamDAO dao = new TeamDAO();
		
		dao.insertTeam();
		System.out.println("팀 저장이 완료되었습니다.");
	}
}
