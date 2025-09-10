package org.uniquindio.edu.co.pdc.model;

public class User {

    private Bike bike;

    private String name;
    private String id;
    private String phone;
    private String address;
    private int age;
    private String email;

    private User(Builder builder){
        this.name = builder.name;
        this.phone = builder.phone;
        this.id = builder.id;
        this.address = builder.address;
        this.age = builder.age;
        this.email = builder.email;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "bike=" + bike +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder{

        private String name;
        private String id;
        private String phone;
        private String address;
        private int age;
        private String email;


        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
