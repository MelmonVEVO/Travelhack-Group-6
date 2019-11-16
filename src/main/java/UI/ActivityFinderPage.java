package UI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("Activity")
public class ActivityFinderPage extends VerticalLayout implements HasUrlParameter<String> {

    String user;

    public ActivityFinderPage() {

        HorizontalLayout activityLayout = new HorizontalLayout();
        VerticalLayout mapLayout = new VerticalLayout();
        VerticalLayout cityFinderLayout = new VerticalLayout();

        Image image = new Image("https://highthemes.com/wp-content/uploads/2017/12/google-map.png", "DummyImage");
        image.setVisible(false);

        ComboBox<String> comboBox = new ComboBox<>("Cities");
        comboBox.setItems("London", "Bath");

        Button goButton = new Button("Go");
        goButton.addClickListener(e -> {
            if (comboBox.getValue().equals("London")) {
                image.setVisible(true);
            }
        });
        Button backButton = new Button("Back");
        backButton.addClickListener(e -> {
            backButton.getUI().ifPresent(ui -> {
                ui.navigate("Home/" + user);
            });
        });

        cityFinderLayout.add(comboBox, goButton, backButton);
        cityFinderLayout.setSizeFull();
        cityFinderLayout.setAlignItems(Alignment.CENTER);

        mapLayout.add(image);
        mapLayout.setSizeFull();
        mapLayout.setAlignItems(Alignment.CENTER);

        activityLayout.add(cityFinderLayout, mapLayout);
        activityLayout.setSizeFull();
        activityLayout.setAlignItems(Alignment.CENTER);

        add(activityLayout);
    }

    @Override
    public void setParameter(BeforeEvent e, String name) {

        this.user = name;
    }
}
