package com.example.projeto2_web.Controllers.Home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/Home")
    public String showCalendar(Model model) {
        List<List<String>> weeks = generateCalendarData(); // Generate the calendar data

        model.addAttribute("weeks", weeks); // Add the calendar data to the model

        return "/Home/Home"; // Return the template name (calendar.html)
    }

    private List<List<String>> generateCalendarData() {
        List<List<String>> weeks = new ArrayList<>();

        // Get the current date and find the first day of the month
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);

        // Find the day of the week for the first day of the month
        DayOfWeek firstDayOfWeek = firstDayOfMonth.getDayOfWeek();
        int daysToAdd = DayOfWeek.SUNDAY.getValue() - firstDayOfWeek.getValue();

        // Adjust the first day of the month based on the day of the week
        LocalDate startDay = firstDayOfMonth.plusDays(daysToAdd);

        // Generate the calendar data for the entire month
        LocalDate tempDate = startDay;
        while (tempDate.getMonthValue() == currentDate.getMonthValue() || tempDate.getDayOfMonth() == 1) {
            List<String> week = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                if (tempDate.getMonthValue() == currentDate.getMonthValue()) {
                    week.add(String.valueOf(tempDate.getDayOfMonth()));
                } else {
                    week.add(""); // Add an empty string for days outside the current month
                }
                tempDate = tempDate.plusDays(1);
            }
            weeks.add(week);
        }
        return weeks;
    }
}
