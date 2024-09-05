package main

import (
	"log"
	"net/http"
	"os"
	"path/filepath"
)

func main() {
	// Define the directory where the static files are present
	staticDir := filepath.Join("..", "..", "..", "customer-service-frontend", "public")

	// Check if the directory exists
	if _, err := os.Stat(staticDir); os.IsNotExist(err) {
		log.Fatalf("Static directory does not exist: %s", staticDir)
	}

	// Serve the customer-service.html when /buskart/ is accessed
	http.HandleFunc("/buskart/", func(w http.ResponseWriter, r *http.Request) {
		if r.URL.Path == "/buskart/" {
			// Serve the customer-service.html for the /buskart/ URL
			http.ServeFile(w, r, filepath.Join(staticDir, "customer-service.html"))
		} else {
			// Serve other static files normally
			http.FileServer(http.Dir(staticDir)).ServeHTTP(w, r)
		}
	})

	// Serve static files (CSS, images, etc.) from /assets/ correctly
	http.Handle("/assets/", http.StripPrefix("/assets/", http.FileServer(http.Dir(filepath.Join(staticDir, "assets")))))

	// Get the port from the environment or default to 8080
	port := os.Getenv("PORT")
	if port == "" {
		port = "8080"
	}

	log.Printf("Server is running on http://localhost:%s/", port)
	err := http.ListenAndServe(":"+port, nil)

	if err != nil {
		log.Fatalf("Could not start server: %s\n", err.Error())
	}
}
