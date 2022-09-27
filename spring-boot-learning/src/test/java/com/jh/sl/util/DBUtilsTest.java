package com.jh.sl.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class DBUtilsTest {

    @Test
    public void testSerial4() {
        String url = "jdbc:postgresql://127.0.0.1:5432/db_test";
        String uid = "postgres";
        String pwd = "";
        long start = System.currentTimeMillis();
        int rows = 10000;
        int batch = 5000;
        try {
            try (Connection conn = DBUtils.getConnection(url, uid, pwd)) {
                String sql = "insert into tbl_serial4_test (updated_at, notes) values (?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                AtomicInteger count = new AtomicInteger(0);
                for (int i = 0; i < rows; i++) {
                    pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    pstmt.setString(2, UUID.randomUUID().toString());
                    pstmt.addBatch();
                    if (count.incrementAndGet() >= batch) {
                        count.set(0);
                        pstmt.executeBatch();
                        conn.commit();
                        log.info("Batch execute {}", batch);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("Completed: {}rows, {}ms", rows, System.currentTimeMillis() - start);
        }
    }

    @Test
    public void testSerial8() {
        String url = "jdbc:postgresql://127.0.0.1:5432/db_test";
        String uid = "postgres";
        String pwd = "";
        long start = System.currentTimeMillis();
        int rows = 10000;
        int batch = 10;
        try {
            try (Connection conn = DBUtils.getConnection(url, uid, pwd)) {
                String sql = "insert into tbl_serial8_test (updated_at, notes) values (?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                AtomicInteger count = new AtomicInteger(0);
                for (int i = 0; i < rows; i++) {
                    pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                    pstmt.setString(2, UUID.randomUUID().toString());
                    pstmt.addBatch();
                    if (count.incrementAndGet() >= batch) {
                        count.set(0);
                        pstmt.executeBatch();
                        conn.commit();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            log.info("Completed: {} rows, batch size {}, {}ms", rows, batch, System.currentTimeMillis() - start);
        }
    }

}
