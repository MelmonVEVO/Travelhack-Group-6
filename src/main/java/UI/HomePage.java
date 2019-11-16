package UI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route("Home")
public class HomePage extends VerticalLayout implements HasUrlParameter<String> {

    String user;

    public HomePage() {

        VerticalLayout homePageLayoutRight = new VerticalLayout();
        VerticalLayout homePageLayoutLeft = new VerticalLayout();
        VerticalLayout finderAndSchedulerLayout = new VerticalLayout();
        VerticalLayout rewardAndAccountLayout = new VerticalLayout();

        VerticalLayout finderLayout = new VerticalLayout();
        VerticalLayout schedulerLayout = new VerticalLayout();
        VerticalLayout rewardLayout = new VerticalLayout();
        VerticalLayout accountLayout = new VerticalLayout();

        HorizontalLayout otherPages = new HorizontalLayout();
        HorizontalLayout homePage = new HorizontalLayout();

        Button logoutButton = new Button("Log out", new Icon(VaadinIcon.EXIT_O));
        Button activityFinderButton = new Button("Activity Finder");
        Button schedulerButton = new Button("Scheduler");
        Button rewardButton = new Button("Reward");
        Button accountButton = new Button("Account");

        H1 nameOfApp = new H1("FollowMe!");

        // set up for components
        logoutButton.addClickListener(e -> {
            logoutButton.getUI().ifPresent(ui -> {
                ui.navigate("");
            });
        });
        activityFinderButton.addClickListener(e -> {
            activityFinderButton.getUI().ifPresent(ui -> {
                ui.navigate("Activity/" + user);
            });
        });
        activityFinderButton.setSizeFull();
        schedulerButton.addClickListener(e -> {
            schedulerButton.getUI().ifPresent(ui -> {
                ui.navigate("Scheduler/" + user);
            });
        });
        schedulerButton.setSizeFull();
        rewardButton.addClickListener(e -> {
            rewardButton.getUI().ifPresent(ui -> {
                ui.navigate("Reward/" + user);
            });
        });
        rewardButton.setSizeFull();
        accountButton.addClickListener(e -> {
            accountButton.getUI().ifPresent(ui -> {
                ui.navigate("Account/" + user);
            });
        });
        accountButton.setSizeFull();

        // set up layouts
        homePageLayoutLeft.add(nameOfApp);
        homePageLayoutLeft.setAlignItems(Alignment.START);
        homePageLayoutRight.setWidthFull();
        homePageLayoutRight.setHeight("100px");

        homePageLayoutRight.add(logoutButton);
        homePageLayoutRight.setAlignItems(Alignment.END);
        homePageLayoutRight.setWidthFull();
        homePageLayoutRight.setHeight("100px");

        homePage.add(homePageLayoutLeft, homePageLayoutRight);
        homePage.setWidthFull();
        homePage.setHeight("100px");

        finderLayout.add(activityFinderButton);
        finderLayout.setAlignItems(Alignment.CENTER);
        finderLayout.setSizeFull();

        schedulerLayout.add(schedulerButton);
        schedulerLayout.setAlignItems(Alignment.CENTER);
        schedulerLayout.setSizeFull();

        finderAndSchedulerLayout.add(finderLayout, schedulerLayout);
        finderAndSchedulerLayout.setAlignItems(Alignment.CENTER);
        finderAndSchedulerLayout.setHeightFull();

        rewardLayout.add(rewardButton);
        rewardLayout.setAlignItems(Alignment.CENTER);
        rewardLayout.setSizeFull();

        accountLayout.add(accountButton);
        accountLayout.setAlignItems(Alignment.CENTER);
        accountLayout.setSizeFull();

        rewardAndAccountLayout.add(rewardLayout, accountLayout);
        rewardAndAccountLayout.setHeightFull();
        rewardAndAccountLayout.setAlignItems(Alignment.CENTER);

        otherPages.add(finderAndSchedulerLayout, rewardAndAccountLayout);
        otherPages.setAlignItems(Alignment.CENTER);
        otherPages.setSizeFull();

        add(homePage, otherPages);
    }

    @Override
    public void setParameter(BeforeEvent e, String name) {

        this.user = name;
    }
}
