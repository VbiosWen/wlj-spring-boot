package org.geeksword.springboot;

import org.geeksword.springboot.zookeeper.ZookeeperApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {ZookeeperApplication.class})
@RunWith(SpringRunner.class)
public abstract class TestBase {
}
