package aki.server.controller.windows;

import aki.Helper.Operation;
import aki.LaunchOption;
import aki.Windows.UIElementRef;
import aki.server.requestBody.LaunchAppInfo;
import aki.server.requestBody.windows.FindElementOption;
import aki.server.utils.Result;
import com.sun.jna.Pointer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class LaunchApp {
    private long getPeer(UIElementRef app){
        return Long.parseLong(app.getPointer().toString().replace("native@0x", ""), 16);
    }

    @ResponseBody
    @PostMapping("windows/launchApp")
    public Result launchApp(@RequestBody LaunchAppInfo launchAppInfo) {
        LaunchOption launchOption = new LaunchOption();
        launchOption.setIsUWPApp(launchAppInfo.getIsUWPApp());
        UIElementRef app;
        Map<Object, Long> data = new HashMap<>();;
        try {
            app = Operation.initializeAppRefForWin(launchAppInfo.getBundleIdentifierOrAppLaunchPath(), launchOption);
            long peer = getPeer(app);
            data.put("peer",peer);
        } catch (RuntimeException e) {
            return Result.fail(500, e.getMessage());
        }
        return Result.success(data);
    }
}
