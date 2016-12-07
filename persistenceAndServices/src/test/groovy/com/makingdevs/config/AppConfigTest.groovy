package com.makingdevs.config

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import javax.sql.DataSource


/**
 * Created by makingdevs on 11/25/16.
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration(classes = [AppConfig])
class AppConfigTest {
  @Autowired DataSource dataSource
  @Test
  void testDataSource(){
    assert dataSource
  }
}
