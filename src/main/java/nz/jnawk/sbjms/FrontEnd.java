package nz.jnawk.sbjms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontEnd {
	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${ID:foo}")
	private String initialDestination;

	/**
	 * This method listens for GET requests on / and sends a message to the initial
	 * destination.
	 * <p>
	 * There is a receiver set on that destination which will delegate the message
	 * to the processor.
	 */
	@RequestMapping("/")
	public void seedMessage() {
		jmsTemplate.convertAndSend(initialDestination, "Hello, world");
	}
}
