package UI;

import DB.dbstart;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;

@Route("Reward")
public class RewardPage extends VerticalLayout implements HasUrlParameter<String> {

    private dbstart db = new dbstart();
    private String user;

    private Label expLabel = new Label("Exp: ");
    private Label exp;

    private Grid<Reward> grid;

    private Button backButton = new Button("Back");
    private Button redeemButton;

    private VerticalLayout rewardLayout = new VerticalLayout();
    private HorizontalLayout redeemLayout = new HorizontalLayout();
    private HorizontalLayout expLayout = new HorizontalLayout();

    public RewardPage() {

        Label selected = new Label("");

        Reward reward1 = new Reward("Free coffee", 10);
        Reward reward2 = new Reward("10£ off next flight", 100);

        List<Reward> rewardList = Arrays.asList(reward1, reward2);

        grid = new Grid<>(Reward.class);
        grid.setItems(rewardList);
        grid.setWidthFull();
        grid.setHeight("400px");
        grid.asSingleSelect().addValueChangeListener(e -> {
            selected.setText(Integer.toString((e.getValue().pointsWorth)));
        });



        redeemButton = new Button("Redeem", e -> {

            Dialog dialog = new Dialog();

            if (Integer.parseInt(exp.getText()) - Integer.parseInt(selected.getText()) >= 0) {
                db.setExp(user, Integer.parseInt(exp.getText()) - Integer.parseInt(selected.getText()));
                exp.setText(db.getExp(user));
                dialog.add(new Label("Your purchase has gone through! You should receive an email shortly"));
            } else {
                dialog.add(new Label("Not enough exp"));
            }
            dialog.open();
        });

        backButton.addClickListener(e -> {
            backButton.getUI().ifPresent(ui -> {
                ui.navigate("Home/" + user);
            });
        });
    }

    public void initialise() {

        exp = new Label(db.getExp(user));
        exp.setSizeFull();

        expLayout.add(expLabel, exp);
        expLayout.setSizeFull();

        redeemLayout.add(grid, redeemButton);
        redeemLayout.setSizeFull();
        redeemLayout.setAlignItems(Alignment.CENTER);

        rewardLayout.add(expLayout, redeemLayout, backButton);
        rewardLayout.setSizeFull();
        rewardLayout.setAlignItems(Alignment.CENTER);

        add(rewardLayout);
    }

    @Override
    public void setParameter(BeforeEvent e, String name) {

        this.user = name;
        initialise();
    }
}
