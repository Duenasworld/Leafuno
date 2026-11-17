# PlantLove

PlantLove soll dabei helfen, Zimmerpflanzen im Alltag gesund zu halten. Die App soll Pflanzen und ihre Standorte übersichtlich verwalten, den Pflegebedarf verständlich anzeigen und beim Giessen und Düngen unterstützen. Langfristig sind unter anderem Hinweise zur Standortwahl, eine Pflegehistorie, Hilfe bei Pflanzenproblemen und die gemeinsame Nutzung im Haushalt denkbar.

## Projektstand

Dieses Repository ist das technische Grundgerüst für die geplante Pflanzen-App und die CAS-OOP-Modularbeit. Die eigentlichen Pflanzenfunktionen sind noch nicht umgesetzt. Aktuell zeigt die JavaFX-Oberfläche eine Begrüssung aus dem `HelloService`; der Spring-Boot-Webserver antwortet unter `/` mit einer einfachen Statusmeldung.

Die Produktübersicht beschreibt die langfristige Vision. Die TechSpec grenzt davon den kleineren Prüfungsumfang ab. Für die erste Umsetzung sind insbesondere Pflanzen und Standorte, Licht- und Temperaturbewertungen, die Berechnung der Giessfälligkeit, lokale JSON-Dateien und eine lesende Webansicht vorgesehen. Eine Datenbank und externe Dienste gehören nicht zu diesem Prüfungsumfang.

## Architektur des Grundgerüsts

JavaFX und Spring Boot laufen gemeinsam in einer Anwendung. Beim Start öffnet JavaFX den Spring-Kontext mit Webserver und Services und lädt danach die FXML-Oberfläche. Beim Schliessen des JavaFX-Fensters wird Spring beendet.

```text
javafx:run
 └─ PlantLoveApplication.main()   Einstiegspunkt, startet JavaFX
     └─ FxApplication             steuert den JavaFX-Lebenszyklus
         ├─ init()                startet Spring und dessen Beans
         ├─ start()               lädt plant-view.fxml
         └─ stop()                beendet Spring und den Webserver
```

### Klassen im Überblick

| Klasse | Aufgabe im Grundgerüst |
|---|---|
| `PlantLoveApplication` | Einstiegspunkt (`main`), startet JavaFX und ist mit `@SpringBootApplication` markiert. |
| `FxApplication` | Startet und beendet Spring, lädt die FXML-Oberfläche und zeigt das Fenster. |
| `FXHauptController` | Steuert die FXML-Oberfläche und erhält den Service über Spring. |
| `HelloService` | Beispiel-Service. Gibt derzeit eine Begrüssung zurück; später kann hier Anwendungslogik ergänzt werden. |
| `WebLeseController` | Einfacher REST-Controller. `/` liefert derzeit eine Statusmeldung des Servers. |

### Projektstruktur

- `src/main/java/com/duenasworld/plantlove/` – Java-Klassen
- `src/main/resources/view/plant-view.fxml` – Layout der JavaFX-Oberfläche
- `src/main/resources/application.properties` – Spring-Konfiguration
- `pom.xml` – Abhängigkeiten und Build-Plugins
- `docs/` – Projektunterlagen und Diagramme

## Starten

Voraussetzung ist die im `pom.xml` festgelegte Java-Version. Maven ist dank Maven Wrapper nicht separat erforderlich.

In IntelliJ über das Maven-Panel: `PlantLove → Plugins → javafx → javafx:run`.

Im Terminal:

```bash
# Windows
mvnw.cmd javafx:run

# macOS / Linux
./mvnw javafx:run
```

Es öffnet sich das Desktop-Fenster. Gleichzeitig läuft der Spring-Server:

- Auf dem Entwicklungsrechner: <http://localhost:8080>
- Der Port kann in `src/main/resources/application.properties` geändert werden.

Der aktuelle Web-Endpunkt `/` ist eine Statusmeldung und noch keine Pflanzenübersicht.

## Verwendete Technologien

- Java 25
- Spring Boot 4.1.2 (`spring-boot-starter-webmvc`)
- JavaFX 25.0.5 (`javafx-controls`, `javafx-fxml`)
- Maven Wrapper (`mvnw`, `mvnw.cmd`)

## Dependency Injection

Mit `@Service`, `@Component` oder `@RestController` annotierte Klassen werden von Spring verwaltet. Benötigte Services werden über den Konstruktor übergeben. Zum Beispiel:

```java
@Component
public class FXHauptController {

    private final HelloService helloService;

    public FXHauptController(HelloService helloService) {
        this.helloService = helloService;
    }
}
```

Der `FXMLLoader` verwendet die Spring-Bean-Verwaltung für FXML-Controller:

```java
loader.setControllerFactory(springContext::getBean);
```

## Bekannte Eigenheiten

- Die Anwendung über `javafx:run` starten, nicht über IntelliJ «Run». Sonst fehlt der JavaFX-Module-Path und Java meldet, dass die JavaFX-Runtime-Komponenten fehlen.
- Eine Spring-Whitelabel-Seite oder ein 404 bei nicht eingerichteten Browserpfaden ist im Grundgerüst erwartbar.
- Der `HelloService` und der Web-Endpunkt sind Beispiele und noch keine Pflanzenverwaltung.

## Projektunterlagen

- [Produktvision und Projektübersicht](docs/Pflanzen-App_Projektuebersicht-Vision.pdf)
- [Technische Anforderungen](docs/Pflanzen-App_TechnischeAnforderungen.pdf)
- [Diagramme zur Produktvision](docs/diagramme/Produktvision/README.md)
- [Diagramme zum technischen Dokument](<docs/diagramme/Technisches Dokument/README_Diagrammdateien.md>)
