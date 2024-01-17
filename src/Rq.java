
public class Rq {

	private int getid;
	
	public Rq(String cmd) {
		String[] a = cmd.split("\\?"); // 삭제, id=1
		String[] ab = a[1].split("="); // id, 1

		try {
			setGetid(Integer.parseInt(ab[1]));
		} catch (Exception e) {
			System.out.println("정수값을 입력해주세요.");
		}
	}

	public int getGetid() {
		return getid;
	}

	public void setGetid(int getid) {
		this.getid = getid;
	}
}
