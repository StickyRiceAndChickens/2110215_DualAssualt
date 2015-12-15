package render;

public class ReadyException extends Exception {
	private int errorType;
	private int id;
	
	public ReadyException(int errorType,int  id){
		/* fill code */
		this.errorType=errorType;
		this.id=id;
		this.getMessage();
	}
	
	@Override
	public String getMessage(){
		if(errorType==0){
			return "Player"+id+"No Name input";
		}else if(errorType==1){
			return "Player"+id+"Wrong record format,use letter only";
		}else if(errorType==2){
			return "Player"+id+"Name is too long";
		}else if(errorType==3){
			return "Player"+id+ "not ready yet";
		}
		return null;
		/* fill code */
	}
}
