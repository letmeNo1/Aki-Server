package aki.server.controller.windows;


import aki.Windows.UIElementRef;
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
public class FindElement {
    private long getPeer(UIElementRef app){
        return Long.parseLong(app.getPointer().toString().replace("native@0x", ""), 16);
    }

    private UIElementRef getUIElementRef(Long peer){
        return new UIElementRef(new Pointer(peer));
    }


    @ResponseBody
    @PostMapping("windows/findElement")
    public Result findElement(@RequestBody FindElementOption findElementOption) {
        UIElementRef app;
        app = new UIElementRef(new Pointer(findElementOption.getPeer()));
        UIElementRef element;
        long peer = 0;
        switch (findElementOption.getMethod()) {
            case "ByAutomationId":
                try {
                    element = app.findElementByAutomationId(findElementOption.getParameter(), findElementOption.getIndex());
                    peer = getPeer(element);
                    app.getPointer();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return Result.fail(500, e.getMessage());
                }
                break;
            case "ByRole":
                try {
                    element = app.findElementsByRole(findElementOption.getParameter(), findElementOption.getIndex());
                    peer = getPeer(element);
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
            case "ByText":
                try {
                    element = app.findElementsByText(findElementOption.getParameter(), findElementOption.getIndex());
                    peer = getPeer(element);
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
            case "PartialText":
                try {
                    element = app.findElementsByPartialText(findElementOption.getParameter(), findElementOption.getIndex());
                    peer = getPeer(element);
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
            case "ByFullDescription":
                try {
                    element = app.findElementByFullDescription(findElementOption.getParameter(), findElementOption.getIndex());
                    peer = getPeer(element);
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
            case "ByImage":
                try {
                    element = app.findElementLocationByImage(findElementOption.getParameter(), findElementOption.getIndex());
                    peer = getPeer(element);
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
        }
        Map<String, Object> data = new HashMap<>();
        data.put("peer",peer);
        return Result.success(data);
    }


}
