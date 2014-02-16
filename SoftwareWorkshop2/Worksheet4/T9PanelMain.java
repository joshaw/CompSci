import javax.swing.*;

class T9PanelMain {
    public static void main(String[] args) {

        T9Model model = new T9Model();
        T9View view = new T9View(model);
        T9Controller controller = new T9Controller(model, view);

        view.setVisible(true);
    }
}
