package render;

@SuppressWarnings("serial")
public class ReadyException extends Exception {
	private int id;
	
	public ReadyException(int  id){
		/* fill code */
		this.id=id;
		this.getMessage();
	}
	
	@Override
	public String getMessage() {
		return "Player" + id + "not ready yet";
	}
}
