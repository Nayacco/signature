# signature

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.htnova</groupId>
    <artifactId>example</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <repositories>
        <repository>
            <id>signature</id>
            <name>Signature Repository</name>
            <url>https://goldsubmarine.github.io/signature/maven-repo/</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.htnova</groupId>
            <artifactId>signature-server</artifactId>
            <version>1.0</version>
        </dependency>
    </dependencies>
</project>
```
