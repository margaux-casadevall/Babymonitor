import models.GlucoseLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

public class GlucoseLevelTest {
    GlucoseLevel glu;
    Date timestamp1 = Date.from(Instant.parse("2023-01-01T12:00:00.000Z"));
    Double value1 = Double.valueOf("4");

    @BeforeEach
    public void setUp(){
        glu = new GlucoseLevel(timestamp1,value1);

    }
    @Test
    public void testGetTimestamp(){
        Assertions.assertEquals(Date.from(Instant.parse("2023-01-01T12:00:00.000Z")), glu.getTimestamp());}

    @Test
    public void testGetValue(){
        Assertions.assertEquals(Double.valueOf("4"), glu.getValue());
    }
}

