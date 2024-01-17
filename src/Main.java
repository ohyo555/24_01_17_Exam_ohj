import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("== 명언 앱 실행 ==");

		List<Article> articles = new ArrayList<>();

		int lastid = 0;

		while (true) {

			boolean isfindId = false;

			System.out.print("명령어 ) ");
			String cmd = sc.nextLine().trim();
			
			int id = lastid + 1;

			if (cmd.equals("등록")) {
				System.out.print("명언: ");
				String content = sc.nextLine();
				System.out.print("작가: ");
				String author = sc.nextLine();

				String regDate = Util.getNowDate();
				String updateDate = Util.getNowDate();

				Article article = new Article(id, content, author, regDate, updateDate);

				articles.add(article);

				lastid++;
			} else if (cmd.equals("목록")) {

				if (articles.size() == 0) {
					System.out.println("등록된 명언이 없습니다.");
					continue;
				}

				System.out.println(" 번호  /   작가   /   명언   ");
				System.out.println("=========================");

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf("%3d   /%5s     /%5s     \n", article.getId(), article.getAuthor(),
							article.getContent());
				}

			} else if (cmd.startsWith("삭제")) {

				Rq rq = new Rq(cmd);

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					if (article.getId() == rq.getGetid()) {
						isfindId = true;
						articles.remove(article);
						System.out.printf("%d번 명언이 삭제되었습니다.\n", rq.getGetid());
					}
				}

				if (isfindId == false && rq.x == 0) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n",rq.getGetid());
					continue;
				}

			} else if (cmd.startsWith("수정")) {

				Rq rq = new Rq(cmd);

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					if (article.getId() == rq.getGetid()) {
						isfindId = true;

						System.out.printf("명언(기존): %s\n", article.getContent());
						System.out.printf("작가(기존): %s\n", article.getAuthor());
						System.out.printf("명언: ");
						String content = sc.nextLine();
						System.out.printf("작가: ");
						String author = sc.nextLine();
						String updateDate = Util.getNowDate();

						article.setContent(content);
						article.setAuthor(author);
						article.setUpdateDate(updateDate);

						System.out.printf("%d번 명언이 수정되었습니다.\n", rq.getGetid());
					}
				}

				if (isfindId == false && rq.x == 0) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n",rq.getGetid());
					continue;
				}

			} else if (cmd.startsWith("상세보기")) {

				Rq rq = new Rq(cmd);

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					if (article.getId() == rq.getGetid()) {
						isfindId = true;
						System.out.printf("번호: %d\n",article.getId());
						System.out.printf("날짜: %s\n",article.getRegDate());
						System.out.printf("작가: %s\n",article.getAuthor());
						System.out.printf("명언: %s\n",article.getContent());

					}
				}

				if (isfindId == false && rq.x == 0) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n",rq.getGetid());
					continue;
				}

			} else {
				System.out.println("명령어를 확인해주세요");
				continue;
			}
		}

	}

}
