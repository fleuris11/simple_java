# Utilise une image Java 17 comme base
   FROM openjdk:17-jre-slim

   # Définit le répertoire de travail
   WORKDIR /app

   # Copie les fichiers nécessaires
   COPY lib/ lib/
   COPY src/ src/
   COPY tests/ tests/
   COPY MANIFEST.MF .
   COPY Procfile .

   # Compile le code
   RUN javac -cp "lib/nanohttpd-2.3.1.jar" -d bin src/Calculator.java
   RUN jar cfm calculator.jar MANIFEST.MF bin/Calculator.class

   # Expose le port (dynamique via PORT)
   EXPOSE $PORT

   # Commande de démarrage
   CMD ["java", "-cp", "lib/nanohttpd-2.3.1.jar:bin", "Calculator"]