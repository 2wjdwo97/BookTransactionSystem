package bookTransactionSystem;

public class MVCmain {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ModelHandler theModel = new ModelHandler();
		View theView = new View();
		Controller theController = new Controller(theView, theModel);
	}
}