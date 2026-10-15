# Duplicate File Finder & Cleaner

A Java command-line application that scans directories recursively and identifies duplicate files by comparing their SHA-256 content hashes. It allows users to review duplicate groups, select which file to keep, optionally delete the remaining copies, and generate a report of the results.

## Features

- **Recursive directory scanning:** Finds regular files within the selected directory and its subdirectories.
- **SHA-256 hashing:** Identifies files with identical content, regardless of their filenames.
- **Duplicate grouping:** Groups files that have matching content hashes.
- **Interactive file selection:** Lets users choose which file to keep from each duplicate group.
- **Optional deletion:** Requests confirmation before attempting to delete the other copies.
- **Deletion tracking:** Records which files were successfully deleted.
- **Duplicate report:** Generates `duplicates_report.txt` with duplicate groups, the selected files, and deletion results.
- **Input validation:** Handles invalid menu selections and skips files that cannot be hashed.
- **Memory-efficient hashing:** Processes file contents in chunks instead of loading each entire file into memory.

## Technology Stack

- **Language:** Java 17
- **Build Tool:** Apache Maven
- **Hashing Algorithm:** SHA-256
- **Testing Framework:** JUnit 5
- **File Operations:** Java NIO (`java.nio.file`)
- **Version Control:** Git

## Prerequisites

Before running this application, ensure you have installed:

- **JDK 17 or later**
- **Apache Maven 3.9 or later**
- **Git** (optional, if you want to clone the repository)


## Installation and Setup

### 1. Clone the repository

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
cd duplicate-finder
```

Replace `<YOUR_GITHUB_REPOSITORY_URL>` with your repository's actual Git URL.

### 2. Build the project

```bash
mvn clean package
```

### 3. Run the tests

```bash
mvn test
```

### 4. Run the application

Open the project in IntelliJ IDEA and run `Main.java` from the `com.anton.dupfinder` package.

When prompted, enter the absolute path of the directory you want to scan.

The application will scan the directory, group duplicate files, let you choose which files to keep, and ask for confirmation before attempting deletion.

## Usage Example

1. Start the application.
2. Enter the directory path you want to scan.
3. Review the duplicate file groups displayed by the application.
4. Select the file you want to keep in each group.
5. Confirm or cancel deletion of the remaining copies.
6. Review `duplicates_report.txt` in the working directory for the results.

**Note:** Review the selected files carefully before confirming deletion. The application attempts to permanently delete the other files in each duplicate group.

**Warning:** Files selected for deletion are permanently deleted and are not moved to the Recycle Bin. Carefully review the selected files before confirming deletion.

