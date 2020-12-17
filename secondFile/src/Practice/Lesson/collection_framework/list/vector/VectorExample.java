package Practice.Lesson.collection_framework.list.vector;

import java.util.List;
import java.util.Vector;

public class VectorExample {

	/*
	 * Vector의 내용은  Arraylist와 같다. 하지만 Vector는 synchronized(동기화)가 되어있어 
	 * 멀티스레드 환경에서 객체를 저장하거나 리턴할 때, 중복을 발생시키지 않는다.
//	 * Arraylist는 단일스레드환경에서 유리하면, Vector는 멀티스레드에서 정확하다.
	 */
	public static void main(String[] args) {
		List<Board> list = new Vector<Board>();
		
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		list.remove(2);
		list.remove(3);
		
		for (int i = 0; i < list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer );
		}
	}

		}

class Board {
	String subject;
	String content;
	String writer;
	
	public Board(String subject, String content, String writer	) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}
}
