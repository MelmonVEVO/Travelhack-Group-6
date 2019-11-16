package UI;

import DB.dbstart;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Create")
public class CreateAccountPage extends VerticalLayout {
    public CreateAccountPage() {

        dbstart db = new dbstart();

        VerticalLayout newUserLayout = new VerticalLayout();
        VerticalLayout newUserForm = new VerticalLayout();

        H1 title = new H1("Create Account");
        TextField usernameField = new TextField("email");
        PasswordField passwordField = new PasswordField("Password");
        PasswordField repeat = new PasswordField("Repeat your password");
        Button createButton = new Button("Create");

        // set up for components
        createButton.addClickShortcut(Key.ENTER);
        createButton.getStyle().set("background-color","blue");
        createButton.getStyle().set("color", "white");

        // set up layouts
        newUserForm.add(usernameField,passwordField, repeat,createButton);
        newUserForm.setAlignItems(Alignment.CENTER);

        newUserLayout.add(title, newUserForm);
        newUserLayout.setAlignItems(Alignment.CENTER);
        newUserLayout.setHeightFull();

        // check username and password when triggered
        createButton.addClickListener(e -> {

            // for now it's only a dialog window after it will also change the route

            Dialog dialog = new Dialog();
            Label label = new Label();
            // set color to red for errors
            label.getStyle().set("color", "red");

            if (usernameField.isEmpty() || passwordField.isEmpty()) {
                label.setText("Some fields were left blank!");
                dialog.add(label);
                dialog.open();
            } else if (passwordField.getValue().equals(repeat.getValue())) {
                createButton.getUI().ifPresent(ui -> {
                    db.createUser(usernameField.getValue(), passwordField.getValue());
                    ui.navigate("Home/" + usernameField.getValue());
                });
            } else {
                label.setText("The input password doesn't match the repeated password, try again!");
                dialog.add(label);
                passwordField.clear();
                repeat.clear();
                dialog.open();
            }
        });

        add(newUserLayout);
    }
}
