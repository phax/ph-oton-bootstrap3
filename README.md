# ph-oton-bootstrap3

This set of Java libraries forms a package to build Java web applications.

Contained subprojects are:
  * ph-oton-bootstrap3 - Java Wrapper for the Bootstrap 3.x controls
  * ph-oton-bootstrap3-uictrls - special UI controls for Bootstrap 3
  * ph-oton-bootstrap3-pages - predefined UI pages with Bootstrap 3 styling
  * ph-oton-bootstrap3-stub - Servlet stub for Bootstrap 3 web applications
  * ph-oton-bootstrap3-demo - a standalone demo web application to be run in Tomcat or in provided Jetty

# Requirements

* Java 11+ is required for building 
* Application server requirements:
    * At least Tomcat 10.x
    * Jetty 11.x with AnnotationConfiguration enabled
      
## Maven usage

Replace `x.y.z` with the effective version number.

```xml
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>com.helger.photon</groupId>
        <artifactId>ph-oton-bootstrap3-parent-pom</artifactId>
        <version>x.y.z</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>
```

### Bootstrap 3

To use Bootstrap 3 front end use:

```xml
  <dependencies>
    <dependency>
      <groupId>com.helger.photon</groupId>
      <artifactId>ph-oton-bootstrap3-stub</artifactId>
    </dependency>
  </dependencies>
```

See the submodule `ph-oton-bootstrap3-demo` for a working example project with Bootstrap 3 UI.

## News and noteworthy

* v9.2.3 - Initial version
    * Extracted from ph-oton

---

My personal [Coding Styleguide](https://github.com/phax/meta/blob/master/CodingStyleguide.md) |
It is appreciated if you star the GitHub project if you like it.