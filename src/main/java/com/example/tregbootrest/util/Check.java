package com.example.tregbootrest.util;

import com.example.tregbootrest.entity.Status;
import com.example.tregbootrest.entity.User;
import com.example.tregbootrest.repository.UserRepository;

public class Check extends Thread {

    private User user;
    private final UserRepository userRepository;


    public Check(UserRepository userRepository, User user) {
        this.user = user;
        this.userRepository = userRepository;
    }


    @Override
    public void run() {
        /** Цикл проходит 120 шагов, засыпая на каждом шаге на 1 секунду,
         * таким образом, проверка 1 раз в секунду в течении 2 минут **/

        for (int i = 0; i < 120; i++) {
            //if (userRepository.findById(user.getId()).isPresent()) {
                try {
                    sleep(1000);        //Приостанавливает поток на 1 секунду
                } catch (InterruptedException e) {
                }
                try {
                    user = userRepository.findById(user.getId()).orElseThrow(UserNotFoundException::new);
                    if (user.getStatus() == Status.AVAILABLE) {
                        System.out.println(user.getStatus().toString() + i);
                    } else if (user.getStatus() == Status.SOLD) {
                        System.out.println("SOLD");
                        break;
                    }
                } catch (UserNotFoundException e) {
                    break;
                }

        }

    }
}
