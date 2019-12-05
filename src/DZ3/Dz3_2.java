package DZ3;

public class Dz3_2 {
    public static void main(String[] args) {
        SprPhone sprPhone = new SprPhone();

        sprPhone.add("Иванов", "+79136210001");
        sprPhone.add("Петров", "+79136210002");
        sprPhone.add("Сидоров", "+79136210003");
        sprPhone.add("Спиваков", "+79136210004");
        sprPhone.add("Арбузов", "+79136210005");
        sprPhone.add("Буденный", "+79136210006");
        sprPhone.add("Иванов", "+79136210007");
        sprPhone.add("Сидоров", "+79136210008");
        sprPhone.add("Сталин", "+79136210009");
        sprPhone.add("Брежнев", "+79136210010");
        sprPhone.add("Арбузов", "+79136210011");
        sprPhone.add("Иванов", "+79136210012");
        sprPhone.add("Терехов", "+79136210013");
        sprPhone.add("Спицын", "+79136210014");
        sprPhone.add("Иванов", "+79136210015");

        sprPhone.get("Иванов");
        sprPhone.get("Петров");
        sprPhone.get("Арбузов");
        sprPhone.get("Абрамович");
    }
}
