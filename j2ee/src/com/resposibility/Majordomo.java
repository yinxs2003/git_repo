package com.resposibility;

public class Majordomo extends Manager {


    public Majordomo(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if (canDealRequest(request)) {
            System.out.println("请求类型：增长工资，增长小于500，批准");
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
        return request.getType() == Type.RISE_SALLARY && ((RequestFactory.RiseSalaryRequest) request).getRiseAmount() < 500;
    }
}
