package exception;

public class SeckillException extends RuntimeException {

	private long seckillId;
	
	
	public SeckillException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SeckillException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}