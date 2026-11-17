# Grafiken zur Projektübersicht

Dieses Paket enthält die Grafiken der Projektübersicht Version 1.3 als PNG und bearbeitbare Mermaid-Quellen. Die Inhalte wurden mit der TechSpec v0.4 abgeglichen. Das Word-Dokument selbst wurde nicht verändert.

**Wichtig zur Nummerierung:** Die Dokumente nummerieren ihre Abbildungen unabhängig voneinander. Der Prüfungsablauf ist in der Projektübersicht Abbildung 2, in der TechSpec Abbildung 1. Es ist derselbe Ablauf und wird deshalb hier mit einer gemeinsamen PNG- und MMD-Quelle geführt.

| Projektübersicht | Entsprechung in der TechSpec | PNG | Mermaid-Quelle | Anpassung / Einfügeort |
|---|---|---|---|---|
| Abbildung 1 | Strategisches Zielbild; keine direkte Entsprechung | `exports/projektuebersicht_abbildung_01_strategische_zielarchitektur.png` | `projektuebersicht_abbildung_01_strategische_zielarchitektur.mmd` | Abschnitt «Strategische Zielarchitektur». Inhaltlich stimmig; Farben und Kennzeichnung der Stufen vereinheitlicht. |
| Abbildung 2 | Abbildung 1: Prüfungsablauf | `exports/gemeinsam_pruefungsablauf_techspec_abbildung_01.png` | `gemeinsam_pruefungsablauf_techspec_abbildung_01.mmd` | Abschnitt «Prüfungsumfang: Was wird umgesetzt?». Gemeinsame Quelle verwenden, nicht zwei separate Fassungen pflegen. Die Temperaturbewertung ist im JavaFX-Prüfschritt sichtbar. |
| Abbildung 3 | Keine direkte Entsprechung; ergänzt die technische Sicht | `exports/projektuebersicht_abbildung_03_pruefungsarchitektur.png` | `projektuebersicht_abbildung_03_pruefungsarchitektur.mmd` | Abschnitt «Technische Architektur der Prüfungsumsetzung und spätere Ablösung». JavaFX ruft direkt den `BestandService` auf; die Web-Seite nutzt lesende GET-Endpunkte. Repository-Namen und JSON-Dateien entsprechen der TechSpec. |

Die Diagramme verwenden das Dokumentgrün `#EAF1DD` und die Rahmenfarbe `#4F6228`. Für den gemeinsamen Prüfungsablauf stammt die Quelle direkt aus dem Diagrammordner der TechSpec. Bei einem neuen Rendern können Mermaids automatische Layoutregeln die Darstellung leicht verändern.
