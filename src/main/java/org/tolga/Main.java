package org.tolga;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> randomSayi = generateRandomList(100);
        List<Integer> randomSayiKopya = new ArrayList<>(randomSayi);

        Random random = new Random();
        int randomIndex = random.nextInt(100);

        if (randomIndex >= 0 && randomIndex < randomSayiKopya.size()) {
            randomSayiKopya.remove(randomIndex);
        }

        int eksikSayi = eksikSayiMetod(randomSayi, randomSayiKopya);

        System.out.println("Random Sayi Listesi: " + randomSayi);
        System.out.println("Random Kopya Listesi: " + randomSayiKopya);
        System.out.println("Eksik Sayi: " + eksikSayi);
    }
    private static List<Integer> generateRandomList(int size) {
        List<Integer> randomSayiOlustur = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomSayiOlustur.add(random.nextInt(101));
        }

        return randomSayiOlustur;
    }


    private static int eksikSayiMetod(List<Integer> randomSayi, List<Integer> randomSayiKopya) {
        Collections.sort(randomSayi);
        Collections.sort(randomSayiKopya);

        for (int i = 0; i < randomSayi.size(); i++) {
            if (!randomSayi.get(i).equals(randomSayiKopya.get(i))) {
                return randomSayi.get(i);
            }
        }

        //!
        return randomSayi.get(randomSayi.size() - 1);
    }
}