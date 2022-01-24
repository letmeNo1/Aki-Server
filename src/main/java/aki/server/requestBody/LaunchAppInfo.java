package aki.server.requestBody;

public class LaunchAppInfo {

    private String bundleIdentifierOrAppLaunchPath;

    private boolean isUWPApp;


    public String getBundleIdentifierOrAppLaunchPath(){
        return bundleIdentifierOrAppLaunchPath;
    }

    public boolean getIsUWPApp(){
        return isUWPApp;
    }

}
