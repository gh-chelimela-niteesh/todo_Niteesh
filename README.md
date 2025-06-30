# 📝 Task Manager

## 📌 Project Description

A full-stack to-do list web application where users can register, log in, and manage their personal tasks. Tasks can be added with priorities and due dates, filtered, marked complete, and deleted. The interface supports both light and dark themes.

---

## 💻 Installation Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/gh-chelimela-niteesh/todo_Niteesh.git
cd todo_Niteesh
```

### 2. Backend Setup (Spring Boot)

```bash
cd backend
# Open in your IDE (e.g., Eclipse or IntelliJ)
# Configure your MySQL DB credentials in application.properties
# Run the TodoApplication.java file
```

### 3. Frontend Setup (React)

```bash
cd frontend
npm install
npm start
```

---

## 🚀 How to Run the Project

1. **Start MySQL** and create a database named `todo_auth`
2. **Run the backend** with your IDE or command line
3. **Run the frontend** with `npm start` from the frontend folder
4. Open [http://localhost:3000](http://localhost:3000) in your browser

---

## ✨ Features

* 👤 User Authentication (Register & Login)
* 🌙 Dark and Light Mode toggle
* 📝 Add new tasks with:

  * Title
  * Priority (Low, Moderate, High)
  * Due Date (Calendar picker)
* ✅ Mark tasks as completed
* 🗑️ Delete tasks
* ✏️ Edit tasks
* 🔍 Search tasks
* 🔃 Filter by All / Completed / Pending
* 🆙 Sort tasks by priority (Low → High / High → Low)
* 📈 Task progress bar
* 🚪 Logout
* 📦 Data persistence with backend (MySQL + Spring Boot)

---

## 🧑‍💻 Usage

* Register a new account or log in.
* Add your tasks.
* Use the filters and search bar to manage your workflow.
* Switch between light and dark mode using the toggle.
* Click "Logout" to securely exit.

---

## 🛠️ Technologies Used

* **Frontend**: React.js, Tailwind CSS
* **Backend**: Java, Spring Boot
* **Database**: MySQL
* **Tools**: Git, GitHub, Postman, VS Code, Eclipse

---

## 🤖 How GitHub Copilot Was Used

GitHub Copilot helped auto-generate reusable functions, validate input, create REST APIs quickly, and suggest efficient React code patterns. It also assisted with naming conventions and improving code readability.

---

## 📂 Project Structure

```
todo_Niteesh/
├── backend/
│   ├── src/main/java/com/todo/...
│   └── application.properties
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── TodoForm.js
│   │   │   ├── TodoItem.js
│   │   │   └── TodoApp.js
│   │   └── App.js
│   └── package.json
└── README.md
```

---

> Built with ❤️ by Niteesh Chelimela
