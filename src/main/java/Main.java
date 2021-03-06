import controller.Controller;
import model.Model;
import view.ViewUi;


public class Main {
    public static void main(String[] args) {
        Model model = Model.getInstance();
        ViewUi viewUi = new ViewUi();
        Controller controller = new Controller(model, viewUi);

        controller.execute();
    }
}

