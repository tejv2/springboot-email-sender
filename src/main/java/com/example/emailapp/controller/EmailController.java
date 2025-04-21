
// EmailController.java
package com.example.emailapp.controller;

import com.example.emailapp.model.Email;
import com.example.emailapp.repository.EmailRepository;
import com.example.emailapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailRepository emailRepository;

    @GetMapping("/form")
    public ModelAndView showForm() {
        return new ModelAndView("email_form");
    }

    @PostMapping("/send")
    public ModelAndView sendEmail(
            @RequestParam("from") String from,
            @RequestParam("appPassword") String appPassword,
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            @RequestParam("attachments") MultipartFile[] attachments
    ) {
        emailService.sendEmail(from, appPassword, to, subject, message, attachments);

        StringBuilder fileNames = new StringBuilder();
        for (MultipartFile file : attachments) {
            if (!file.isEmpty()) {
                fileNames.append(file.getOriginalFilename()).append(", ");
            }
        }
// Save to DB with filenames
        emailRepository.save(new Email(from, to, subject, message, fileNames.toString()));
        ModelAndView modelAndView = new ModelAndView("email_form");
        modelAndView.addObject("successMessage", "✅ Email sent successfully!");
        return modelAndView;

    }

    @GetMapping("/history")
    public ModelAndView showHistory() {
        List<Email> emails = emailRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("email_history");
        modelAndView.addObject("emails", emails);
        return modelAndView;
    }
}
