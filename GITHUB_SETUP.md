# Інструкції для підключення до GitHub

## Крок 1: Створити репозиторій на GitHub

1. Перейти на: https://github.com/new
2. Назва репозиторію: `accident-insurance-model`
3. Description: "Модель страхування від нещасних випадків"
4. Public або Private (на вибір)
5. **НЕ додавати** README, .gitignore, license
6. Натиснути "Create repository"

## Крок 2: Підключити локальний репозиторій до GitHub

```bash
cd E:\Univer\AccidentInsuranceModel

# Додати remote (використовуючи SSH)
git remote add origin git@github.com:RomanBelitskiy/accident-insurance-model.git

# Або використовуючи HTTPS (якщо SSH не налаштовано)
# git remote add origin https://github.com/RomanBelitskiy/accident-insurance-model.git

# Перевірити remote
git remote -v

# Запушити гілки
git push -u origin master
git push -u origin develop
```

## Крок 3: Додати учасників

1. На GitHub: Settings → Collaborators → Add people
2. Додати:
   - `DogaStanislav`
   - `hlvl1123`
3. Вони отримають запрошення на email

## Крок 4: Створити Issues на GitHub

**Важливо**: Issues створюються на GitHub після того, як репозиторій підключено. 
Поки що Issues НЕ створені - їх потрібно створити вручну на GitHub.

### Issue #1: Створення репозиторію
- **Title**: Створення репозиторію для проекту в GitHub
- **Description**: Створити новий репозиторій на GitHub з назвою `accident-insurance-model` та налаштувати базову структуру проєкту.
- **Assignee**: @RomanBelitskiy
- **Labels**: `setup`, `documentation`

### Issue #2: Налаштування Gradle проєкту
- **Title**: Створення та налаштування вихідного коду мовою Java з Gradle
- **Description**: 
  - Створити структуру проєкту з Gradle
  - Налаштувати build.gradle та settings.gradle
  - Створити клас App.java з виведенням "Hello! It is a new project!!!"
  - Підключити проєкт до репозиторію
  - Створити гілки develop та master
- **Assignee**: @DogaStanislav
- **Labels**: `setup`, `gradle`, `java`

### Issue #3: Реалізація бізнес-логіки
- **Title**: Написати клас з бізнес-логіки (перша версія)
- **Description**: 
  - Створити клас `AccidentInsuranceCalculator`
  - Реалізувати методи для розрахунку страхової премії та виплат
  - Додати валідацію вхідних даних
- **Assignee**: @hlvl1123
- **Labels**: `feature`, `business-logic`

### Issue #4: Написання тестів
- **Title**: Написати тест до класу з бізнес-логіки
- **Description**: 
  - Створити клас `AccidentInsuranceCalculatorTest`
  - Написати юніт-тести для всіх методів калькулятора
  - Перевірити граничні випадки та обробку помилок
- **Assignee**: @RomanBelitskiy
- **Labels**: `test`, `quality`

## Крок 5: Workflow для учасників

### @DogaStanislav (Issue #2):

```bash
# Клонувати репозиторій
git clone git@github.com:RomanBelitskiy/accident-insurance-model.git
cd accident-insurance-model

# Налаштувати Git
git config user.name "DogaStanislav"
git config user.email "його_email@example.com"

# Створити гілку
git checkout develop
git checkout -b feature/gradle-setup-app

# Виконати зміни
# - Створити build.gradle
# - Створити settings.gradle
# - Створити src/main/java/com/example/insurance/App.java

# Закомітити та запушити
git add .
git commit -m "feat: налаштування Gradle проєкту та клас App"
git push origin feature/gradle-setup-app

# Створити Pull Request на GitHub
# Вказати: Closes #2
```

### @hlvl1123 (Issue #3):

```bash
# Клонувати репозиторій
git clone git@github.com:RomanBelitskiy/accident-insurance-model.git
cd accident-insurance-model

# Налаштувати Git
git config user.name "hlvl1123"
git config user.email "його_email@example.com"

# Створити гілку
git checkout develop
git checkout -b feature/insurance-calculator

# Виконати зміни
# - Створити src/main/java/com/example/insurance/AccidentInsuranceCalculator.java

# Закомітити та запушити
git add .
git commit -m "feat: реалізація AccidentInsuranceCalculator"
git push origin feature/insurance-calculator

# Створити Pull Request на GitHub
# Вказати: Closes #3
```

### @RomanBelitskiy (Issue #4):

```bash
# Оновити репозиторій
cd accident-insurance-model
git checkout develop
git pull origin develop

# Створити гілку
git checkout -b feature/calculator-tests

# Виконати зміни
# - Створити src/test/java/com/example/insurance/AccidentInsuranceCalculatorTest.java

# Закомітити та запушити
git add .
git commit -m "test: додано юніт-тести для AccidentInsuranceCalculator"
git push origin feature/calculator-tests

# Створити Pull Request на GitHub
# Вказати: Closes #4
```

## Крок 6: Merge Pull Requests

1. Merge в правильному порядку:
   - `feature/gradle-setup-app` → `develop` (перший)
   - `feature/insurance-calculator` → `develop` (другий)
   - `feature/calculator-tests` → `develop` (третій)

2. У кожному PR вказати: `Closes #<номер issue>`

3. Після merge всіх PR: merge `develop` → `master`

## Результат

Після цього в історії Git будуть коміти від різних учасників з різних комп'ютерів!
