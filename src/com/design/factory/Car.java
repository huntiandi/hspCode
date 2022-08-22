    package com.design.factory;

    /**
     * @ProjectName: com.design.single
     * @author: ZhangBiBo
     * @description: 工厂模式
     * @data: 2022/8/15
     */
    public interface Car {
         void run();
    }
    class WuLin implements Car{
        @Override
        public void run() {
            System.out.println("nihao,wulin");
        }
    }

    class TesLa implements Car{
        @Override
        public void run() {
            System.out.println("nihao,tesila");
        }
    }
    interface CarFactory {
        Car getCar();
    }
    class WuLinFactory implements CarFactory{
        @Override
        public Car getCar() {
            return new WuLin();
        }
    }
    class TeslaFactory implements CarFactory{
        @Override
        public Car getCar() {
            return new TesLa();
        }
    }
    class testCar{
        public static void main(String[] args) {
            Car car = new WuLinFactory().getCar();
            Car car1 = new TeslaFactory().getCar();
            car.run();
            car1.run();
        }
    }