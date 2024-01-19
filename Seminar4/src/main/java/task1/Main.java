package task1;

//Задание 1
//        Задача: Проверка логина и пароля
//        1. Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
//        2. Длина login должна быть меньше 20 символов. Если login не соответствует этим требованиям, необходимо выбросить
//        WrongLoginException.
//        3. Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны. Если password не
//        соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//        4. WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию,
//        второй принимает сообщение исключения и передает его в конструктор класса Exception.
//        5. В основном классе программы необходимо по-разному обработать исключения.
//        6. Метод возвращает true, если значения верны или false в другом случае.

public class Main {
    public static void main(String[] args) {
        System.out.println(checkCredentials("Benjamin", "password", "password"));
    }

    public static boolean checkCredentials(String login, String password, String confirmPassword){

        boolean confirm = password.equals(confirmPassword);
        int loginLng = login.length();
        int passLng = password.length();

        if(loginLng > 20){
            throw new WrongLoginException("Login is too long: " + loginLng + " vs " + 20 + " symbols required!");
        }
        if(passLng > 20){
            throw new WrongPasswordException("Password is too long: " + passLng + " vs " + 20 + " symbols required!");
        }
        if(!confirm){
            throw new WrongPasswordException("Password confirmation failed!");
        }

        return true;
    }
}
