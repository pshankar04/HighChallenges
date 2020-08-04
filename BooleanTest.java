
public class BooleanTest {

//	public static final Boolean TRUE = Boolean.TRUE;
//	public static final Boolean FALSE = Boolean.FALSE;


	public static void main(String[] args) {

		Boolean isTrue = new Boolean(checkTruth(false));
		if(isTrue == false){
			System.out.println("True That");
		}else{
			System.out.println("False That");
		}

	}

	public static boolean checkTruth(boolean item){

		if(item == true){
			return true;
		}else{
			return false;
		}
	}
}
