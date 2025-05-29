package ua.org.pattern.structural.proxy;

class Main{
    public static void main(String[] args) {
        Reader reader = new DatabaseReaderProxy();
        reader.readData();
    }
}
public class DatabaseReaderProxy extends DatabaseReader implements Reader {
    private DatabaseReader databaseReader;

    @Override
    public Data readData() {
        if (databaseReader == null) {
            System.out.println("Reader is null");
            databaseReader = new DatabaseReader();
        }
        return databaseReader.readData();
    }
}

interface Reader {
    Data readData();
}

class DatabaseReader implements Reader {
    public Data readData() {
        return null;
    }
}

class Data {

}