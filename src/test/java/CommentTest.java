/*
import models.Comment;
import models.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class CommentTest {

    Comment com;

    Date timestamp1 = Date.from(Instant.parse("2023-01-09T12:30:00.000Z"));
    Double value1 = Double.valueOf("6");

    @BeforeEach
    public void setUp(){
        com = new Comment(timestamp1, value1);
    }
    @Test
    public void testGetTimestamp(){
        Assertions.assertEquals(Date.from(Instant.parse("2023-01-09T12:30:00.000Z")), com.getTimestamp());}
    @Test
    public void testGetValue(){
        Assertions.assertEquals(Double.valueOf("6"), com.getValue());
    }
}

 */