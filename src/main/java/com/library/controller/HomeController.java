package com.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Library Management System</title>
                    <style>
                        body { font-family: Arial; background: #f4f4f9; padding: 40px; }
                        .container { max-width: 800px; margin: auto; background: white;
                                     padding: 30px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
                        h1 { color: #2c3e50; }
                        .endpoint { background: #ecf0f1; padding: 10px; margin: 10px 0;
                                    border-left: 4px solid #3498db; border-radius: 4px; }
                        code { background: #2c3e50; color: white; padding: 2px 6px; border-radius: 3px; }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h1>📚 Library Management System</h1>
                        <p>A simple Library Management System with full CI/CD pipeline integration.</p>
                        <h2>Available REST API Endpoints:</h2>
                        <div class="endpoint"><code>GET /api/books</code> - List all books</div>
                        <div class="endpoint"><code>GET /api/books/{id}</code> - Get book by ID</div>
                        <div class="endpoint"><code>POST /api/books</code> - Add a new book</div>
                        <div class="endpoint"><code>PUT /api/books/{id}</code> - Update book</div>
                        <div class="endpoint"><code>DELETE /api/books/{id}</code> - Delete book</div>
                        <div class="endpoint"><code>GET /api/books/available</code> - Get available books</div>
                        <div class="endpoint"><code>GET /api/books/health</code> - Health check</div>
                        <h2>DevOps Tools Integrated:</h2>
                        <ul>
                            <li>✅ Git - Version Control</li>
                            <li>✅ Jenkins - CI/CD Pipeline</li>
                            <li>✅ Maven - Build Tool</li>
                            <li>✅ Docker - Containerization</li>
                            <li>✅ Kubernetes - Container Orchestration</li>
                            <li>✅ Ansible - Configuration Management</li>
                        </ul>
                    </div>
                </body>
                </html>
                """;
    }
}
