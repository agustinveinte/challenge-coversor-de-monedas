# 💱 Conversor de Monedas - Java Console App

Esta es una aplicación de consola escrita en Java que permite realizar conversiones de monedas utilizando la API pública de [ExchangeRate API](https://www.exchangerate-api.com/).

## ✨ Características

- 🔁 Conversión entre monedas comunes:
  - 🇺🇸 USD ↔ 🇦🇷 ARS (Peso argentino)
  - 🇺🇸 USD ↔ 🇧🇷 BRL (Real brasileño)
  - 🇺🇸 USD ↔ 🇨🇴 COP (Peso colombiano)
- 📟 Menú interactivo en consola
- ⚠️ Manejo básico de errores
- 🔧 Modularidad para extender más conversiones

## 🧰 Requisitos

- ☕ Java 8 o superior
- 🌐 Conexión a internet
- 🔑 Una clave de API de [ExchangeRate API](https://www.exchangerate-api.com/)

## 🛠️ Instalación

1. Clona este repositorio o descarga el código fuente:

```bash
git clone https://github.com/tuusuario/conversor-monedas-java.git
cd conversor-monedas-java
```

2. Agrega tu clave de API:

Edita el archivo `ConversorAPP.java` y reemplaza el valor de `API_KEY` con tu clave personal:

```java
private final String API_KEY = "TU_API_KEY_AQUI";
```

3. Compila el proyecto:

```bash
javac ConversorAPP.java
```

4. Ejecuta la aplicación:

```bash
java ConversorAPP
```

## ▶️ Uso

Al ejecutar la aplicación, se mostrará un menú con las distintas conversiones disponibles. Selecciona una opción y luego ingresa el monto a convertir.

📋 Ejemplo del menú:

```
1. USD a ARS
2. ARS a USD
3. USD a BRL
4. BRL a USD
5. USD a COP
6. COP a USD
7. Salir
```
## 🙌 Créditos

- API proporcionada por [ExchangeRate API](https://www.exchangerate-api.com/)
- Proyecto desarrollado con fines de aprendizaje

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Puedes usarlo, modificarlo y distribuirlo libremente.
