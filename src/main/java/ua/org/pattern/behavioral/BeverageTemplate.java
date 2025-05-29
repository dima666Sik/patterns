package ua.org.pattern.behavioral;

class Main2 {
    public static void main(String[] args) {
        BeverageTemplate tea = new Tea();
        System.out.println("Готуємо чай:");
        tea.prepareRecipe();

        System.out.println("\nГотуємо каву:");
        BeverageTemplate coffee = new Coffee();
        coffee.prepareRecipe();
    }
}

class Coffee extends BeverageTemplate {

    @Override
    protected void brew() {
        System.out.println("Заварюємо каву");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Додаємо молоко і цукор");
    }

    // Приклад кастомізації хука
    @Override
    protected boolean customerWantsCondiments() {
        return false; // Користувач не хоче додатків
    }
}

class Tea extends BeverageTemplate {

    @Override
    protected void brew() {
        System.out.println("Заварюємо чай");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Додаємо лимон");
    }
}


public abstract class BeverageTemplate {

    // Шаблонний метод — skeleton
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    private void boilWater() {
        System.out.println("Кип'ятимо воду");
    }

    private void pourInCup() {
        System.out.println("Наливаємо в чашку");
    }

    // Абстрактні кроки
    protected abstract void brew();
    protected abstract void addCondiments();

    // Хук — можна перевизначити
    protected boolean customerWantsCondiments() {
        return true;
    }
}
