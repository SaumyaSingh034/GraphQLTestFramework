package PojoPractice.RahulShetty;

import java.util.List;

public class Courses {
    private List<WebAutomation> webAutomationList;
    private List<Api> api;

    public List<WebAutomation> getWebAutomationList() {
        return webAutomationList;
    }

    public void setWebAutomationList(List<WebAutomation> webAutomationList) {
        this.webAutomationList = webAutomationList;
    }

    public List<Api> getApi() {
        return api;
    }

    public void setApi(List<Api> api) {
        this.api = api;
    }

    public List<Mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<Mobile> mobile) {
        this.mobile = mobile;
    }

    private List<Mobile> mobile;


}
