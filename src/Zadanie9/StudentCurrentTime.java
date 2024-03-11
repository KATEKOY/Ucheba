package Zadanie9;

import java.time.LocalTime;

public class StudentCurrentTime implements Learner {
    private Learner learner;

    public StudentCurrentTime(Learner learner) {
        this.learner = learner;
    }
        @Override
        public void learn () {
            LocalTime currentTime = LocalTime.now();
            learner.learn();
            System.out.println("Текущее время: " + currentTime);
        }
    }

