package mvc;
import mvc.controllers.*;
import mvc.models.*;
import mvc.views.*;
public class Main {
	public static void main(String[] args) {
		Model model = new Model(0, 0);
		View view = new View();
		Controller controller = new Controller(model,view);
		controller.control();
	}
}
