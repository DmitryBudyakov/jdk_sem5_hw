package seminar5.hw;

/*
    Домашнее задание

    1. Пять безмолвных философов сидят вокруг круглого стола, перед каждым философом стоит тарелка спагетти.
    2. Вилки лежат на столе между каждой парой ближайших философов.
    3. Каждый философ может либо есть, либо размышлять.
    4. Философ может есть только тогда, когда держит две вилки — взятую справа и слева.
    5. Философ не может есть два раза подряд, не прервавшись на размышления (можно не учитывать)
    6. Философ может взять только две вилки сразу, то есть обе вилки должны быть свободны

    Описать в виде кода такую ситуацию. Каждый философ должен поесть три раза.
 */
public class Main {
    static final int PEOPLE_NUMBER = 5;

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[PEOPLE_NUMBER];
        Fork[] forks = new Fork[PEOPLE_NUMBER];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork();
        }

        // создание философов с вилками
        for (int i = 0; i < PEOPLE_NUMBER; i++) {
            if (i == PEOPLE_NUMBER - 1) {
                philosophers[i] = new Philosopher("Философ#" + (i + 1), forks[(i + 1) % forks.length], forks[i]);
            } else {
                philosophers[i] = new Philosopher("Философ#" + (i + 1), forks[i], forks[(i + 1) % forks.length]);
            }
        }

        // запуск потоков с философами
        for (Philosopher ph : philosophers) {
            Thread thread = new Thread(ph);
            thread.start();
        }

    }

}
