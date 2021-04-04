package me.kimheesuk.memoapiserver;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class MemoApiServerApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        try(Connection conn = dataSource.getConnection()){
            System.out.println(conn.getMetaData().getDriverName());
            System.out.println(conn.getMetaData().getURL());
            System.out.println(conn.getMetaData().getUserName());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
