package com.resposibility;

public class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if (request.getType() == Type.ABSENCE) {
            System.out.println("总经理，请假批准");
            return;
        }
        if (request.getType() == Type.RISE_SALLARY) {
            RequestFactory.RiseSalaryRequest riseSalaryRequest = (RequestFactory.RiseSalaryRequest) request;
            if (riseSalaryRequest.getRiseAmount() > 500) {
                System.out.println("总经理：工资增长大于500，考虑一下");
            }
        }
    }
}
