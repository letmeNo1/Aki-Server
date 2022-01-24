package aki.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CurrentAppRef {
    private static final ThreadLocal<Map<String, CurrentAppRef>> instance = ThreadLocal.withInitial(ConcurrentHashMap::new);


    public aki.Windows.UIElementRef WinUIElementRef;
    public aki.Mac.UIElementRef MacUIElementRef;

    public static CurrentAppRef getInstance() {
        String threadName = String.format("%s_%s", "org.aki.CurrentAppRefInfo", Thread.currentThread().getName());
        if (null == instance.get().get(threadName)) {
            synchronized (CurrentAppRef.class) {
                instance.get().put(threadName, new CurrentAppRef(threadName));
            }
        }
        return instance.get().get(threadName);
    }

    public CurrentAppRef(String threadName) {
    }

    public aki.Windows.UIElementRef getWinUIElementRef() {
        return this.WinUIElementRef;
    }

    public void setUIElementRef(aki.Windows.UIElementRef winUIElementRef) {
        this.WinUIElementRef = winUIElementRef;
    }

    public aki.Mac.UIElementRef getMacUIElementRef() {
        return this.MacUIElementRef;
    }

    public void setUIElementRef(aki.Mac.UIElementRef macUIElementRef) {
        this.MacUIElementRef = macUIElementRef;
    }


}