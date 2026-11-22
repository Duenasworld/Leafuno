# Leafuno

Leafuno ist eine geplante Anwendung zur Pflege von Zimmerpflanzen. Sie soll Pflanzen und Standorte verwalten, den Pflegebedarf verständlich anzeigen und beim Giessen und Düngen unterstützen. Für die Zukunft sind unter anderem eine Pflegehistorie, Hinweise zur Standortwahl, Unterstützung bei Pflanzenproblemen und die gemeinsame Nutzung im Haushalt vorgesehen. Details der Produktvision können unter docs eingesehen werden.

## Projektstand

Dieses Repository enthält das technische Grundgerüst für die geplante Anwendung und die CAS-OOP-Modularbeit. Die eigentlichen Pflanzenfunktionen sind noch nicht umgesetzt. Die JavaFX-Oberfläche zeigt derzeit eine Begrüssung des `HelloService`. Der Spring-Boot-Endpunkt `GET /` antwortet mit einer einfachen Statusmeldung.

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
| `WebLeseController` | Vorläufiger REST-Controller. `GET /` liefert momentan eine Statusmeldung; die lesenden Pflanzen-Endpunkte sind noch nicht umgesetzt. |
| `JsonPlantRepository`, `JsonFileStore` | Vorbereitete Klassen für die JSON-Speicherung; die vollständigen Pflanzenabläufe sind noch nicht implementiert. |

### Projektstruktur

```text
src/main/java/com/duenasworld/leafuno/
├─ LeafunoApplication.java
├─ app/                         JavaFX-Lebenszyklus
├─ application/                 Anwendungsdienste
├─ domain/                      Fachmodell, Regeln, Validierung, Ausnahmen
├─ infrastructure/persistence/json/  JSON-Speicherung
└─ presentation/
   ├─ fx/                       JavaFX-Oberfläche
   └─ web/                      Web-Controller, DTOs und Fehlerbehandlung

src/main/resources/
├─ data/plant-species-seed.json
├─ static/                      HTML, CSS und JavaScript
├─ view/fx/plant-view.fxml
└─ application.properties

docs/                           Projektunterlagen und Diagramme
```

Die Web-Controller-Klasse heisst im aktuellen Grundgerüst noch `WebLeseController`. In der technischen Zielstruktur ist der englische Name `PlantReadController` vorgesehen.

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

Mit `@Service`, `@Component` oder `@RestController` annotierte Klassen werden von Spring verwaltet. Abhängigkeiten werden über den Konstruktor übergeben. Im Grundgerüst erhält `FxMainController` so den `HelloService`:

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

- [Leafuno – Produktvision und Projektübersicht](docs/Pflanzen-App_Projektuebersicht-Vision.pdf)
- [Leafuno – Technische Anforderungen](docs/Pflanzen-App_TechnischeAnforderungen.pdf)
- [Diagramme zur Produktvision](docs/diagramme/Produktvision/README.md)
- [Diagramme zum technischen Dokument](<docs/diagramme/Technisches Dokument/README_Diagrammdateien.md>)
