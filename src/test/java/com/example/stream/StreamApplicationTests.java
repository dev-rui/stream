package com.example.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(value = {StreamApplicationTests.SinkSender.class})
public class StreamApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private SinkSender sinkSender;

	@Test
	public void sinkSenderTester() {
		sinkSender.output().send(MessageBuilder.withPayload("produce a message ：http://blog.didispace.com").build());
	}

	public interface SinkSender {

		String OUTPUT = "input";

		@Output(SinkSender.OUTPUT)
		MessageChannel output();

	}


}
