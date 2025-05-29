package ua.org.pattern.structural.proxy;

class App {
    public static void main(String[] args) {
        // Стороння бібліотека
        JsonProcessor jsonProcessor = new JsonProcessor();

        // Наш адаптер
        XmlDataHandler handler = new XmlToJsonAdapter(jsonProcessor);

        // XML-дані
        String xml = "<book><title>Example</title></book>";

        // Обробляємо XML, який "всередині" обробиться як JSON
        handler.handleXml(xml);
    }
}


// Сторонній JSON API
class JsonProcessor {
    public void processJson(String json) {
        System.out.println("Processing JSON: " + json);
    }
}

// Наша система працює тільки з XML
interface XmlDataHandler {
    void handleXml(String xmlData);
}

// Адаптер, який реалізує наш інтерфейс, але всередині викликає сторонню JSON-бібліотеку
public class XmlToJsonAdapter implements XmlDataHandler {
    private final JsonProcessor jsonProcessor;

    public XmlToJsonAdapter(JsonProcessor jsonProcessor) {
        this.jsonProcessor = jsonProcessor;
    }

    @Override
    public void handleXml(String xmlData) {
        // перетворення XML -> JSON
        String json = convertXmlToJson(xmlData);
        jsonProcessor.processJson(json);
        System.out.println("XML processed");
    }

    // У реальності тут був би повноцінний XML -> JSON парсер
    private String convertXmlToJson(String xmlData) {
        return "{ \"data\": \"" + xmlData.replace("\"", "\\\"") + "\" }";
    }
}

