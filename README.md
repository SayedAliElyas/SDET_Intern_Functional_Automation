# SDET Intern Functional Automation - Task #1

## 📌 Overview
This project contains an automated UI test built using the JetBrains IDE Starter framework.

The test launches IntelliJ IDEA, opens the Settings dialog, navigates to:
**Version Control → Changelists**, selects the checkbox
**"Create changelists automatically"**, and verifies that it is selected.

---

## 🧪 Test Scenario

The automated test performs the following steps:

1. Launches IntelliJ IDEA
2. Opens a public GitHub project
3. Opens **Settings**
4. Navigates to:
   - Version Control → Changelists
5. Selects the checkbox:
   - "Create changelists automatically"
6. Verifies that the checkbox is selected
7. Clicks **OK** button

---

## 🛠️ Technologies Used

- Kotlin
- JUnit 5
- JetBrains IDE Starter Framework
- IntelliJ Driver SDK

---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/SayedAliElyas/SDET_Intern_Functional_Automation.git
   
2. Open the project in IntelliJ IDEA
3. Wait for Gradle to sync
4. Navigate to: src/test/kotlin
5. Open TickSettingBox
6. Click the run icon

## ⚠️ Notes

- This project uses `LATEST-EAP-SNAPSHOT` dependencies for compatibility with the JetBrains IDE Starter framework.
- The IDE may open, close, and reopen during execution. This is expected behavior during project preparation and test execution.
- The first run may take a few minutes to download dependencies and set up the IDE environment.
