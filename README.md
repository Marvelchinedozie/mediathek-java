# mediathek-java
A media library management system in Java with a Swing GUI, built for the course **Programmiermethodik 2 (PM2)** at HAW Hamburg (exercise sheet 02).

Staff can select a customer, choose one or more media items (CDs, DVDs, video games) and lend them out. Returns are handled in a separate view.

<img width="1437" height="899" alt="image" src="https://github.com/user-attachments/assets/11f745b8-88e4-41c9-adfc-25369723f790" />


## Features
- Customer list with customer details (number, name, phone, address)
- Media catalogue with type, title and availability
- Lend several media items to a customer at once
- Return view for borrowed media
- Unit tests for the core classes (e.g. `Kunde`, `Datum`, `VideoSpiel`, `KundenstammService`)

## Tech
Java · Swing · JUnit · Eclipse

## Run
1. Clone or download the repository.
2. Import it into Eclipse or IntelliJ as a Java project and add the JARs in `lib/` to the build path.
3. Run the main class in src/mediathek/StartUpMediathek_Blatt02.java.

*Based on a project template provided by the PM2 course at HAW Hamburg.*
