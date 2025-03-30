# ProductApp


Architecture
├── app/                       # Main application module
│   ├── src/
│   │   ├── main/              # Production code
│   │   │   ├── java/com/example/productapp/
│   │   │   │   ├── di/       # Dependency Injection (Hilt/Koin)
│   │   │   │   ├── data/
│   │   │   │   │   ├── local/  # Room DB, DataStore
│   │   │   │   │   ├── remote/ # Retrofit, API services
│   │   │   │   │   └── repository/ 
│   │   │   │   ├── domain/    # Use Cases, Models
│   │   │   │   ├── presentation/
│   │   │   │   │   ├── ui/    # Activities/Fragments
│   │   │   │   │   ├── viewmodel/
│   │   │   │   │   └── adapter/ 
│   │   │   │   └── utils/     # Extensions, Helpers
│   │   │   └── res/           # Android resources
│   │   └── test/              # Unit tests
│   └── build.gradle.kts       # Module-level config
│

