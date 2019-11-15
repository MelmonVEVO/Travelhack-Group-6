package UI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("Home")
public class HomePage extends VerticalLayout {
    public HomePage() {

        VerticalLayout homePageLayout = new VerticalLayout();
        VerticalLayout finderAndSchedulerLayout = new VerticalLayout();
        VerticalLayout rewardAndAccountLayout = new VerticalLayout();

        VerticalLayout finderLayout = new VerticalLayout();
        VerticalLayout schedulerLayout = new VerticalLayout();
        VerticalLayout rewardLayout = new VerticalLayout();
        VerticalLayout accountLayout = new VerticalLayout();



        HorizontalLayout otherPages = new HorizontalLayout();

        Button logoutButton = new Button("Log out", new Icon(VaadinIcon.EXIT_O));
        Button activityFinderButton = new Button("Activity Finder");
        Button schedulerButton = new Button("Scheduler");
        Button rewardButton = new Button("Reward");
        Button accountButton = new Button("Account");

        // set up for components
        logoutButton.addClickListener(e -> {
            logoutButton.getUI().ifPresent(ui -> {
                ui.navigate("");
            });
        });
        activityFinderButton.addClickListener(e -> {
            activityFinderButton.getUI().ifPresent(ui -> {
                ui.navigate("ActivityPage");
            });
        });
        activityFinderButton.setSizeFull();
        schedulerButton.addClickListener(e -> {
            schedulerButton.getUI().ifPresent(ui -> {
                ui.navigate("SchedulerPage");
            });
        });
        schedulerButton.setSizeFull();
        rewardButton.addClickListener(e -> {
            rewardButton.getUI().ifPresent(ui -> {
                ui.navigate("RewardPage");
            });
        });
        rewardButton.setSizeFull();
        accountButton.addClickListener(e -> {
            accountButton.getUI().ifPresent(ui -> {
                ui.navigate("AccountPage");
            });
        });
        accountButton.setSizeFull();

        // set up layouts
        homePageLayout.add(logoutButton);
        homePageLayout.setAlignItems(Alignment.END);
        homePageLayout.setWidthFull();
        homePageLayout.setHeight("100px");

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

        add(homePageLayout, otherPages);
    }
}
