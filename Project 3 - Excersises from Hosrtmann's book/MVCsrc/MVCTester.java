import java.util.ArrayList;


public class MVCTester {
//standard tester
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		//create model from list
		Model model = new Model(list);
		//create frame from model
		MVCFrame mvcFrame = new MVCFrame(model);
		//attaching frame to model
		model.attach(mvcFrame);
	}
}