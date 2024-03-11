
## To run the project
```bash
#Compile
javac -d classes GetHeapSize.java

#Run
java -cp classes GetHeapSize

#Compile and Run
javac -d classes GetHeapSize.java && java -cp classes GetHeapSize
# Out 1.0 GiB

javac -d classes GetHeapSize.java && java -cp -Xms512m -Xmx4096m classes GetHeapSize
# Out 512.0 MiB
```
