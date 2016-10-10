package camphor.game;

/**
 * Created by msg on 2016/10/8.
 */
public class SampleComponent extends AbstractComponent {

    private int i = 0;

    @Override
    public void handleGameEvent(GameEvent<?> event) {
//        super.handleGameEvent(event);
        ReplyHandler<String> replyHandler = event.getReplyHandler();
        replyHandler.reply("hello, world");
    }

    public <H> void sendReplyGameEvent(long receiverId, String eventId, ReplyHandler<H> handler) {
//        GameEvent<?> gameEvent = GameEvent.getInstance(eventId);
////        gameEvent.setReplyHandler(handler);
//        handleGameEvent(gameEvent);
    }


    public void callback(String result) {
//        System.out.println("callback=" + result);
        i++;
    }

    public int getIntValue() {
        return this.i;
    }

    public static void main(String[] args) {
        SampleComponent sampleComponent = new SampleComponent();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
//            sampleComponent.sendReplyGameEvent(1, null, new AsyncHandler<String>() {
//                @Override
//                public void handle(String result) {
//                    sampleComponent.callback(result);
//                }
//            });
            sampleComponent.callback("hello,world");
        }
        long usemills = System.currentTimeMillis() - start;
        System.out.println("callback=" + sampleComponent.getIntValue() + ", " + usemills);

        start = System.currentTimeMillis();
        ReplyHandler<String> handler = sampleComponent::callback;
        for (int i = 0; i < 100000; i++) {
//            sampleComponent.sendReplyGameEvent(1, null, new AsyncHandler<String>() {
//                @Override
//                public void handle(String result) {
//                    sampleComponent.callback(result);
//                }
//            });
            sampleComponent.sendReplyGameEvent(1, "hello", handler);
        }
        usemills = System.currentTimeMillis() - start;
        System.out.println("callback=" + sampleComponent.getIntValue() + ", " + usemills);
    }

    public <T> void handleGameEvent(int v, GameEvent<T> event) {
        ReplyHandler handler = event.getReplyHandler();
        deliverToHandle("hello,world", handler);
//        int value = event.getData();
    }

    public <T> void deliverToHandle(Object ret, ReplyHandler<T> handler) {
        @SuppressWarnings("unchecked") T returnValue = (T) ret;
        handler.reply(returnValue);
    }
}
