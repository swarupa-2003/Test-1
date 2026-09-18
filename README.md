# EcoWaste – Waste Collection Scheduler

## 👩‍🎓 Student Details

**Name:** Swarupa S  
**USN:** 25MCAR0137  
**Course:** MCA  
**Experiment:** Android Application Development  

---

## 📌 Project Title

**EcoWaste – Waste Collection Scheduler**

---

## 🎯 Aim

To develop an Android application that allows residents to schedule waste collection requests by entering their details, selecting the type of waste, choosing collection priority, and enabling doorstep pickup.

---

## 📖 Introduction

EcoWaste is an Android-based waste collection scheduling application designed to make waste collection more convenient and organized.

The application provides a simple interface where users can enter their name and address, select the type of waste they want to dispose of, choose the collection priority, and enable doorstep pickup.

After submitting the request, the application displays a confirmation screen with the entered information.

---

## 🛠️ Technologies Used

- Android Studio
- Java
- XML
- Android SDK
- Android Emulator / Physical Android Device
- GitHub

---

## 🧩 Components Used

The following Android components are used in the project:

- Activity
- Fragment
- Intent
- TextView
- EditText
- Button
- RadioButton
- RadioGroup
- ToggleButton
- Toast / Notification
- Logcat

---

## 🏗️ Application Features

### 1. Dashboard

The dashboard provides access to the main features of the application.

Options include:

- Schedule Collection
- Collection Guidelines
- Previous Requests

### 2. Schedule Collection

The user can enter:

- Resident Name
- Address
- Waste Type
- Collection Priority
- Doorstep Pickup preference

### 3. Waste Type Selection

The application provides different waste categories:

- Organic
- Recyclable
- Electronic
- General Waste

### 4. Collection Priority

The user can select:

- Normal
- Urgent

### 5. Doorstep Pickup

A toggle button allows the user to enable or disable doorstep pickup.

### 6. Confirmation

After submitting the form, the application displays a confirmation screen containing the selected information.

### 7. Notification

A notification can be displayed after successfully scheduling a collection request.

### 8. Activity Lifecycle

Android Activity lifecycle methods can be observed through Logcat, including:

- `onCreate()`
- `onStart()`
- `onResume()`
- `onPause()`
- `onStop()`
- `onDestroy()`

---

## 📂 Project Structure

```text
EcoWaste/
│
├── app/
│   └── src/
│       └── main/
│           │
│           ├── java/
│           │   └── com.example.ecowaste/
│           │       ├── MainActivity.java
│           │       ├── ScheduleCollectionFragment.java
│           │       └── CollectionConfirmationActivity.java
│           │
│           ├── res/
│           │   ├── layout/
│           │   │   ├── activity_main.xml
│           │   │   ├── fragment_schedule_collection.xml
│           │   │   └── activity_collection_confirmation.xml
│           │   │
│           │   ├── drawable/
│           │   │
│           │   └── values/
│           │       ├── colors.xml
│           │       ├── strings.xml
│           │       └── themes.xml
│           │
│           └── AndroidManifest.xml
│
├── build.gradle
├── settings.gradle
└── README.md

### 8. Screenshot output

<img width="1797" height="942" alt="2" src="https://github.com/user-attachments/assets/aefe35ee-8013-49a4-9316-d15567c20dc5" />
<img width="1807" height="912" alt="1" src="https://github.com/user-attachments/assets/de99a5a4-6207-45eb-af88-8f60af52a63c" />
