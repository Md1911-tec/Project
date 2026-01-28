package com.example.Kcare.Controller;

import com.example.Kcare.Dto.FeedbackRequestDto;
import com.example.Kcare.Entity.Feedback;
import com.example.Kcare.Service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class FeedbackController {

    private FeedbackService service;


    @PostMapping("/feedback")
    public Feedback submit(@RequestBody FeedbackRequestDto dto) {
        return service.submitFeedback(dto);
    }

    @GetMapping("/feedback/{userId}")
    public List<Feedback> getByUser(@PathVariable Long userId) {
        return service.getFeedbackByUserId(userId);
    }

}
