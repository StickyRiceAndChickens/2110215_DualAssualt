package render;

public class NameInputException extends Exception {
	private int errorType;
	private int id;
	
	public NameInputException(int errorType,int  id){
		/* fill code */
		this.errorType=errorType;
		this.id=id;
		this.getMessage();
	}
	
	@Override
	public String getMessage(){
		if(errorType==0){
			return "Player"+id+"No Name input";
		}else if(errorType==2){
			return "Player"+id+"Name is too long";
		}
		return null;
		/* fill code */
	}
}
