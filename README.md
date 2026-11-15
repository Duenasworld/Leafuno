# PlantLove 🌱

Desktop-Anwendung mit **JavaFX** (Oberfläche) und **Spring Boot** (Backend),
die beide in einer Anwendung laufen.

## Architektur

Beim Start der Anwendung wird zuerst Spring gestartet. Anschliessend lädt JavaFX die Oberfläche und öffnet das Fenster. Beide laufen innerhalb derselben Anwendung. Beim Schliessen des Fensters wird Spring beendet.

```
javafx:run
 └─ PlantLoveApplication.main()        Einstiegspunkt, startet JavaFX
     └─ FxApplication                  Fenster-Regie
         ├─ init():  Spring starten   Server + alle Beans hochfahren
         ├─ start(): plant-view.fxml  Oberfläche laden (via FXMLLoader)
         └─ stop():  Spring beenden   sauberes Herunterfahren
```

### Die Klassen im Überblick

| Klasse | Rolle |
|---|---|
| `PlantLoveApplication` | Einstiegspunkt (`main`), startet JavaFX, `@SpringBootApplication` |
| `FxApplication` | JavaFX-Fenster; startet/stoppt Spring, lädt die FXML-Oberfläche |
| `MainController` | GUI-Controller der FXML-Datei, als `@Component` eine Spring-Bean |
| `HelloService` | Beispiel-Service (`@Service`) mit Geschäftslogik |
| `HelloController` | REST-Endpunkt (`@RestController`) für den Browser unter `localhost:8080` |

### Aufbau der Dateien

- `src/main/java/com/duenasworld/plantlove/…` – Java-Klassen
- `src/main/resources/view/plant-view.fxml` – Oberflächen-Layout
- `pom.xml` – Maven-Konfiguration (Abhängigkeiten, Plugins)

## Starten

Über das Maven-Panel in IntelliJ:
`PlantLove → Plugins → javafx → javafx:run`

Oder im Terminal:

```bash
./mvnw javafx:run
```

Es öffnet sich das Desktop-Fenster. Gleichzeitig läuft der
Spring-Server, erreichbar unter:

- Browser: <http://localhost:8080>
- Port konfigurierbar in `src/main/resources/application.properties`

## Verwendete Technologien

- Java 25
- Spring Boot 4.1.2 (`spring-boot-starter-webmvc`)
- JavaFX 25.0.5 (`javafx-controls`, `javafx-fxml`)
- Maven (Wrapper enthalten, `mvnw`)

## Dependency Injection im Überblick

Alle mit `@Service`, `@Component` oder `@RestController` annotierten
Klassen werden von Spring verwaltet. Controller erhalten benötigte
Services per Konstruktor – Beispiel:

```java
@Component
public class MainController {

    private final HelloService helloService;

    public MainController(HelloService helloService) {
        this.helloService = helloService;
    }
}
```

Der `FXMLLoader` wird in `FxApplication` so konfiguriert, dass
FXML-Controller ebenfalls als Spring-Beans erzeugt werden:

```java
loader.setControllerFactory(springContext::getBean);
```

## Bekannte Eigenheiten

- Start **nicht** über IntelliJ „Run", sondern über `javafx:run` –
  sonst fehlt der JavaFX-Module-Path (Fehler: „JavaFX runtime
  components are missing").
- Die Whitelabel-Seite im Browser bei unbekannten Pfaden ist normal
  (Spring-Fallback, Status 404), kein Fehler.