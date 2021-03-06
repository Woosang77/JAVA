package Planner;

public class planElement implements Comparable<planElement>{

	private int month;
	private int date;
	private int time;
	private String text;

	planElement() {}	//기본생성자
	planElement(int month, int date, int time, String text) {
		this.month = month;
		this.date= date;
		this.time = time;
		this.text = text;
	}
	
	@Override
	public int compareTo(planElement other) {
		
		if(month != other.month) {
			if(month > other.month) {return 1;}
			else if (month < other.month) {return -1;}
		}
		if(date != other.date) {
			if(date > other.date) {return 1;}
			else if (date< other.date) {return -1;}
		}
		if(time != other.time) {
			if(time > other.time) {return 1;}
			else if (time < other.time) {return -1;}
		}
		return text.compareTo(other.text);
	}
	
	//getter , setter
	void setMonth(int month	) {this.month = month;}
	int getMonth() {return month;}
	
	void setDate(int date) {this.date= date;}
	int getDate() {return date;}
	
	void setTime(int time) {this.time= time;}
	int getTime() {return time;}
	
	void setText(String text) {this.text= text;}
	String getText() {return text;}
	
}
