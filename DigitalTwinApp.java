package Application;

import javax.swing.*;
import java.awt.*;

public class DigitalTwinApp extends JFrame {

    JTextField name, course;
    JTextField sleep, meals, water, study, exercise;
    JTextField totalClasses, attendedClasses;

    JLabel result;

    public DigitalTwinApp() {

        // Window
        setTitle("My Digital Twin");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2, 10, 10));
        panel.setBackground(Color.WHITE);

        // Title
        JLabel title = new JLabel("MY DIGITAL TWIN");
        title.setFont(new Font("Arial", Font.BOLD, 25));

        panel.add(title);
        panel.add(new JLabel(""));

        // Personal Details

        panel.add(new JLabel("Name:"));
        name = new JTextField();
        panel.add(name);

        panel.add(new JLabel("Course:"));
        course = new JTextField();
        panel.add(course);

        // Lifestyle Details

        panel.add(new JLabel("Sleep (hours):"));
        sleep = new JTextField();
        panel.add(sleep);

        panel.add(new JLabel("Meals per day:"));
        meals = new JTextField();
        panel.add(meals);

        panel.add(new JLabel("Water (glasses):"));
        water = new JTextField();
        panel.add(water);

        panel.add(new JLabel("Study (hours):"));
        study = new JTextField();
        panel.add(study);

        panel.add(new JLabel("Exercise (hours):"));
        exercise = new JTextField();
        panel.add(exercise);

        // Attendance

        panel.add(new JLabel("Total Classes:"));
        totalClasses = new JTextField();
        panel.add(totalClasses);

        panel.add(new JLabel("Classes Attended:"));
        attendedClasses = new JTextField();
        panel.add(attendedClasses);

        // Buttons

        JButton calculate = new JButton("Analyze");
        JButton reset = new JButton("Reset");

        panel.add(calculate);
        panel.add(reset);

        // Result

        result = new JLabel(
                "<html><center>" +
                "Enter your details and click Analyze!" +
                "</center></html>"
        );

        result.setFont(new Font("Arial", Font.BOLD, 16));

        // Add panels to window

        add(panel, BorderLayout.CENTER);
        add(result, BorderLayout.SOUTH);

        // ---------------- ANALYZE BUTTON ----------------

        calculate.addActionListener(e -> {

            String studentName = name.getText();
            String studentCourse = course.getText();

            int sleepHours =
                    Integer.parseInt(sleep.getText());

            int mealCount =
                    Integer.parseInt(meals.getText());

            int waterCount =
                    Integer.parseInt(water.getText());

            int studyHours =
                    Integer.parseInt(study.getText());

            int exerciseHours =
                    Integer.parseInt(exercise.getText());

            int total =
                    Integer.parseInt(totalClasses.getText());

            int attended =
                    Integer.parseInt(attendedClasses.getText());

            // Attendance Calculation

            double attendance =
                    ((double) attended / total) * 100;

            // Bunk Calculator

            int bunk = 0;

            while (
                    ((double) attended /
                    (total + bunk + 1)) * 100 >= 75
            ) {

                bunk++;
            }

            // Sleep

            String sleepResult;

            if (sleepHours >= 7) {
                sleepResult = "Good";
            } else {
                sleepResult = "Sleep more";
            }

            // Food

            String foodResult;

            if (mealCount >= 3) {
                foodResult = "Good";
            } else {
                foodResult = "Eat properly";
            }

            // Water

            String waterResult;

            if (waterCount >= 6) {
                waterResult = "Good";
            } else {
                waterResult = "Drink more water";
            }

            // Study

            String studyResult;

            if (studyHours >= 3) {
                studyResult = "Excellent";
            } else {
                studyResult = "Study more";
            }

            // Exercise

            String exerciseResult;

            if (exerciseHours >= 1) {
                exerciseResult = "Good";
            } else {
                exerciseResult = "Exercise more";
            }

            // Overall Status

            String status;

            if (attendance >= 75 &&
                sleepHours >= 7 &&
                mealCount >= 3 &&
                waterCount >= 6 &&
                studyHours >= 3 &&
                exerciseHours >= 1) {

                status = "EXCELLENT";

            } else if (attendance >= 75) {

                status = "BALANCED";

            } else {

                status = "NEEDS IMPROVEMENT";
            }

            // Display Result

            result.setText(
                    "<html><center>" +

                    "<b>YOUR DIGITAL TWIN</b>" +

                    "<br><br>" +

                    "Name: " + studentName +

                    "<br>" +

                    "Course: " + studentCourse +

                    "<br><br>" +

                    "Sleep: " + sleepResult +

                    "<br>" +

                    "Food: " + foodResult +

                    "<br>" +

                    "Water: " + waterResult +

                    "<br>" +

                    "Study: " + studyResult +

                    "<br>" +

                    "Exercise: " + exerciseResult +

                    "<br><br>" +

                    "Attendance: " +
                    String.format("%.2f", attendance) +
                    "%" +

                    "<br>" +

                    "Bunkable Classes: " +
                    bunk +

                    "<br><br>" +

                    "Overall: " +
                    status +

                    "</center></html>"
            );
        });

        // ---------------- RESET BUTTON ----------------

        reset.addActionListener(e -> {

            name.setText("");
            course.setText("");

            sleep.setText("");
            meals.setText("");
            water.setText("");
            study.setText("");
            exercise.setText("");

            totalClasses.setText("");
            attendedClasses.setText("");

            result.setText(
                    "Enter your details and click Analyze!"
            );
        });

        // Show Window

        setVisible(true);
    }

    // ---------------- MAIN METHOD ----------------

    public static void main(String[] args) {

        new DigitalTwinApp();
    }
}
