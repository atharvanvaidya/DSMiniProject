# DSMiniProject

Steps to run this project
1. Compile all Java Files
```
javac *.java
```
2. Compile `AirlineImpl` using the <a href="https://docs.oracle.com/javase/7/docs/technotes/tools/windows/rmic.html">RMI</a> Compiler
```
rmic AirlineImpl
```
3. Start the RMI Server

  - **For Windows**
```
start rmiregistry
```
  - **For Linux**
```
rmiregistry
```
4. Run the Server
```
java -cp ".:your-msql-connector.jar" AirlineServer
```
5. Run the Client
```
java AirlineClient
```
