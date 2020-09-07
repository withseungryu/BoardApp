//package com.example.realboard;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.hamcrest.core.Is;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//class RealboardApplicationTests {
//
//    private final String boardTestTitle= "테스트";
//    private final String email = "alstmdsha@gmail.com";
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    BoardRepository boardRepository;
//
//    @Before
//    public void init(){
//        User user = userRepository.save(User.builder().name("havi").password("test").email(email).build());
//
//        boardRepository.save(Board.builder().title(boardTestTitle).subTitle("subTitle").content("content")
//        .createdDate(Timestamp.valueOf(LocalDateTime.now())).updatedDate(Timestamp.valueOf(LocalDateTime.now())).user(user).build());
//    }
//
//
//
//    @Test
//    public void createdTest(){
//        System.out.println(userRepository);
//        User user = userRepository.findByEmail(email);
//        assertThat(user.getName(), is("havi"));
//        assertThat(user.getPassword(), is("test"));
//
//        Board board = boardRepository.findByUser(user);
//        assertThat(board.getTitle(), is(boardTestTitle));
//    }
//
//}
