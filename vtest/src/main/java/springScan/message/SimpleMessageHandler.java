package springScan.message;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@MessageHandler
@Component
@Scope("prototype")
public class SimpleMessageHandler {

}
