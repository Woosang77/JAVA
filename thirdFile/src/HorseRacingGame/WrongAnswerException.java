package HorseRacingGame;

public class WrongAnswerException extends Exception{
	public WrongAnswerException() {}
	public WrongAnswerException(String message) {
		super(message);
	}
}
