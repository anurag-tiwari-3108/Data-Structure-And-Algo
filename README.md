# Data-Structure-And-Algo

A modern, modular, and user-friendly Java project for learning and practicing data structures and algorithms. Built with Maven, tested with JUnit, and ready for CI/CD.

## Features
- Organized by topic (arrays, trees, graphs, etc.)
- Modern Java (11+) features
- Unit tests with JUnit 5
- Easy build and run with Maven
- GitHub Actions for CI
- EditorConfig for consistent code style

## Project Structure
```
Data-Structure-And-Algo/
├── src/
│   └── main/java/com/codex/dsa/
│       ├── arrays/
│       ├── backtracking/
│       ├── binarysearchtree/
│       ├── bitwise/
│       ├── divideandconquer/
│       ├── dynamicprogramming/
│       ├── graphs/
│       ├── greedyalgorithms/
│       ├── hashmaps/
│       ├── linkedlists/
│       ├── matrices/
│       ├── stacks/
│       ├── strings/
│       ├── trees/
│       └── trie/
├── .github/workflows/ci.yml
├── .editorconfig
├── LICENSE
├── pom.xml
└── README.md
```

## Getting Started
1. **Clone the repository:**
   ```sh
   git clone <repo-url>
   cd Data-Structure-And-Algo
   ```
2. **Build the project:**
   ```sh
   mvn clean package
   ```
3. **Run tests:**
   ```sh
   mvn test
   ```
4. **Run a specific class:**
   ```sh
   mvn exec:java -Dexec.mainClass="com.codex.dsa.array.YourClassName"
   ```

## Contributing
- Fork the repo and create your branch
- Add new algorithms or improve existing ones
- Add or update tests in `src/test/java`
- Open a pull request

## License
MIT
