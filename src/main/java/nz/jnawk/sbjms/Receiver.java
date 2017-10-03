package nz.jnawk.sbjms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(final String content) {
		logger.info("Received <" + content + ">");
	}

}