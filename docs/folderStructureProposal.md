# Leafuno – Vorschlag zur Repository-Struktur

## Zweck und Verbindlichkeit

Diese Übersicht erklärt die Pakete und Beispielnamen für den schrittweisen Ausbau des Leafuno-Grundgerüsts. Die englischen Paket-, Klassen- und Dateinamen sind Vorschläge, bis sie im Quellcode umgesetzt sind. Der Quellcode beschreibt den tatsächlich implementierten Stand; die TechSpec bleibt massgeblich für Anforderungen und Architekturgrenzen.

Code-Bezeichner sind Englisch. Sichtbare Texte der ersten App-Version sind Deutsch. Eine spätere Übersetzung der Oberfläche soll möglich bleiben.

Das Repository bleibt für die Modularbeit ein einzelnes Maven-Projekt. JavaFX und Spring Boot laufen in einem Prozess. JavaFX nimmt Änderungen entgegen; die Webansicht ist im Prüfungsumfang lesend. Beide Oberflächen verwenden dieselben Anwendungsfälle und Fachregeln.

## 1. Aktueller Stand im Repository

Die folgenden Dateien liegen bereits im Repository. Als Platzhalter markierte Klassen enthalten noch keine Pflanzenfunktionen.

```text
leafuno/
├─ README.md
├─ mvnw / mvnw.cmd
├─ pom.xml
├─ docs/
│  ├─ Leafuno_Kurzfassung.docx
│  ├─ Leafuno_Projektuebersicht-Vision.docx
│  ├─ Leafuno_TechnischeAnforderungen.docx
│  ├─ folderStructureProposal.md
│  └─ images/
│     ├─ README.md
│     ├─ ProductVision/
│     ├─ ProjectOverview/
│     └─ TechnicalSpecification/
└─ src/
   ├─ main/
   │  ├─ java/com/duenasworld/leafuno/
   │  │  ├─ app/
   │  │  │  ├─ LeafunoApplication.java
   │  │  │  └─ FxApplication.java
   │  │  ├─ application/HelloService.java       # Beispiel-/Platzhalterdienst
   │  │  ├─ infrastructure/
   │  │  │  ├─ web/PlantReadController.java    # Web-Platzhalter
   │  │  │  └─ persistence/
   │  │  │     ├─ JsonPlantRepository.java     # Grundgerüst
   │  │  │     └─ JsonFileStore.java           # Grundgerüst
   │  │  └─ presentation/fx/FxMainController.java
   │  └─ resources/
   │     ├─ application.properties
   │     ├─ data/plant-species-seed.json
   │     ├─ fxml/plant-view.fxml
   │     └─ static/
   │        ├─ index.html
   │        ├─ css/style.css
   │        └─ js/app.js
   └─ test/java/com/duenasworld/leafuno/app/
      └─ LeafunoApplicationTests.java
```

Der Spring-Komponentenscan beginnt beim Basispaket `com.duenasworld.leafuno`, damit Spring Klassen in den Unterpaketen findet. Das Fachmodell, der eigentliche Anwendungsdienst und die Pflanzenfunktionen kommen beim Ausbau hinzu.

## 2. Zielstruktur und mögliche Klassennamen

Die folgende Struktur zeigt, wo Dateien voraussichtlich hingehören. Sie ist keine Aufforderung, alle Pakete und Klassen leer anzulegen: Erst wenn ihr eine Funktion umsetzt, braucht ihr die dazugehörigen Dateien.

```text
src/main/java/com/duenasworld/leafuno/
├─ app/
│  ├─ LeafunoApplication.java
│  └─ FxApplication.java
├─ application/
│  ├─ InventoryService.java
│  ├─ PlantRepository.java
│  ├─ dto/
│  │  ├─ PlantDto.java
│  │  ├─ LocationDto.java
│  │  ├─ AssessmentDto.java
│  │  ├─ WateringHintDto.java
│  │  └─ ErrorDto.java
│  └─ input/
│     ├─ PlantCreateInput.java
│     ├─ PlantUpdateInput.java
│     └─ LocationInput.java
├─ domain/
│  ├─ model/
│  │  ├─ Plant.java
│  │  ├─ PlantSpecies.java
│  │  ├─ Location.java
│  │  ├─ LightAssessment.java
│  │  ├─ TemperatureAssessment.java
│  │  ├─ LightLevel.java
│  │  ├─ TemperatureLevel.java
│  │  └─ Suitability.java
│  ├─ rules/WateringRule.java
│  ├─ validation/
│  │  ├─ PlantValidator.java
│  │  └─ LocationValidator.java
│  └─ exception/
│     ├─ LeafunoException.java
│     ├─ ValidationException.java
│     ├─ ConflictException.java
│     └─ NotFoundException.java
├─ infrastructure/
│  ├─ web/
│  │  ├─ PlantReadController.java
│  │  └─ WebErrorHandler.java
│  └─ persistence/
│     ├─ JsonPlantRepository.java
│     ├─ JsonFileStore.java
│     ├─ SampleData.java
│     └─ StorageException.java
└─ presentation/fx/
   ├─ FxMainController.java
   └─ dialog/
      ├─ PlantDialog.java
      └─ LocationDialog.java
```

### `app` – Start und Lebenszyklus

- `LeafunoApplication` enthält `main()` und startet JavaFX.
- `FxApplication` startet Spring beim Programmstart, zeigt das JavaFX-Fenster und beendet Spring beim Schliessen. Dadurch laufen Desktop-Oberfläche und Webserver im selben Prozess.

### `application` – Anwendungsfälle und Übergabeobjekte

- `InventoryService` führt Anwendungsfälle aus, etwa Pflanzen erfassen, ändern, löschen oder Giessen bestätigen. Er verbindet die Oberflächen mit Fachregeln und Speicherzugriff.
- `PlantRepository` ist eine Schnittstelle, welche die benötigten Lade- und Speicherfunktionen beschreibt. Der Dienst muss dadurch keine JSON-Dateien direkt bearbeiten.
- `dto` enthält Ausgabeobjekte für JavaFX und Web, etwa `PlantDto` oder `WateringHintDto`. Sie transportieren Daten und enthalten möglichst keine Fachregeln.
- `input` enthält strukturierte Eingaben für Anwendungsfälle. `PlantCreateInput` beschreibt zum Beispiel die Angaben für eine neue Pflanze.

### `domain` – Fachwissen ohne UI und Speichertechnik

- `model` enthält die Fachbegriffe: `Plant` ist ein konkretes Exemplar, `PlantSpecies` beschreibt eine Pflanzenart, `Location` einen Standort. Bewertungen und Enum-Werte wie `LightAssessment`, `TemperatureAssessment`, `LightLevel` und `Suitability` gehören ebenfalls zum Fachmodell.
- `rules` enthält Berechnungen und Regeln. `WateringRule` berechnet beispielsweise das Giessintervall anhand des Grundintervalls und der Standortfaktoren.
- `validation` enthält fachliche Eingabeprüfungen, wenn diese umfangreicher werden. Bei wenigen einfachen Prüfungen muss nicht sofort eine eigene Validator-Klasse entstehen.
- `exception` enthält fachliche Fehler wie ungültige Eingaben, Konflikte oder nicht gefundene Einträge.

Das `domain` kennt weder JavaFX noch Spring Boot, HTTP oder JSON. Dadurch lassen sich die Fachregeln unabhängig von der Oberfläche und Speicherung testen.

### `infrastructure` – technische Anbindung

- `web` nimmt Browseranfragen entgegen. `PlantReadController` stellt im Prüfungsumfang lesende Endpunkte bereit. `WebErrorHandler` kann Fehler in passende HTTP-Antworten übersetzen.
- `persistence` setzt den Speicherzugriff technisch um. `JsonPlantRepository` implementiert `PlantRepository`; `JsonFileStore` liest und schreibt Dateien; `SampleData` kann den Startbestand bereitstellen. `StorageException` beschreibt technische Speicherfehler.

Persönliche JSON-Dateien liegen später im Benutzerverzeichnis. Der mitgelieferte Artenkatalog unter `resources/data` ist eine Vorlage. Daten gehören nicht in `resources/static`, denn dieser Ordner wird vom Webserver öffentlich ausgeliefert.

### `presentation/fx` – JavaFX-Oberfläche

- `FxMainController` verbindet JavaFX-Ansichten mit `InventoryService`. Er nimmt UI-Ereignisse entgegen und zeigt Ergebnisse an; fachliche Berechnungen gehören in `domain` oder `application`.
- `dialog` kann grössere Dialoge wie `PlantDialog` oder `LocationDialog` enthalten. Bei wenigen Dialogen ist dieses Unterpaket zunächst nicht nötig.

Die FXML-Dateien liegen unter `src/main/resources/fxml`. Die Browserdateien liegen getrennt unter `src/main/resources/static`.

## 3. Ressourcen, Tests und Dokumente

### Ressourcen

```text
src/main/resources/
├─ application.properties          # Einstellungen, z. B. Webserver-Port
├─ data/plant-species-seed.json    # mitgelieferter Startkatalog
├─ fxml/                           # JavaFX-Ansichten
└─ static/                         # öffentlich lesbare Webdateien
   ├─ index.html
   ├─ css/style.css
   └─ js/app.js
```

### Tests

Tests folgen nach Möglichkeit der Quellcode-Struktur. Dadurch ist zum Beispiel der Test für `WateringRule` unter `domain`, der Test für `JsonFileStore` unter `infrastructure/persistence` und der Test für `PlantReadController` unter `infrastructure/web` zu finden.

```text
src/test/java/com/duenasworld/leafuno/
├─ application/
│  ├─ InventoryServiceTest.java
│  └─ RestartPersistenceTest.java
├─ domain/
│  ├─ rules/WateringRuleTest.java
│  ├─ model/LightAssessmentTest.java
│  ├─ model/TemperatureAssessmentTest.java
│  └─ validation/ValidationTest.java
├─ infrastructure/
│  ├─ persistence/JsonFileStoreTest.java
│  ├─ persistence/JsonPlantRepositoryTest.java
│  └─ web/PlantReadControllerTest.java
└─ integration/ParallelAccessTest.java
```

Das sind Beispiele. Welche Tests nötig sind, richtet sich nach Anforderungen und umgesetzten Funktionen.

### Projektunterlagen

Alle aktuellen Projektunterlagen und Abbildungen liegen im [Ordner docs/](./). Die Übersicht führt die Dateien bewusst nicht einzeln auf, damit neu hinzugefügte Dokumente automatisch mit umfasst sind.

## 4. Web-Platzhalter und spätere Startseite

`index.html`, `app.js` und `style.css` sind im Grundgerüst Platzhalter. Beim Ausbau soll Spring Boot `index.html` unter `/` ausliefern; lesende Pflanzen-Endpunkte erhalten eigene `/api/...`-Pfade. Der aktuelle `PlantReadController` belegt `/` noch mit einer Statusmeldung. Beim Ausbau muss diese Platzhalterroute entfernt oder auf einen eigenen Statuspfad verschoben werden.

## 5. Was ist festgelegt, was bleibt Umsetzungsspielraum?

**Architekturgrenzen:** Beide Oberflächen verwenden gemeinsame Anwendungsfälle. Fachregeln liegen im `domain`; JSON-Zugriff liegt hinter `PlantRepository`; Web und JavaFX bleiben getrennte Zugänge; persönliche Daten werden nicht öffentlich ausgeliefert.

**Beispielnamen:** Die genannten Klassen und Dateien sind Vorschläge, keine zusätzlichen Anforderungen. Wenn ihr bei der Umsetzung andere englische Namen wählt, aktualisiert ihr diese Übersicht, README, TechSpec und Diagramme passend. Sichtbare App-Texte bleiben Deutsch.

Die Aufteilung in mehrere Maven-Projekte oder getrennte Anwendungen ist für die Modularbeit nicht nötig. Beginnt mit den tatsächlich benötigten Klassen und ergänzt Unterpakete, sobald sie die Orientierung erleichtern.
