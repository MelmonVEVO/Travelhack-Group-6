package UI;

import AM.Node;
import AM.Schedule;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.List;

@Route("Scheduler")
public class SchedulerPage extends VerticalLayout implements HasUrlParameter<String> {

    String user;

    public SchedulerPage () {

        Button backButton = new Button("Back");

        Schedule scTest = new Schedule("16/11/2019");
        scTest.GenerateSchedule(5, 8);

        List<Node> activityList = Arrays.asList(scTest.getNodes());

        Grid grid = new Grid<>(Node.class);
        grid.setItems(activityList);
        grid.setColumns("time","name","exp");
        grid.setWidthFull();
        grid.setHeight("400px");

        backButton.addClickListener(e -> {
            backButton.getUI().ifPresent(ui -> {
                ui.navigate("Home/" + user);
            });
        });

        add(grid, backButton);
    }

    @Override
    public void setParameter(BeforeEvent e, String name) {

        this.user = name;
    }
}
