package com.unipo.pissir.contoller;


import com.unipo.pissir.domain.TimeSlot;
import com.unipo.pissir.repository.TimeSlotRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeSlotComtroller
{
    private  final TimeSlotRepository timeSlotRepository;

    public TimeSlotComtroller(TimeSlotRepository timeSlotRepository)
    {
        this.timeSlotRepository = timeSlotRepository;
    }


    @GetMapping("/timeslot")
    List<TimeSlot> allTimeslot()
    {
        System.out.println("Enter in ALL timeslot");
        return timeSlotRepository.findAll();
    }

   
    @PostMapping("/timeslot")
    TimeSlot newTimeSlot(@RequestBody TimeSlot newTimeSlot) {
        System.out.println(newTimeSlot.toString());

        return timeSlotRepository.save(newTimeSlot);
    }


    @GetMapping("/timeslot/{id}")
    TimeSlot getTimeslotById(@PathVariable Long id) {

        return timeSlotRepository.findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(id));
    }

    @PutMapping("/timeslot/{id}")
    TimeSlot replaceTimeSlot(@RequestBody TimeSlot newTimeSlot, @PathVariable Long id) {

        System.out.println(newTimeSlot);
        return timeSlotRepository.findById(id)
                .map(timeSlot -> {
                    timeSlot.setInitTime((int) newTimeSlot.getInitTime());
                    timeSlot.setEndTime((int) newTimeSlot.getInitTime());
                    return timeSlotRepository.save(newTimeSlot);
                })
                .orElseGet(() -> {
                    newTimeSlot.setId(id);
                    return timeSlotRepository.save(newTimeSlot);
                });
    }
    @DeleteMapping("/timeslot/{id}")
    void deletetimeSlot(@PathVariable Long id) {timeSlotRepository.deleteById(id);
    }
}
