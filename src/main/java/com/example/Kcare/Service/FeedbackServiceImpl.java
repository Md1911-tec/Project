package com.example.Kcare.Service;

import com.example.Kcare.Dto.FeedbackRequestDto;
import com.example.Kcare.Entity.Feedback;
import com.example.Kcare.Repository.FeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRepository repository;

    @Override
    public Feedback submitFeedback(FeedbackRequestDto dto) {

        Feedback fb = new Feedback();
        fb.setUserId(dto.getUserId());
        fb.setType(dto.getType());
        fb.setMessage(dto.getMessage());
        fb.setStatus("OPEN");
        fb.setCreatedDate(LocalDateTime.now());

        return repository.save(fb);
    }

    @Override
    public List<Feedback> getFeedbackByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

}
