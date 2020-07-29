package com.kawamind;

import io.quarkus.test.junit.QuarkusTest;

import io.vertx.mutiny.mysqlclient.MySQLPool;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

import javax.inject.Inject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {

    @Inject
    MySQLPool pool;

    @Test
    void testQuery() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        pool.query("Select name from User").executeAndAwait().forEach(row -> {
                System.out.println(row.getString("name"));
                countDownLatch.countDown();
            });
        Assert.assertTrue(countDownLatch.await(2, TimeUnit.SECONDS));
    }

}