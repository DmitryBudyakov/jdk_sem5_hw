package seminar5.hw;

public class Philosopher implements Runnable {
    private static final int TIMES_TO_EAT = 3;
    private String name;
    Fork leftFork;
    Fork rightFork;

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void eat() {
        try {
            System.out.println(name + " кушает");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() {
        try {
            System.out.println(name + " размышляет");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int current = 1;
        while (current < TIMES_TO_EAT + 1) {
            think();
            synchronized (leftFork) {
                System.out.println(name + " берет левую вилку");
                leftFork.takeFork();
                synchronized (rightFork) {
                    System.out.println(name + " берет правую вилку");
                    rightFork.takeFork();
                        System.out.println(name + ":" + "Трапеза #" + current);
                    eat();
                    System.out.println(name + " кладет правую вилку");
                    rightFork.putFork();
                }
                System.out.println(name + " кладет левую вилку");
                leftFork.putFork();
            }
            think();
            current++;
        }
    }
}
