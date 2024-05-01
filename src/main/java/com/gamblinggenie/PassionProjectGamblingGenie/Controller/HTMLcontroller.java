package com.gamblinggenie.PassionProjectGamblingGenie.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HTMLcontroller {
        @GetMapping("/login")
        public String loginScreen() {
            return "login";
        }

        @GetMapping("/homepage")
        public String home() {
            return "homePage";
        }

        @GetMapping("/profile")
        public String profilePage() {
            return "profile";
        }

        @GetMapping("/history")
        public String historyPage() {
            return "history";
        }

        @GetMapping("/selectedgame")
        public String selectedGamePage() {
            return "selectedGame";
        }
}
