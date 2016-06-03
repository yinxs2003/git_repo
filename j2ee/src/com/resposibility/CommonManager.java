package com.resposibility;

/**
 * 经理
 */
public class CommonManager extends Manager {
    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if (canDealRequest(request)) {
            System.out.println("请假数目小于2天，批准。");
        } else {
            postToSuperior(request);
        }
    }

    private void postToSuperior(Request request) {
        if (superior != null) {
            superior.requestApplication(request);
        }
    }

    private boolean canDealRequest(Request request) {
        return request.getType() == Type.ABSENCE && ((RequestFactory.AbsenceRequest) request).getDays() < 2;
    }
}
