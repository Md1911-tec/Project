package com.example.Kcare.Service;

import com.example.Kcare.Dto.FeedbackRequestDto;
import com.example.Kcare.Entity.Feedback;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FeedbackService {

    Feedback submitFeedback(FeedbackRequestDto dto);

    List<Feedback> getFeedbackByUserId(Long userId);

}
