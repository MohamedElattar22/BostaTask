# 📦 Bosta Task - Delivery Area Selection

## 📌 Project Overview
Bosta Task is a Kotlin Android application that allows users to **select a delivery area** from a list of cities and districts. The app provides a **searchable and expandable list** where users can filter districts by name, with matching search terms highlighted for better visibility. The UI is implemented using **Jetpack Compose**, following the **MVI architecture**, and using **Hilt for dependency injection**.

## ✨ Features
- **Searchable Delivery Areas**: Users can search for cities and districts dynamically.
- **Auto-Expanding Sections**: Cities expand automatically when a district within them matches the search query.
- **Highlighted Search Terms**: Matching text in districts is displayed in a different color.
- **Bottom Sheet UI**: The delivery area selection is implemented using a **Modal Bottom Sheet**.
- **Optimized UI Performance**: Efficient recomposition handling and lazy lists for smooth performance.
- **MVI Pattern**: Ensures better state management and separation of concerns.

## 🏛️ Architecture
The project follows **MVI (Model-View-Intent) architecture** for better state handling and UI updates. The main layers include:

### **1. UI Layer (Jetpack Compose)**
- **`PickAreaScreen.kt`**: Main composable that opens the area selection bottom sheet.
- **`DeliveryAreaBottomSheetComposable.kt`**: Bottom sheet displaying city and district lists.
- **`AreaListItem.kt`**: Displays a city and its districts, expanding based on search results.
- **`SubAreaItem.kt`**: Shows individual district names, highlighting search matches.

### **2. ViewModel Layer**
- **`CitiesViewModel.kt`**: Handles UI state and processes user actions.
- **`CitiesContract.kt`**: Defines UI states (`CitiesState`), user intents (`CitiesActions`), and UI events (`CitiesEvents`).

### **3. Data Layer**
- **`City.kt` & `District.kt`**: Data models for cities and districts.
- **`CitiesRepository.kt`**: Provides a list of cities and their districts.

## 🛠️ Tech Stack
| Technology | Purpose |
|------------|---------|
| **Kotlin** | Main programming language |
| **Jetpack Compose** | Modern UI toolkit for building declarative UIs |
| **Material 3** | UI components and theming |
| **Hilt (Dagger)** | Dependency Injection |
| **Room Database (Future Expansion)** | Persistent data storage |
| **Coroutines & Flow** | Asynchronous programming |
| **Jetpack Navigation** | Managing app screens |

## 🚀 Getting Started
### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/yourusername/bosta-task.git
cd bosta-task
```

### **2️⃣ Open in Android Studio**
- Open **Android Studio** (latest version recommended).
- Select **File → Open** and choose the project folder.

### **3️⃣ Build & Run**
- Click **Run ▶️** in Android Studio to install and launch the app.

## 📂 Project Structure
```
📦 BostaTask
 ┣ 📂 domain
 ┃ ┣ 📂 models
 ┃ ┃ ┣ City.kt
 ┃ ┃ ┣ District.kt
 ┣ 📂 data
 ┃ ┣ CitiesRepository.kt
 ┣ 📂 presentation
 ┃ ┣ 📂 composables
 ┃ ┃ ┣ PickAreaScreen.kt
 ┃ ┃ ┣ DeliveryAreaBottomSheetComposable.kt
 ┃ ┃ ┣ AreaListItem.kt
 ┃ ┃ ┣ SubAreaItem.kt
 ┃ ┣ 📂 viewmodel
 ┃ ┃ ┣ CitiesViewModel.kt
 ┃ ┃ ┣ CitiesContract.kt
 ┣ 📂 ui
 ┃ ┣ theme/
 ┃ ┣ BostaTaskTheme.kt
 ┣ AndroidManifest.xml
 ┣ build.gradle.kts
 ┗ README.md
```

## 📌 Future Improvements
- ✅ **Persist selected areas** in Room Database.
- ✅ **Support multi-language** (Arabic/English).
- ✅ **Improve performance** for large city lists.

## 🤝 Contribution
Contributions are welcome! Feel free to submit a PR or open an issue.

## 📜 License
This project is licensed under the MIT License.

