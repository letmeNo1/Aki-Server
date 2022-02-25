package aki.server.controller.windows;


import aki.Windows.UIElementRef;
import aki.server.requestBody.windows.OperationOption;
import aki.server.utils.Result;
import com.sun.jna.Pointer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Operation {
    private long getPeer(UIElementRef app){
        return Long.parseLong(app.getPointer().toString().replace("native@0x", ""), 16);
    }

    @ResponseBody
    @PostMapping("windows/operate")
    public Result operate(@RequestBody OperationOption mouseOperationOption) {
        UIElementRef app = new UIElementRef(new Pointer(mouseOperationOption.getPeer()));
        long peer = 0;
        switch (mouseOperationOption.getMethod()) {
            case "click":
                try {
                    app.click();
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
            case "doubleClick":
                try {
                    app.doubleClick();
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
            case "longClick":
                try {
                    app.longClick(mouseOperationOption.getDuration());
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "hover":
                try {
                    app.hover();
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
            case "clear":
                try {
                    app.clear();
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
            case "type":
                try {
                    app.type(mouseOperationOption.getInputContent());
                } catch (RuntimeException e) {
                    return Result.fail(500, e.getMessage());
                }
                break;
//            case "kill":
//                try {
//                    app.kill();
//                } catch (RuntimeException e) {
//                    return Result.fail(500, e.getMessage());
//                }
//                break;
        }
        Map<String, Object> data = new HashMap<>();
        data.put("peer",peer);
        return Result.success(data);
    }
}