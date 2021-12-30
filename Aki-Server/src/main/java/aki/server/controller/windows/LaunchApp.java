package aki.server.controller.windows;

import aki.Helper.Operation;
import aki.LaunchOption;
import aki.Windows.UIElementRef;
import aki.server.CurrentAppRef;
import aki.server.requestBody.LaunchAppInfo;
import aki.server.requestBody.windows.FindElementOption;
import aki.server.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LaunchApp {
    @ResponseBody
    @PostMapping("windows/launchApp")
    public Result launchApp(@RequestBody LaunchAppInfo launchAppInfo) {
        LaunchOption launchOption = new LaunchOption();
        launchOption.setIsUWPApp(launchAppInfo.getIsUWPApp());
        UIElementRef app;
        try{
            app = Operation.initializeAppRefForWin(launchAppInfo.getBundleIdentifierOrAppLaunchPath(),launchOption);
            CurrentAppRef.getInstance().setUIElementRef(app);
            Result.success();
        }catch (RuntimeException e){
            return Result.fail(500, e.getMessage());
        }
        return Result.success();
    }

    @ResponseBody
    @PostMapping("windows/findElement")
    public Result findElement(@RequestBody FindElementOption findElementOption) {
        UIElementRef app = CurrentAppRef.getInstance().getWinUIElementRef();
        if (findElementOption.getMethod().equals("ByAutomationId")) {
            app.findElementByAutomationId(findElementOption.getParameter(), findElementOption.getIndex());
        }

        return Result.success();
    }
}
