package spring.lab.beantest;

public class BeansTester {
    private final TestBean testBean1;
    private final TestBean testBean2;

    public BeansTester(TestBean testBean1, TestBean testBean2) {
        this.testBean1 = testBean1;
        this.testBean2 = testBean2;
    }

    public void compare() {
        System.out.println("Bean1 == Bean2: " + (testBean1 == testBean2));
    }
}
