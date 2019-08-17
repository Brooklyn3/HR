package com.qfedu.hr.pojo;



public class Salary {
        private Integer id;
        private Integer userId;
        private double basic;
        private double eat;
        private double house;
        private double duty;
        private double scot;
        private double punishment;
        private double other;
        private String granTime;
        private double totalize;

        public Salary() {
        }

        public Salary(Integer userId, double basic, double eat, double house, double duty, double scot, double punishment, double other, String granTime) {
            this.userId = userId;
            this.basic = basic;
            this.eat = eat;
            this.house = house;
            this.duty = duty;
            this.scot = scot;
            this.punishment = punishment;
            this.other = other;
            this.granTime = granTime;
            this.totalize = basic + eat + house + duty + scot + punishment + other;
        }

        public Salary(Integer id, Integer userId, double basic, double eat, double house, double duty, double scot, double punishment, double other, String granTime, double totalize) {
            this.id = id;
            this.userId = userId;
            this.basic = basic;
            this.eat = eat;
            this.house = house;
            this.duty = duty;
            this.scot = scot;
            this.punishment = punishment;
            this.other = other;
            this.granTime = granTime;
            this.totalize = basic + eat + house + duty + scot + punishment + other;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public double getBasic() {
            return basic;
        }

        public void setBasic(double basic) {
            this.basic = basic;
        }

        public double getEat() {
            return eat;
        }

        public void setEat(double eat) {
            this.eat = eat;
        }

        public double getHouse() {
            return house;
        }

        public void setHouse(double house) {
            this.house = house;
        }

        public double getDuty() {
            return duty;
        }

        public void setDuty(double duty) {
            this.duty = duty;
        }

        public double getScot() {
            return scot;
        }

        public void setScot(double scot) {
            this.scot = scot;
        }

        public double getPunishment() {
            return punishment;
        }

        public void setPunishment(double punishment) {
            this.punishment = punishment;
        }

        public double getOther() {
            return other;
        }

        public void setOther(double other) {
            this.other = other;
        }

        public String getGranTime() {
            return granTime;
        }

        public void setGranTime(String granTime) {
            this.granTime = granTime;
        }

        public double getTotalize() {
            return totalize;
        }

        public void setTotalize(double totalize) {
            this.totalize = totalize;
        }

        @Override
        public String toString() {
            return "Salary{" +
                    "id=" + id +
                    ", userId='" + userId + '\'' +
                    ", basic=" + basic +
                    ", eat=" + eat +
                    ", house=" + house +
                    ", duty=" + duty +
                    ", scot=" + scot +
                    ", punishment=" + punishment +
                    ", other=" + other +
                    ", granTime='" + granTime + '\'' +
                    ", totalize=" + totalize +
                    '}';
        }
}