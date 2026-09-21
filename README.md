# HolaYo — Laboratorios 1 y 2

Aplicación Android en Kotlin desarrollada para los laboratorios 1 y 2 de Aplicaciones Móviles. Parte de un perfil personal y suma una segunda pantalla para explorar la navegación y el ciclo de vida de una Activity.

## Qué hace

- Muestra el nombre y un dato personal.
- Permite cambiar el saludo con un botón.
- Usa una `data class Perfil` con campos opcionales para apodo y comida favorita.
- Abre una segunda pantalla mediante un Intent explícito y le pasa el nombre.
- Permite compartir el perfil con otras aplicaciones mediante un Intent implícito.
- Registra los eventos del ciclo de vida de ambas pantallas en Logcat con la etiqueta `VIDA`.
- Incluye un contador y un campo de notas en la segunda pantalla. El contador se conserva al recrearse la Activity mediante `onSaveInstanceState`.
- Guarda los textos de la interfaz en `strings.xml`.

## Tecnologías

Kotlin, Android Views (XML), Android Studio y Gradle. La versión mínima de Android es API 26.

## Cómo ejecutarlo

1. Abrí la carpeta `HolaYo` en Android Studio.
2. Esperá a que termine la sincronización de Gradle.
3. Elegí un emulador o un teléfono Android conectado.
4. Presioná **Run** (▶) para instalar y abrir la aplicación.

## Archivos principales

- `app/src/main/java/com/example/holayo/MainActivity.kt`: perfil y comportamiento de la pantalla.
- `app/src/main/java/com/example/holayo/SegundaActivity.kt`: segunda pantalla, contador y ciclo de vida.
- `app/src/main/res/layout/`: diseños de ambas pantallas.
- `app/src/main/res/values/strings.xml`: textos de la aplicación.
