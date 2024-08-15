package main

import (
	"log"
	"net/http"
	"os"
	"path/filepath"
)






func main()  {
	// define the directory where the satic  file is presnt 

	//staticDir :="./buskart-customer-service/customer-service-frontend/public"

	staticDir := filepath.Join("..", "..", "..", "customer-service-frontend", "public")

	// Check if the directory exists
	if _, err := os.Stat(staticDir); os.IsNotExist(err) {
		log.Fatalf("Static directory does not exist: %s", staticDir)
	}

	// serve the satic file 

	http.Handle("/",http.FileServer(http.Dir(staticDir)))

	// get the port from the env of defalut 8080

	port := os.Getenv("PORT")

	if port == "" {
		port="8080"	
	}

	log.Printf("server is running on the http://localhost:%s/ ",port)
	err := http.ListenAndServe(":"+port , nil)

	if err != nil {
		log.Fatalf("Could not start server: %s\n", err.Error())
	}
}