
public class Rq {

	private int getid;
	int x = 0;
	
	public Rq(String cmd) {
		
		try {
			String[] a = cmd.split("\\?"); // 삭제, id=1
			String[] ab = a[1].split("="); // id, 1
			
			getid = Integer.parseInt(ab[1]);
			
		} catch (Exception e) {
			System.out.println("명령어를 확인해주세요.");
			x = 1;
		}
	}

	public int getGetid() {
		return getid;
	}

	public void setGetid(int getid) {
		this.getid = getid;
	}
}
