
public class SchoolGrades {
    public static void main(String[] args) {
        //0 ile 100 arasında rastgele sayı üret 0 ve 100 dahil
        int grade = (int) (Math.random()*101);
        System.out.print("notunuz "+grade+" ve harf notunuz  ");
        /*
        Negatif sayıları ve 100'den büyük sayıları kontrol etmedim çünkü
         (Math.random()*101) fonksiyonu  0-100 arasındaki sınırı garanti eder.
         */
            if (grade >= 70)
                System.out.println("AA");
            else if (grade >= 50)
                System.out.println("BB");
            else if (grade >= 35)
                System.out.println("DC");
            else
                System.out.println("FF");
    }
}
