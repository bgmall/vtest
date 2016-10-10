package camphor.game;

/**
 * Created by 37 on 2016/9/30.
 */
public interface Component extends GameEventListener {
    /**
     * 初始化
     */
    void init();
    /**
     * 准备就绪
     */
    void ready();
    /**
     * 挂起组件
     */
    void suspend();
    /**
     * 销毁
     */
    void destroy();
    /**
     * 设置组件拥有者
     * */
    void setParent(GameObject parent);
    /**
     * 接收ActionEvent
     * @param event
     */
    void handleActionEvent(ActionEvent<?> event);
}
