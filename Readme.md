# 📚 Library Management System (Console Application)

## 📌 Opis projektu

Aplikacja konsolowa do zarządzania biblioteką, napisana w **Javie** z wykorzystaniem **Spring (Dependency Injection)**.
Projekt symuluje system biblioteczny z obsługą **logowania**, **ról użytkowników** oraz **uprawnień**, bez użycia bazy danych.

---

## 🔐 Logowanie i role

System obsługuje dwa typy kont:

### 👤 USER

- wypożycznie książek
- przeglądanie listy książek
- wyszukiwanie książek:

  - po autorze
  - po tytule

### 👑 ADMIN

- dodawanie nowej książki
- usuwanie książki
- edytowanie istniejącej książki
- wszystkie uprawnienia użytkownika **USER**

Uprawnienia są realizowane poprzez:

- role (`Role`)
- operacje (`Operation`)
- serwis uprawnień (`PermissionService`)

---

## 🗃️ Dane

- Wszystkie dane (użytkownicy, książki) przechowywane są **w pamięci**:

  - `List<User>`
  - `List<Book>`

---

## 🔒 Bezpieczeństwo

- Hasła użytkowników są **hashowane** (BCrypt)
- Aplikacja **nigdy nie przechowuje haseł w postaci jawnej**
- Logowanie odbywa się poprzez porównanie hasła z zapisanym hashem

---

### Warstwy aplikacji:

- **GUI** – obsługa wejścia i wyjścia (konsola)
- **Core** – logika sterująca aplikacją
- **Services** – logika biznesowa (użytkownicy, uprawnienia, hasła)
- **Repositories** – dostęp do danych (in-memory)
- **Model** – encje domenowe

---

## 🛠️ Technologie

- **Java 21**
- **Spring (Context, DI)**
- **Maven**
- **Lombok**
- **BCrypt (spring-security-crypto)**

---

## 📂 Struktura projektu

```
pl.wszib.java.advanced
├── App.java
├── authentication
├── configuration
│   └── AppConfiguration.java
├── core
│   ├── Core.java
│   └── ICore.java
├── database
│   ├── BookRepository.java
│   ├── IBookRepository.java
│   ├── IUserRepository.java
│   └── UserRepository.java
├── exceptions
│   └── CanNotBorrowBookException.java
├── gui
│   ├── GUI.java
│   ├── IGUI.java
│   └── Menu.java
├── model
│   ├── Book.java
│   ├── operation
│   │   └── Operation.java
│   ├── Role.java
│   └── User.java
├── security
│   └── RolePermissions.java
└── services
    ├── auth
    │   ├── AuthService.java
    │   └── IAuthService.java
    ├── password
    │   ├── IPasswordService.java
    │   └── PasswordService.java
    ├── permission
    │   ├── IPermissionService.java
    │   └── PermissionService.java
    └── user
        ├── IUserService.java
        └── UserService.java
```

---

## ▶️ Uruchomienie

### Wymagania

- Java 21
- Maven 3.9+
- Git

1. Sklonuj repozytorium

```bash
git clone https://github.com/SaberLS/terminal-lib-manager.git
cd terminal-lib-manager
```

2. Zbuduj projekt:

   ```bash
   mvn clean install
   ```

3. Uruchom:

   ```bash
   mvn exec:java
   ```

---

## 🧠 Autor

Patryk Płatek
