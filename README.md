## How you can use

##### 1. You have to define how you want to map interfaces to their implementations.

```java
public class DependencyInjectionConfig extends AbstractModule {
    
    @Override
    public void configure() {
        createMapping(GreetingService.class, WelcomeServiceImpl.class);
        createMapping(Logger.class, QuietLoggerImpl.class);
    }
}
```

##### 2. Add **@OwnInject** annotation to constructor or field.


```java
public class FieldInjectionClient {
    
    @OwnInject
    private GreetingService service;
    
    @OwnInject
    private Logger logger;

}
```

##### 3. Use **OwnDi** to get your injected class.

```java
public class SampleAppToTryDependencyInjection {
    
    public static void main(final String[] args) throws Exception {
        final OwnDiFramework ownDi = OwnDi.getFramework(new DependencyInjectionConfig());
        final ConstructorInjectionClient constructorInjectionClient = (ConstructorInjectionClient) ownDi.inject(ConstructorInjectionClient.class);
    }

}
```

### How it works

The two main classes are **AbstractModule** and **OwnDiFramework**.
 
* The **AbstractModule** contains interfaces with their implementations (subclasses).
* The **OwnDiFramework** performs the injection via java reflection. It checks that the constructor or fields are annotated with **@OwnInject** annotation.
 
