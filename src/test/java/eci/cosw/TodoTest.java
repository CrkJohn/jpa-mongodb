package eci.cosw;


import eci.cosw.data.ITodoRepository;
import eci.cosw.data.model.Todo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoTest {

    @Autowired

    private ITodoRepository iTodoRepository;

    @Test
    public void findByResponsibleTest(){

        iTodoRepository.deleteAll();
        iTodoRepository.save(new Todo("Test 1" , "ThisTest" , "Ready" , new Date(), 1 ));
        iTodoRepository.save(new Todo("Test 2 " , "JohnDavid" , "Ready" , new Date(), 1 ));
        iTodoRepository.save(new Todo("Test 3 " , "JohnDavid" , "Ready" , new Date(), 1 ));

        List<Todo> todos = iTodoRepository.findByResponsible("ThisTest");
        Assert.assertEquals(1, todos.size());
        Assert.assertEquals("Test 1" , todos.get(0).getDescription());
    }

}