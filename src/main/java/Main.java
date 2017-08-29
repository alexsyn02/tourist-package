import controller.Controller;
import model.Model;
import model.entity.*;
import controller.utils.TouristVoucherUtils;
import view.View;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model, view);

        controller.run();
    }
}
