# Leafuno

Leafuno ist eine geplante Anwendung zur Pflege von Zimmerpflanzen. Sie soll Pflanzen und Standorte verwalten, den Pflegebedarf verständlich anzeigen und beim Giessen und Düngen unterstützen. Für die Zukunft sind unter anderem eine Pflegehistorie, Hinweise zur Standortwahl, Unterstützung bei Pflanzenproblemen und die gemeinsame Nutzung im Haushalt vorgesehen. Details der Produktvision können unter docs eingesehen werden.

## Projektstand

Dieses Repository enthält das technische Grundgerüst für die geplante Anwendung und die CAS-OOP-Modularbeit. Die eigentlichen Pflanzenfunktionen sind noch nicht umgesetzt. Die JavaFX-Oberfläche zeigt derzeit eine Begrüssung des `HelloService`. Der Spring-Boot-Endpunkt `GET /` antwortet mit einer einfachen Statusmeldung.

Diese README beschreibt den aktuellen Stand im Repository. Technische Namen in der TechSpec und in den Abbildungen sind Beispiele, sofern sie nicht ausdrücklich als verbindlich bezeichnet sind; für den tatsächlich implementierten Stand ist der Quellcode massgeblich.

Die Projektübersicht beschreibt die langfristige Produktvision. Die technische Spezifikation grenzt davon den kleineren Prüfungsumfang ab. Für die Modularbeit sind Pflanzen- und Standortverwaltung, Licht- und Temperaturbewertungen, die Berechnung der Giessfälligkeit, lokale JSON-Dateien sowie eine lesende Webansicht vorgesehen. Eine Datenbank und externe Dienste gehören nicht zum Prüfungsumfang.

## Architektur des Grundgerüsts

JavaFX und Spring Boot laufen gemeinsam in einem Java-Prozess. Der Start erfolgt über `javafx:run`:

```text
LeafunoApplication.main()   Einstiegspunkt; startet JavaFX
└─ FxApplication
   ├─ init()                 startet Spring und dessen Beans
   ├─ start()                lädt plant-view.fxml und zeigt das Fenster
   └─ stop()                 schliesst den Spring-Kontext und Webserver
```

### Klassen im Überblick

| Klasse | Aufgabe im Grundgerüst |
|---|---|
| `LeafunoApplication` | Einstiegspunkt mit `main`; startet JavaFX und trägt `@SpringBootApplication`. |
| `FxApplication` | Steuert den JavaFX-Lebenszyklus, startet und beendet Spring und lädt die FXML-Oberfläche. |
| `FxMainController` | Verbindet die FXML-Oberfläche mit dem `HelloService`. |
| `HelloService` | Beispiel-Service; gibt derzeit eine Begrüssung zurück. |
| `PlantReadController` | Vorläufiger REST-Controller. `GET /` liefert momentan eine Statusmeldung; die lesenden Pflanzen-Endpunkte sind noch nicht umgesetzt. |
| `JsonPlantRepository`, `JsonFileStore` | Vorbereitete Klassen für die JSON-Speicherung; die vollständigen Pflanzenabläufe sind noch nicht implementiert. |

### Projektstruktur

```text
src/main/java/com/duenasworld/leafuno/
├─ app/                         Einstiegspunkt und JavaFX-Lebenszyklus
├─ application/                 gemeinsame Anwendungsdienste
├─ infrastructure/
│  ├─ web/                      HTTP-Zugang und Web-Controller
│  └─ persistence/              JSON-Speicherung
└─ presentation/fx/              JavaFX-Oberfläche

src/main/resources/
├─ data/plant-species-seed.json  mitgelieferter Startkatalog
├─ fxml/plant-view.fxml          JavaFX-Ansicht
└─ static/                       HTML, CSS und JavaScript für den Browser

src/test/java/com/duenasworld/leafuno/app/
└─ LeafunoApplicationTests.java
```

Die Fachklassen und die eigentlichen Pflanzenabläufe sind noch nicht umgesetzt. Dafür werden beim Ausbau die Pakete `domain` und weitere Anwendungstests ergänzt. Der Web-Controller und die JSON-Klassen sind derzeit Platzhalter.
## Starten

Voraussetzung ist die im `pom.xml` festgelegte Java-Version. Der Maven Wrapper ist enthalten; Maven muss nicht separat installiert werden.

In IntelliJ über das Maven-Panel: `Leafuno → Plugins → javafx → javafx:run`.

Im Terminal:

```bash
# Windows
mvnw.cmd javafx:run

# macOS / Linux
./mvnw javafx:run
```

Es öffnet sich das Desktop-Fenster. Gleichzeitig startet der Spring-Webserver:

- Auf dem Entwicklungsrechner: <http://localhost:8080>
- Der Port kann in `src/main/resources/application.properties` geändert werden.

Der aktuelle Endpunkt `/` liefert eine Statusmeldung und noch keine Pflanzenübersicht.

## Verwendete Technologien

- Java 25
- Spring Boot 4.1.2 (`spring-boot-starter-webmvc`)
- JavaFX 25.0.5 (`javafx-controls`, `javafx-fxml`)
- Maven Wrapper (`mvnw`, `mvnw.cmd`)

## Dependency Injection

Mit `@Service`, `@Component` oder `@RestController` annotierte Klassen werden von Spring verwaltet. Abhängigkeiten werden über den Konstruktor übergeben. Im Grundgerüst erhält `FxMainController` so den `HelloService`. Java-Bezeichner sind englisch; die sichtbare Begrüssung bleibt deutsch:

```java
@Component
public class FxMainController {

    private final HelloService helloService;

    public FxMainController(HelloService helloService) {
        this.helloService = helloService;
    }
}
```

Der `FXMLLoader` verwendet Spring zur Erzeugung des FXML-Controllers:

```java
loader.setControllerFactory(springContext::getBean);
```

## Bekannte Eigenheiten

- Die Anwendung über `javafx:run` starten, nicht über IntelliJ «Run». Sonst kann der JavaFX-Module-Path fehlen.
- Die Startseite `/` zeigt derzeit eine Statusmeldung. Die Pflanzenübersicht und lesenden REST-Endpunkte werden später ergänzt.
- Der `HelloService` dient als Beispiel und enthält noch keine Pflanzenlogik.

## Projektunterlagen

Alle aktuellen Projektunterlagen und Abbildungen findest du im [Ordner docs/](docs/).
