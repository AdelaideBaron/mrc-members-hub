package com.codeaddi.row_your_boat.view.adminOnly;

import com.codeaddi.row_your_boat.controller.services.view.ViewService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class WeeklyPlanController {

  @Autowired ViewService viewService;

  @GetMapping("/make-weekly-plan")
  public String makeNewSessions(Model model) {
    List<String> sessionDates = viewService.getAllPastSessionsDates();

    model.addAttribute("list", sessionDates);
    return "adminOnly/make-new-sessions";
  }

  @PostMapping("/session-availability")
  public String showSessionAvailability(@RequestParam("date") String date, Model model) {
    List<String> availableRowers = viewService.getAllAvailableRowersForDate(date);
    model.addAttribute("availabilities", availableRowers);
    return "adminOnly/session-availability";
  }
}
