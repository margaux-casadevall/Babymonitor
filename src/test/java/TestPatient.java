import models.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestPatient {
    Patient pat;
    String doctor1 = "Dr Charls";
    String id1 = String.valueOf(Long.valueOf("2358801"));
    String hospital1 = "St.Mary's";
    LocalDate dateAdmitted1 = LocalDate.of(2023,01,03);

    @BeforeEach
    public void setUp(){
        pat = new Patient(doctor1, id1, hospital1, dateAdmitted1);

    }
    @Test
    public void testGetid(){
        Assertions.assertEquals(String.valueOf(Long.valueOf("2358801")), pat.getId());}


    @Test
    public void testGethospital(){
        Assertions.assertEquals("St.Mary's", pat.getHospital());
    }

    @Test
    public void testGetdateAdmitted(){
        Assertions.assertEquals(LocalDate.of(2023,01,03), pat.getDateAdmitted());
    }
}

