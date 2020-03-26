package com.example.demo.repository;


import com.example.demo.model.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Dbinit implements CommandLineRunner {

  private UserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  public Dbinit(UserRepository userRepository,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }


  @Override
  public void run(String... args) throws Exception {

    userRepository.deleteAll();

    User user1 = new User("hoon",passwordEncoder.encode("hoon123"),"NORMAL","");
    User user2 = new User("hyon",passwordEncoder.encode("hyun123"),"BROTHER","ACCESS_PIANO");
    User user3 = new User("mom",passwordEncoder.encode("mom123"),"ADMIN","ACCESS_PIANO, ACCESS_TV");


    List<User> userList = Arrays.asList(user1,user2,user3);

    userRepository.saveAll(userList);
  }
}
