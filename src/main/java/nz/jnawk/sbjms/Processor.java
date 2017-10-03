package nz.jnawk.sbjms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Processor {
	private static final Logger logger = LoggerFactory.getLogger(Processor.class);

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * Processes a message. Sends a greeting to "WhereToSend" which includs the
	 * original message.
	 * 
	 * @param content
	 *            the content of the message
	 */
	public void processMessage(final String content) {
		logger.info("Received <" + content + ">");
		jmsTemplate.convertAndSend("WhereToSend", "Hello, back world!\nYou said:\n" + content);
	}

}