package 프로그래머스;

public class 서울에서_김서방_찾기 {
	
	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		System.out.println(solution(seoul));
	}
	
	public static String solution(String[] seoul) {
		String answer = "";
        int i = 0;
        for(i = 0; i < seoul.length; i++){
            if(seoul[i].equals("Kim"))
                break;
        }
        answer = "김서방은 " + i + "에 있다";
        return answer;
	}
}
