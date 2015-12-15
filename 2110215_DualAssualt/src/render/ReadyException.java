package render;

public class ReadyException extends Exception {
	private int errorType;
	
	public ReadyException(int errorType){
		/* fill code */
		this.errorType=errorType;
		this.getMessage();
	}
	
	@Override
	public String getMessage(){
		if(errorType==0){
			return "No record score";
		}else if(errorType==1){
			return "Wrong record format,use A-Z,a-z only";
		}else if(errorType==3){
			return "Name is too long";
		}else if(errorType==4){
			return ""
		}
		return null;
		/* fill code */
	}
}
