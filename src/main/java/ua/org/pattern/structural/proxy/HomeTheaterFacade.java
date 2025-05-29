package ua.org.pattern.structural.proxy;

class Main3 {
    public static void main(String[] args) {
        // Створюємо компоненти
        TV tv = new TV();
        SoundSystem sound = new SoundSystem();
        DVDPlayer dvd = new DVDPlayer();
        Lights lights = new Lights();

        // Створюємо фасад
        HomeTheaterFacade theater = new HomeTheaterFacade(tv, sound, dvd, lights);

        // Користувач взаємодіє лише з фасадом
        theater.watchMovie("Inception");
        System.out.println("---");
        theater.endMovie();
    }
}

public class HomeTheaterFacade {
    private TV tv;
    private SoundSystem sound;
    private DVDPlayer dvd;
    private Lights lights;

    public HomeTheaterFacade(TV tv, SoundSystem sound, DVDPlayer dvd, Lights lights) {
        this.tv = tv;
        this.sound = sound;
        this.dvd = dvd;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparing to watch a movie...");
        lights.dim();
        tv.on();
        sound.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down movie theater...");
        dvd.stop();
        sound.off();
        tv.off();
        lights.on();
    }
}

class TV {
    public void on() {
        System.out.println("TV is turned on");
    }

    public void off() {
        System.out.println("TV is turned off");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound system is turned on");
    }

    public void off() {
        System.out.println("Sound system is turned off");
    }
}

class DVDPlayer {
    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("Movie stopped");
    }
}

class Lights {
    public void dim() {
        System.out.println("Lights are dimmed");
    }

    public void on() {
        System.out.println("Lights are on");
    }
}
