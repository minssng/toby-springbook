package springbook.user.dao;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        ApplicationContext context =
//                new GenericXmlApplicationContext("applicationContext.xml");
//
//
//        UserDao dao = context.getBean("userDao", UserDao.class);
//
//        User user = new User();
//        user.setId("id");
//        user.setName("name");
//        user.setPassword("password");
//        dao.add(user);
//
//        User user2 = dao.get(user.getId());
//
//        if (!user.getName().equals(user2.getName())) {
//            System.out.println("테스트 실패 (name)");
//        }else if (!user.getPassword().equals(user2.getPassword())) {
//            System.out.println("테스트 실패 (password)");
//        } else {
//            System.out.println("테스트 성공");
//        }
        JUnitCore.main("springbook.user.dao.UserDaoTest");
    }

    @Test
    public void addAndGet() throws SQLException { // JUnit 테스트 메소드는 반드시 public으로 선언되어야 함.
        ApplicationContext context =
                new GenericXmlApplicationContext("applicationContext.xml");


        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = dao.get("gyummee");

        User user2 = dao.get("test");

        assertThat(user2.getName(), is(user.getName()));
        assertThat(user2.getPassword(), is(user.getPassword()));
    }
}
