# Ex11
# Android Sensors App (Magnetometer, Temperature, Lux) with DataStore Preferences

This Android application—built using Kotlin, Jetpack Compose, and DataStore Preferences—displays real-time readings from the device’s magnetometer, ambient temperature, and light (lux) sensors.
It also allows users to change and save font style preferences (Default, Bold, Italic).

The app works on both:

Android Emulator (via Extended Controls → Sensors)

Physical devices with actual hardware sensors

# Features
Sensor Readings

Magnetometer — X, Y, Z axis magnetic field values

Ambient Temperature — Degrees Celsius (if supported)

Light Sensor — Illuminance in lux

# UI Customization with DataStore

Users can pick a font style:

Default

Bold

Italic

Selections are saved permanently using DataStore Preferences.

# Modern Android Development

100% Jetpack Compose UI

MVVM (ViewModel + StateFlow)

Coroutines for asynchronous sensor updates
