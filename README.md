# JavaSerializationUID
Java Serialization Simple Demo

This project is to demo how Java Serialization works.

Main Content:
1. A Employee Class that implements Serialization interface.
2. A static method to serialize a Employee object.
3. A static method to deSerialize a Employee object.

The purpose of this project is to help to understand Java default behavior in a POJO that implements Serialization interface.

1. When a POJO is defined to implements the Serialization interface, then a static final long serialVersionUID field is expected. If none is defined, then a internal default one will be assigned during compilation.

2. The purpose of the static final long serialVersionUID field is to track the version of the POJO class. This helps Java to determine if the POJO definition has changed between Serialization and DeSerialization.

3. To demonstrate, 
    a. Ensure the call to serializeObject() in the main method is uncommented.
    b. The Employee POJO's salary field and its getter/setter are commented.
    c. Run the main application, a file, employee.ser is created. This is the serialized file.
    d. The application will also show in the console the Employee has been serialized and deserialized, displaying its content.
    e. Now, we commented out the call to serializeObject() in the main method.
    f. We can run the main app again which now only do the deserialization successfully as per before.
    g. Now, in addition, we uncommented out the Employee POJO's portion of the salary info.
    h. Run the main app again, and it will run into a InvalidClassException, showing the serialVersionUID has different values.
    i. Since we did not specified any serialVersionUID in our POJO class, a default one has been provided during compilation. Every time the POJO definition is changed, the serialVersionUID value is also changed. So when we attempted to deserialize the object which was first created with a different serialVersionUID, Java will throw a InvalidClassException.
    
4. Demonstration with a defined serialVersionUID.
    a. Reset the codes to its original state, i.e. uncomment the call to serializeObject() in the main method.
    b. Comment out the Employee POJO's salary field and its getter/setter.
    c. Add the serialVersionUID, 'private static final long serialVersionUID = 1L;' to the POJO.
    d. Run the main app to serialize and deserialize the Employee object.
    e. Now as before, we will comment out the call to serializeObject() in the main method.
    f. As before, we will run the main app again and it should deserialize successfully as in previous demo.
    g. Again as before, we will uncomment the salary info of the Employee POJO.
    h. Now run the main app again, it should deserialize successfully instead of throwing exception like before. The reason is that we have defined our own serialVersionUID and we did not change its value when we made changes to our POJO. 
    
