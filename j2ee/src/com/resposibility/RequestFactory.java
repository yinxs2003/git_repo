package com.resposibility;

public class RequestFactory {

    private RequestFactory() {
    }

    public static AbsenceRequest createAbsenceRequest(int days) {
        return new AbsenceRequest(Type.ABSENCE, days);
    }

    public static RiseSalaryRequest createRiseSalaryRequest(int riseAmount) {
        return new RiseSalaryRequest(Type.RISE_SALLARY, riseAmount);
    }

    static class AbsenceRequest extends Request {
        private int days = 0;

        public AbsenceRequest(Type type, int days) {
            super(type);
            this.days = days;
        }

        public int getDays() {
            return days;
        }
    }

    //涨工资请求
    static class RiseSalaryRequest extends Request {
        private int riseAmount = 0;

        public RiseSalaryRequest(Type type, int riseAmount) {
            super(type);
            this.riseAmount = riseAmount;
        }

        public int getRiseAmount() {
            return riseAmount;
        }
    }
}