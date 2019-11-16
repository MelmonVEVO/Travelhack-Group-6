package UI;

import DB.dbstart;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("Account")
public class AccountPage extends VerticalLayout implements HasUrlParameter<String> {

    private dbstart db = new dbstart();
    private String user;

    private Image randomProfilePicture;

    private Label currentEmail;
    private Label currentPoints;

    private Button changePasswordButton;
    private Button backButton;

    private VerticalLayout accountLayout;

    public AccountPage () {

        randomProfilePicture = new Image("https://secondchancetinyhomes.org/wp-content/uploads/2016/09/empty-profile.png","dummy image");
        changePasswordButton = new Button("Reset password", e -> {
            Dialog dialog = new Dialog();
            dialog.add(new Label("You should receive an email shortly"));
            dialog.open();
        });

        backButton = new Button("Back");
        backButton.addClickListener(e -> {
            backButton.getUI().ifPresent(ui -> {
                ui.navigate("Home/" + user);
            });
        });
    }

    public void initialise() {
        accountLayout = new VerticalLayout();

        currentEmail = new Label("Username: " + user);
        currentPoints = new Label("Exp: " + db.getExp(user));

        accountLayout.add(randomProfilePicture, currentEmail, currentPoints, changePasswordButton, backButton);
        accountLayout.setSizeFull();
        accountLayout.setAlignItems(Alignment.CENTER);

        add(accountLayout);
    }

    @Override
    public void setParameter(BeforeEvent e, String name) {

        this.user = name;
        initialise();
    }
}
